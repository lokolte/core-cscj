package com.core.cscj.services;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Entidades;
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

        if(entregaToStore == null) entregaToStore = new Entrega();;

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

        return new EntregasResponse(
                tarea.get(),
                entregaRepo.findEntregasByIdTarea(idTarea).stream().map(
                    entrega -> new EntregaResponse(
                        entrega,
                        archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.ENTREGA.name(), entrega.getId())
                    )
                ).collect(Collectors.toList())
        );
    }
}
