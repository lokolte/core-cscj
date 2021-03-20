package com.core.cscj.services;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Entidades;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.models.responses.EntregaResponse;
import com.core.cscj.models.responses.EntregasResponse;
import com.core.cscj.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EntregaService {
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private TareaRepo tareaRepo;

    @Autowired
    private EntregaRepo entregaRepo;

    @Autowired
    private DevolucionRepo devolucionRepo;

    @Autowired
    private ArchivosAdjuntosRepo archivosAdjuntosRepo;

    @Autowired
    private FileStorageService fileStorageService;

    public EntregaResponse upsertEntrega(String document, Integer idTarea, MultipartFile[] files){
        // Get current alumno and return empty if alumno doesn't exist
        Person alumno = personRepo.findByDocument(document);
        if(alumno == null) return new EntregaResponse();

        // Get current tarea and return empty if tarea doesn't exist
        Optional<Tarea> tarea = tareaRepo.findById(idTarea);
        if(!tarea.isPresent()) return new EntregaResponse();

        Entrega entregaToStore = entregaRepo.findEntregaByIdAlumnoAndIdTarea(alumno.getId(), idTarea);

        if(entregaToStore == null) {
            entregaToStore = new Entrega();
            entregaToStore.setCreationDate(new Timestamp(new Date().getTime()));
        } else entregaToStore.setLastModifiedDate(new Timestamp(new Date().getTime()));

        entregaToStore.setFechaEntrega(new Timestamp(new Date().getTime()));
        entregaToStore.setAlumno(alumno);
        entregaToStore.setTarea(tarea.get());

        entregaToStore = entregaRepo.save(entregaToStore);

        List<ArchivosAdjuntos> archivosAdjuntos = archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.ENTREGA.name(), entregaToStore.getId());

        return new EntregaResponse(
                entregaToStore,
                fileStorageService.uploadNotRepeatedFiles(
                        Entidades.ENTREGA.name(),
                        entregaToStore.getId(),
                        archivosAdjuntos,
                        files
                )
        );
    }

    public EntregasResponse findAllEntregasByIdTarea(Integer idTarea){
        // Get current tarea and return empty if tarea doesn't exist
        Optional<Tarea> tarea = tareaRepo.findById(idTarea);
        if(!tarea.isPresent()) return new EntregasResponse();

        Curso curso = tarea.get().getAsignatura().getCurso();

        // get all alumnos from the curso, excluding proferoes, coordinadores, tutores and admin, only alumno is accepted
        List<Person> alumnos = curso.getPersons()
                .stream().collect(Collectors.toList())
                .stream().filter(
                        alumnoItem ->
                                alumnoItem.getAccounts().stream().collect(Collectors.toList())
                                        .get(0)
                                        .getRoles().stream().collect(Collectors.toList())
                                        .stream().map(
                                                role -> role.getName()
                                        ).collect(Collectors.toList())
                                        .contains(Roles.ALUMNO.name())
                ).collect(Collectors.toList());

        List<Entrega> entregas = entregaRepo.findEntregasByIdTarea(idTarea);

        HashMap<Integer, EntregaResponse> entregasFinalMap = new HashMap<>();

        entregas.forEach(
                entrega ->
                        entregasFinalMap
                                .put(
                                        entrega.getAlumno().getId(),
                                        new EntregaResponse(
                                                entrega,
                                                archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.ENTREGA.name(), entrega.getId())
                                        )
                                )
        );

        for(Person alumno : alumnos) {
            EntregaResponse entregaObtenida = entregasFinalMap.get(alumno.getId());
            if (entregaObtenida == null){
                Entrega newEntrega = new Entrega();
                newEntrega.setFechaEntrega(null);
                newEntrega.setTarea(tarea.get());
                newEntrega.setAlumno(alumno);
                entregasFinalMap.put(alumno.getId(), new EntregaResponse(newEntrega, new ArrayList<>()));
            }
        }

        return new EntregasResponse(
                tarea.get(),
                entregasFinalMap.entrySet().stream().map(entregaMapItem -> entregaMapItem.getValue()).sorted().collect(Collectors.toList())
        );
    }

    public EntregaResponse upsertEntregaDevolucion(Integer idEntrega, Devolucion devolucion){
        Optional<Entrega> entregaOptional = entregaRepo.findById(idEntrega);

        if(!entregaOptional.isPresent()) return new EntregaResponse();

        Entrega entrega = entregaOptional.get();

        Devolucion devolucionToStore = entrega.getDevolucion();

        if(devolucionToStore == null) {
            devolucionToStore = new Devolucion();
            devolucionToStore.setCreationDate(new Timestamp(new Date().getTime()));
        } else devolucionToStore.setLastModifiedDate(new Timestamp(new Date().getTime()));

        devolucionToStore.setPuntaje(devolucion.getPuntaje());
        devolucionToStore.setObservaciones(devolucion.getObservaciones());
        devolucionToStore.setEntrega(entrega);
        entrega.setDevolucion(devolucionToStore);

        devolucionRepo.save(devolucionToStore);
        entrega = entregaRepo.save(entrega);

        List<ArchivosAdjuntos> archivosAdjuntos = archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.ENTREGA.name(), entrega.getId());

        return new EntregaResponse(
                entrega,
                archivosAdjuntos
        );
    }

    public Devolucion findEntregaDevolucion(Integer idEntrega) {
        Optional<Entrega> entregaOptional = entregaRepo.findById(idEntrega);

        if(!entregaOptional.isPresent()) return null;

        return entregaOptional.get().getDevolucion();
    }
}
