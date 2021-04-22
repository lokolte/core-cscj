package com.core.cscj.services;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Entidades;
import com.core.cscj.models.requests.*;
import com.core.cscj.models.responses.*;
import com.core.cscj.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EvaluacionService {
    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @Autowired
    private EvaluacionRepo evaluacionRepo;

    @Autowired
    private TemaRepo temaRepo;

    @Autowired
    private OpcionRepo opcionRepo;

    @Autowired
    private RespuestaRepo respuestaRepo;

    @Autowired
    private RespuestaTemaRepo respuestaTemaRepo;

    @Autowired
    private RespuestaOpcionRepo respuestaOpcionRepo;

    @Autowired
    private ArchivosAdjuntosRepo archivosAdjuntosRepo;

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private FileStorageService fileStorageService;

    public EvaluacionResponse comenzarTerminarExamen(Integer idEvaluacion, Boolean habilitado) {
        Optional<Evaluacion> evaluacionOptional = evaluacionRepo.findById(idEvaluacion);

        Evaluacion evaluacion;

        if(!evaluacionOptional.isPresent()) return new EvaluacionResponse();

        evaluacion = evaluacionOptional.get();

        if((evaluacion.getInicioDate() == null) && habilitado)
            evaluacion.setInicioDate(new Timestamp(new Date().getTime()));
        else if((evaluacion.getFinDate() == null) && !habilitado)
            evaluacion.setFinDate(new Timestamp(new Date().getTime()));
        else throw new IllegalArgumentException("No se puede habilitar o deshabilitar una prueba que ya se habilito o deshabilito respectivamente.");

        evaluacion.setHabilitado(habilitado);

        Evaluacion evaluacionStored = evaluacionRepo.save(evaluacion);

        return  createEvaluacionResponse(evaluacionStored);
    }

    private EvaluacionResponse createEvaluacionResponse(Evaluacion evaluacion){
        List<ArchivosAdjuntos> archivosAdjuntos = new ArrayList<>();

        evaluacion.getTemas().stream().forEach(
                tema -> archivosAdjuntos.addAll(archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.TEMA.name(), tema.getId()))
        );

        return new EvaluacionResponse(
                evaluacion,
                evaluacion.getAsignatura().getCurso(),
                evaluacion.getTemas().stream().map(
                        tema -> new TemaResponse(
                                tema,
                                archivosAdjuntos.stream().filter(
                                        archivoAdjunto -> archivoAdjunto.getIdEntidad() == tema.getId()
                                ).collect(Collectors.toList())
                        )
                ).sorted().collect(Collectors.toList())
        );
    }

    public EvaluacionResponse findEvaluacionResponseById(Integer idEvaluacion){
        Optional<Evaluacion> evaluacionOptional = evaluacionRepo.findById(idEvaluacion);

        if(!evaluacionOptional.isPresent()) {
            return new EvaluacionResponse();
        }

        return createEvaluacionResponse(evaluacionOptional.get());
    }

    public EvaluacionResponse upsertEvaluacion(Integer idAsignatura, EvaluacionRequest evaluacionRequest, MultipartFile[] files){
        Optional<Asignatura> asignaturaOptional = asignaturaRepo.findById(idAsignatura);

        if(!asignaturaOptional.isPresent()) return new EvaluacionResponse();

        Asignatura asignatura = asignaturaOptional.get();

        Evaluacion evaluacionToStore;
        HashMap<Integer, List<ArchivosAdjuntos>> archivosAdjuntos = new HashMap<>();

        Optional<Evaluacion> evaluacionOptional = Optional.empty();
        if(evaluacionRequest.getId() != null)
            evaluacionOptional = evaluacionRepo.findById(evaluacionRequest.getId());

        if(!evaluacionOptional.isPresent()) {
            evaluacionToStore = new Evaluacion();
            evaluacionToStore.setAsignatura(asignatura);
            evaluacionToStore.setCreationDate(new Timestamp(new Date().getTime()));
            evaluacionToStore.setHabilitado(false);
        } else {
            evaluacionToStore = evaluacionOptional.get();
            evaluacionToStore.setLastModifiedDate(new Timestamp(new Date().getTime()));

            if (evaluacionToStore.getTemas() != null) {
                List<Integer> temasToDelete = new ArrayList<>();
                HashMap<Integer, Tema> temasStored = new HashMap<>();
                HashMap<Integer, TemaRequest> temasRequests = new HashMap<>();

                evaluacionToStore.getTemas().forEach(
                        tema -> {
                            archivosAdjuntos.put(tema.getId(), archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.TEMA.name(), tema.getId()));
                            temasStored.put(tema.getId(), tema);
                        }
                );

                evaluacionRequest.getTemas().forEach(
                        temaRequest -> {
                            if(temaRequest.getId() != null){
                                temasRequests.put(temaRequest.getId(), temaRequest);
                                if(temaRequest.getArchivosAdjuntos() != null && temaRequest.getArchivosAdjuntos().size() > 0
                                        && temaRequest.getArchivosAdjuntos().stream()
                                        .filter(archivoAdjunto -> archivoAdjunto.getOrden() != null).collect(Collectors.toList()).size() > 0) {
                                    if(archivosAdjuntos.get(temaRequest.getId()) != null){
                                        archivosAdjuntos.get(temaRequest.getId())
                                                .forEach(
                                                        archivoAdjunto -> {
                                                            fileStorageService.deleteFile(Entidades.TEMA.name(), temaRequest.getId(), archivoAdjunto);
                                                            archivosAdjuntosRepo.delete(archivoAdjunto);
                                                        }
                                                );
                                        archivosAdjuntos.remove(temaRequest.getId());
                                    }
                                }
                            }
                        }
                );

                temasStored.values().forEach(
                        tema -> {
                            if(temasRequests.get(tema.getId()) == null) {
                                if(archivosAdjuntos.get(tema.getId()) != null) {
                                    archivosAdjuntos.get(tema.getId())
                                            .forEach(
                                                    archivoAdjunto -> {
                                                        fileStorageService.deleteFile(Entidades.TEMA.name(), tema.getId(), archivoAdjunto);
                                                        archivosAdjuntosRepo.delete(archivoAdjunto);
                                                    }
                                            );
                                    archivosAdjuntos.remove(tema.getId());
                                }
                                temaRepo.delete(deleteOpcionesFromTema(tema));
                                temasToDelete.add(tema.getId());
                            }
                        }
                );

                temasToDelete.forEach(
                        idTema -> temasStored.remove(idTema)
                );

                evaluacionToStore.setTemas(new HashSet<>(temasStored.values()));
            }
        }

        evaluacionToStore.setNombre(evaluacionRequest.getNombre());
        evaluacionToStore.setEtapa(evaluacionRequest.getEtapa());
        evaluacionToStore.setTipoInstrumento(evaluacionRequest.getTipoInstrumento());
        evaluacionToStore.setCapacidades(evaluacionRequest.getCapacidades());
        evaluacionToStore.setIndicadores(evaluacionRequest.getIndicadores());
        evaluacionToStore.setInstrucciones(evaluacionRequest.getInstrucciones());
        evaluacionToStore.setTipoActividad(Entidades.EVALUACION.name());
        evaluacionToStore.setOrden(asignaturaService.getNextOrder(idAsignatura));
        evaluacionToStore.setFecha(evaluacionRequest.getFecha());
        evaluacionToStore.setInicio(evaluacionRequest.getInicio());
        evaluacionToStore.setFin(evaluacionRequest.getFin());
        evaluacionToStore.setTotalPuntos(evaluacionRequest.getTotalPuntos());
        evaluacionToStore.setHsCatedra(evaluacionRequest.getHsCatedra());
        evaluacionToStore.setMinsCatedra(evaluacionRequest.getMinsCatedra());

        Evaluacion evaluacionStored = evaluacionRepo.save(evaluacionToStore);

        Set<Tema> temas = evaluacionRequest.getTemas().stream().map(
                temaRequest -> upsertTema(temaRequest, evaluacionStored)
        ).collect(Collectors.toSet());

        evaluacionStored.setTemas(temas);
        Evaluacion evaluacionFinal = evaluacionRepo.save(evaluacionStored);

        List<ArchivosAdjuntos> archivosAdjuntosFinal = new ArrayList<>();
        archivosAdjuntos.values()
                .forEach(
                        archivosAdjuntosList -> archivosAdjuntosFinal.addAll(archivosAdjuntosList)
                );

        return new EvaluacionResponse(
                evaluacionFinal,
                evaluacionFinal.getAsignatura().getCurso(),
                evaluacionFinal.getTemas().stream().map(
                        tema -> new TemaResponse(
                                tema,
                                //Aca guardar los archivos adjuntos con formato en nombres de ordenTema:ordenArchivo
                                (files != null && files.length > 0) ?
                                        Stream.concat(
                                                fileStorageService.uploadMultipleFilesWihtFormatName(
                                                        Entidades.TEMA.name(),
                                                        tema.getId(),
                                                        evaluacionRequest.getTemas().stream().map(
                                                                temaRequest -> new OrdenArchivosAdjuntosRequest(temaRequest.getOrden(), temaRequest.getArchivosAdjuntos())
                                                        ).collect(Collectors.toList()),
                                                        tema.getOrden(),
                                                        files
                                                ).stream(),
                                                archivosAdjuntosFinal.stream()
                                                    .filter(
                                                            archivoAdjunto -> tema.getId() == archivoAdjunto.getIdEntidad()
                                                    )
                                        ).collect(Collectors.toList())
                                        : archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.TEMA.name(), tema.getId())
                        )
                ).sorted().collect(Collectors.toList())
        );
    }

    private Tema deleteOpcionesFromTema(Tema tema){
        tema.getOpciones()
                .forEach(
                        opcion -> opcionRepo.delete(opcion)
                );

        tema.setOpciones(null);

        return temaRepo.save(tema);
    }

    private Tema upsertTema(TemaRequest temaRequest, Evaluacion evaluacionStored){
        Optional<Tema> temaOptional = Optional.empty();
        if(temaRequest.getId() != null)
            temaOptional= temaRepo.findById(temaRequest.getId());

        Tema temaToStore;
        if(temaOptional.isPresent()) {
            temaToStore = deleteOpcionesFromTema(temaOptional.get());
        } else temaToStore = new Tema();

        temaToStore.setEvaluacion(evaluacionStored);
        temaToStore.setSentencia(temaRequest.getSentencia());
        temaToStore.setPuntos(temaRequest.getPuntos());
        temaToStore.setTipoTema(temaRequest.getTipoTema());
        temaToStore.setPermitirAdjuntos(temaRequest.getPermitirAdjuntos());
        temaToStore.setOrden(temaRequest.getOrden());

        Tema temaStored = temaRepo.save(temaToStore);

        Set<Opcion> opciones = temaRequest.getOpciones().stream().map(
                opcionRequest -> createOpcion(opcionRequest, temaStored)
        ).collect(Collectors.toSet());

        temaStored.setOpciones(opciones);

        return temaRepo.save(temaStored);
    }

    private Opcion createOpcion(OpcionRequest opcionRequest, Tema temaStored){
        Opcion opcionToStore = new Opcion();
        opcionToStore.setTema(temaStored);
        opcionToStore.setTexto(opcionRequest.getTexto());
        opcionToStore.setPrincipal(opcionRequest.getPrincipal());
        opcionToStore.setOrden(opcionRequest.getOrden());

        Opcion opcionStored = opcionRepo.save(opcionToStore);

        return opcionStored;
    }

    public RespuestaResponse upsertRespuesta(String document, Integer idEvaluacion, RespuestaRequest respuestaRequest, MultipartFile[] files) {
        Optional<Evaluacion> evaluacionOptional = evaluacionRepo.findById(idEvaluacion);
        if(!evaluacionOptional.isPresent()) return new RespuestaResponse();

        Evaluacion evaluacion = evaluacionOptional.get();

        Person alumno = personRepo.findByDocument(document);
        if(alumno == null) return new RespuestaResponse();

        Respuesta respuestaToStore;
        HashMap<Integer, List<ArchivosAdjuntos>> archivosAdjuntos = new HashMap<>();

        Optional<Respuesta> respuestaOptional = Optional.empty();
        if(respuestaRequest.getId() != null)
            respuestaOptional = respuestaRepo.findById(respuestaRequest.getId());

        if(!respuestaOptional.isPresent()) {
            respuestaToStore = new Respuesta();
            respuestaToStore.setAlumno(alumno);
            respuestaToStore.setEvaluacion(evaluacion);
            respuestaToStore.setCreationDate(new Timestamp(new Date().getTime()));
        } else {
            respuestaToStore = respuestaOptional.get();
            respuestaToStore.setLastModifiedDate(new Timestamp(new Date().getTime()));

            if (respuestaRequest.getRespuestasTemas() != null) {
                List<Integer> temasToDelete = new ArrayList<>();
                HashMap<Integer, RespuestaTema> respuestasTemasStored = new HashMap<>();
                HashMap<Integer, RespuestaTemaRequest> respuestasTemasRequests = new HashMap<>();

                respuestaToStore.getRespuestaTemas().forEach(
                        respuestaTema -> {
                            archivosAdjuntos.put(respuestaTema.getId(), archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.RESPUESTA_TEMA.name(), respuestaTema.getId()));
                            respuestasTemasStored.put(respuestaTema.getId(), respuestaTema);
                        }
                );

                respuestaRequest.getRespuestasTemas().forEach(
                        respuestaTemaRequest -> {
                            if(respuestaTemaRequest.getId() != null){
                                respuestasTemasRequests.put(respuestaTemaRequest.getId(), respuestaTemaRequest);
                                if(respuestaTemaRequest.getArchivosAdjuntos() != null && respuestaTemaRequest.getArchivosAdjuntos().size() > 0
                                        && respuestaTemaRequest.getArchivosAdjuntos().stream()
                                        .filter(archivoAdjunto -> archivoAdjunto.getOrden() != null).collect(Collectors.toList()).size() > 0) {
                                    if(archivosAdjuntos.get(respuestaTemaRequest.getId()) != null){
                                        archivosAdjuntos.get(respuestaTemaRequest.getId())
                                                .forEach(
                                                        archivoAdjunto -> {
                                                            fileStorageService.deleteFile(Entidades.RESPUESTA_TEMA.name(), respuestaTemaRequest.getId(), archivoAdjunto);
                                                            archivosAdjuntosRepo.delete(archivoAdjunto);
                                                        }
                                                );
                                        archivosAdjuntos.remove(respuestaTemaRequest.getId());
                                    }
                                }
                            }
                        }
                );

                respuestasTemasStored.values().forEach(
                        respuestaTema -> {
                            if(respuestasTemasRequests.get(respuestaTema.getId()) == null) {
                                if(archivosAdjuntos.get(respuestaTema.getId()) != null) {
                                    archivosAdjuntos.get(respuestaTema.getId())
                                            .forEach(
                                                    archivoAdjunto -> {
                                                        fileStorageService.deleteFile(Entidades.RESPUESTA_TEMA.name(), respuestaTema.getId(), archivoAdjunto);
                                                        archivosAdjuntosRepo.delete(archivoAdjunto);
                                                    }
                                            );
                                    archivosAdjuntos.remove(respuestaTema.getId());
                                }
                                respuestaTemaRepo.delete(deleteRespuestaOpcionesFromRespuestaTema(respuestaTema));
                                temasToDelete.add(respuestaTema.getId());
                            }
                        }
                );

                temasToDelete.forEach(
                        idTema -> respuestasTemasStored.remove(idTema)
                );

                respuestaToStore.setRespuestaTemas(new HashSet<>(respuestasTemasStored.values()));
            }
        }

        Respuesta respuestaStored = respuestaRepo.save(respuestaToStore);

        Set<RespuestaTema> respuestaTemas = respuestaRequest.getRespuestasTemas().stream().map(
                respuestaTemaRequest -> upsertRespuestaTema(respuestaTemaRequest, respuestaStored)
        ).collect(Collectors.toSet());

        respuestaStored.setRespuestaTemas(respuestaTemas);
        Respuesta respuestaStoredFinal = respuestaRepo.save(respuestaStored);

        List<ArchivosAdjuntos> archivosAdjuntosFinal = new ArrayList<>();
        archivosAdjuntos.values()
                .forEach(
                        archivosAdjuntosList -> archivosAdjuntosFinal.addAll(archivosAdjuntosList)
                );

        return new RespuestaResponse(
                createEvaluacionResponse(evaluacion),
                new RespuestaItemResponse(
                        respuestaStoredFinal.getId(),
                        respuestaStoredFinal.getCreationDate(),
                        respuestaStoredFinal.getLastModifiedDate(),
                        respuestaStoredFinal.getAlumno(),
                        respuestaStoredFinal.getRespuestaTemas().stream().map(
                                respuestaTema ->
                                        new RespuestaTemaResponse(
                                                new RespuestaTemaItemResponse(
                                                        respuestaTema.getId(),
                                                        respuestaTema.getTema().getId(),
                                                        respuestaTema.getOrden(),
                                                        respuestaTema.getTexto(),
                                                        respuestaTema.getRespuestaOpciones().stream().map(
                                                                respuestaOpcion ->
                                                                        new RespuestaOpcionResponse(
                                                                                respuestaOpcion.getId(),
                                                                                respuestaOpcion.getOpcion().getId(),
                                                                                respuestaOpcion.getTexto()
                                                                        )
                                                        ).collect(Collectors.toList())
                                                ),
                                                //Aca guardar los archivos adjuntos con formato en nombres de ordenRespuestaTema:ordenArchivo
                                                (files != null && files.length > 0) ?
                                                        Stream.concat(
                                                                fileStorageService.uploadMultipleFilesWihtFormatName(
                                                                        Entidades.RESPUESTA_TEMA.name(),
                                                                        respuestaTema.getId(),
                                                                        respuestaRequest.getRespuestasTemas().stream().map(
                                                                                respuestaTemaRequest -> new OrdenArchivosAdjuntosRequest(respuestaTemaRequest.getOrden(), respuestaTemaRequest.getArchivosAdjuntos())
                                                                        ).collect(Collectors.toList()),
                                                                        respuestaTema.getOrden(),
                                                                        files
                                                                ).stream(),
                                                                archivosAdjuntosFinal.stream()
                                                                        .filter(
                                                                                archivoAdjunto -> respuestaTema.getId() == archivoAdjunto.getIdEntidad()
                                                                        )
                                                        ).collect(Collectors.toList())
                                                        : archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.RESPUESTA_TEMA.name(), respuestaTema.getId())
                                        )
                        ).sorted().collect(Collectors.toList())
                )
        );
    }

    private RespuestaTema deleteRespuestaOpcionesFromRespuestaTema(RespuestaTema respuestaTema){
        respuestaTema.getRespuestaOpciones()
                .forEach(
                        respuestaOpcion -> respuestaOpcionRepo.delete(respuestaOpcion)
                );

        respuestaTema.setRespuestaOpciones(null);

        return respuestaTemaRepo.save(respuestaTema);
    }

    private RespuestaTema upsertRespuestaTema(RespuestaTemaRequest respuestaTemaRequest, Respuesta respuestaStored){
        Optional<RespuestaTema> respuestaTemaOptional = Optional.empty();
        if(respuestaTemaRequest.getId() != null)
            respuestaTemaOptional = respuestaTemaRepo.findById(respuestaTemaRequest.getId());

        RespuestaTema respuestaTemaToStore;

        if(respuestaTemaOptional.isPresent()) {
            respuestaTemaToStore = deleteRespuestaOpcionesFromRespuestaTema(respuestaTemaOptional.get());
        } else respuestaTemaToStore = new RespuestaTema();

        respuestaTemaToStore.setRespuesta(respuestaStored);
        respuestaTemaToStore.setTema(temaRepo.findById(respuestaTemaRequest.getIdTema()).get());
        respuestaTemaToStore.setOrden(respuestaTemaRequest.getOrden());
        respuestaTemaToStore.setTexto(respuestaTemaRequest.getTexto());

        RespuestaTema respuestaTemaStored = respuestaTemaRepo.save(respuestaTemaToStore);

        Set<RespuestaOpcion> opciones = respuestaTemaRequest.getOpciones().stream().map(
                opcionRequest -> createRespuestaOpcion(opcionRequest, respuestaTemaStored)
        ).collect(Collectors.toSet());

        respuestaTemaStored.setRespuestaOpciones(opciones);

        return respuestaTemaRepo.save(respuestaTemaStored);
    }

    private RespuestaOpcion createRespuestaOpcion(RespuestaOpcionRequest respuestaOpcionRequest, RespuestaTema respuestaTemaStored){
        RespuestaOpcion respuestaOpcionToStore = new RespuestaOpcion();
        respuestaOpcionToStore.setRespuestaTema(respuestaTemaStored);
        respuestaOpcionToStore.setOpcion(opcionRepo.findById(respuestaOpcionRequest.getIdOpcion()).get());
        respuestaOpcionToStore.setTexto(respuestaOpcionRequest.getTexto());

        RespuestaOpcion respuestaOpcionStored = respuestaOpcionRepo.save(respuestaOpcionToStore);

        return respuestaOpcionStored;
    }
}
