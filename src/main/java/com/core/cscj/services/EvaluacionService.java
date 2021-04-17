package com.core.cscj.services;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Entidades;
import com.core.cscj.models.requests.EvaluacionRequest;
import com.core.cscj.models.requests.OpcionRequest;
import com.core.cscj.models.requests.OrdenArchivosAdjuntosRequest;
import com.core.cscj.models.requests.TemaRequest;
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
    private ArchivosAdjuntosRepo archivosAdjuntosRepo;

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private FileStorageService fileStorageService;

    public EvaluacionResponse findEvaluacionByIdWithoutAlumnoDataAndRespuestas(Integer idEvaluacion){
        Optional<Evaluacion> evaluacionOptional = evaluacionRepo.findById(idEvaluacion);

        Evaluacion evaluacion;
        List<ArchivosAdjuntos> archivosAdjuntos = new ArrayList<>();

        if(!evaluacionOptional.isPresent()) {
            return new EvaluacionResponse();
        }

        evaluacion = evaluacionOptional.get();

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

    public EvaluacionResponse upsertEvaluacion(Integer idAsignatura, EvaluacionRequest evaluacionRequest, MultipartFile[] files){
        Optional<Asignatura> asignaturaOptional = asignaturaRepo.findById(idAsignatura);

        if(!asignaturaOptional.isPresent()) return new EvaluacionResponse();

        Asignatura asignatura = asignaturaOptional.get();

        Evaluacion evaluacionToStore;
        List<ArchivosAdjuntos> archivosAdjuntos = new ArrayList<>();

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
            evaluacionToStore.getTemas().stream().forEach(
                    tema -> archivosAdjuntos.addAll(archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.TEMA.name(), tema.getId()))
            );
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

        if (evaluacionStored.getTemas() != null)
            evaluacionStored.getTemas()
                    .forEach(
                            tema -> deleteTemaAndOpciones(tema)
                    );

        evaluacionStored.setTemas(null);

        Evaluacion evaluacionStoredWithEmptyTemas = evaluacionRepo.save(evaluacionToStore);

        Set<Tema> temas = evaluacionRequest.getTemas().stream().map(
                temaRequest -> createTema(temaRequest, evaluacionStoredWithEmptyTemas)
        ).collect(Collectors.toSet());

        evaluacionStoredWithEmptyTemas.setTemas(temas);
        Evaluacion evaluacionFinal = evaluacionRepo.save(evaluacionStoredWithEmptyTemas);

        return new EvaluacionResponse(
                evaluacionFinal,
                evaluacionFinal.getAsignatura().getCurso(),
                evaluacionFinal.getTemas().stream().map(
                        tema -> new TemaResponse(
                                tema,
                                //Aca guardar los archivos adjuntos con formato en nombres de ordenTema:ordenArchivo
                                fileStorageService.uploadNotRepeatedFilesWihtFormatName(
                                        Entidades.TEMA.name(),
                                        tema.getId(),
                                        archivosAdjuntos,
                                        evaluacionRequest.getTemas().stream().map(
                                                temaRequest -> new OrdenArchivosAdjuntosRequest(temaRequest.getOrden(), temaRequest.getArchivosAdjuntos())
                                        ).collect(Collectors.toList()),
                                        tema.getOrden(),
                                        files
                                )
                        )
                ).sorted().collect(Collectors.toList())
        );
    }

    private void deleteTemaAndOpciones(Tema tema){
        tema.getOpciones()
                .forEach(
                        opcion -> opcionRepo.delete(opcion)
                );

        tema.setOpciones(null);

        Tema temaStored = temaRepo.save(tema);
        temaRepo.delete(temaStored);
    }

    private Tema createTema(TemaRequest temaRequest, Evaluacion evaluacionStored){
        Tema temaToStore = new Tema();
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

        return temaRepo.save(temaToStore);
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
}
