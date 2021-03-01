package com.core.cscj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.Actividad;
import com.core.cscj.models.enums.Actividades;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.LoadedFile;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {
    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @Autowired
    private ClaseRepo claseRepo;

    @Autowired
    private TareaRepo tareaRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private ArchivosAdjuntosRepo archivosAdjuntosRepo;

    private List<Actividad> finAllActividadesFromAsignaturaById(Integer idAsignatura, Boolean condition){

        List<Actividad> actividades = new ArrayList();

        List<Clase> clases = asignaturaRepo.findClasesFromAsignatura(idAsignatura);
        List<Tarea> tareas = asignaturaRepo.findTareasFromAsignatura(idAsignatura);

        clases.forEach(clase -> actividades.add(clase));
        tareas.forEach(tarea -> actividades.add(tarea));

        if(condition){
            List<Planificacion> planificaciones = asignaturaRepo.findPlanificacionesFromAsignatura(idAsignatura);
            planificaciones.forEach(planificacion -> actividades.add(planificacion));
        }

        return actividades.stream().sorted().collect(Collectors.toList());
    }

    public List<Actividad> finAllActividades(Integer idAsignatura, String document){
        Account account = accountRepo.findByDocument(document);

        if(account == null) return new ArrayList<>();

        List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        return finAllActividadesFromAsignaturaById(idAsignatura, roles.contains(Roles.PROFESOR.name()) || roles.contains(Roles.COORDINADOR.name()));
    }

    public Asignatura findAsignaturaById(Integer idAsignatura){
        return asignaturaRepo.findById(idAsignatura).orElse(null);
    }

    public List<Asignatura> findAllAsignaturasFromPersona(Integer idPersona, Integer idCurso){
        return asignaturaRepo.findAsignaturasFromCursoByPersona(idPersona, idCurso);
    }

    private Integer getNextOrder(Integer idAsignatura){
        List<Actividad> actividades = finAllActividadesFromAsignaturaById(idAsignatura, true);

        Integer maxOrder = 0;
        for(Actividad actividad : actividades)
            if(maxOrder < actividad.getOrden()) maxOrder = actividad.getOrden();

        return maxOrder +1;
    }

    public ActividadResponse createClase(Integer idAsignatura, Clase clase, List<LoadedFile> uploadedFiles){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return new ActividadResponse();

        clase.setAsignatura(asignatura.get());
        clase.setOrden(getNextOrder(idAsignatura));
        clase.setTipoActividad(Actividades.CLASE.name());

        Clase claseStored = claseRepo.save(clase);

        List<ArchivosAdjuntos> archivosAdjuntos = uploadedFiles.stream().map(uploadFile -> new ArchivosAdjuntos(
                uploadFile.getFileName(),
                uploadFile.getFileDownloadUri(),
                uploadFile.getFileType(),
                uploadFile.getSize(),
                Actividades.CLASE.name(),
                claseStored.getId()
                )).collect(Collectors.toList());

        return new ActividadResponse(claseStored,
                archivosAdjuntos.stream().map(archivoAdjunto -> archivosAdjuntosRepo.save(archivoAdjunto)).collect(Collectors.toList()));
    }

    public ActividadResponse createTarea(Integer idAsignatura, Tarea tarea, List<LoadedFile> uploadedFiles){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return null;

        tarea.setAsignatura(asignatura.get());
        tarea.setOrden(getNextOrder(idAsignatura));
        tarea.setTipoActividad(Actividades.TAREA.name());
        Tarea tareaStored = tareaRepo.save(tarea);

        List<ArchivosAdjuntos> archivosAdjuntos = uploadedFiles.stream().map(uploadFile -> new ArchivosAdjuntos(
                uploadFile.getFileName(),
                uploadFile.getFileDownloadUri(),
                uploadFile.getFileType(),
                uploadFile.getSize(),
                Actividades.TAREA.name(),
                tareaStored.getId()
        )).collect(Collectors.toList());

        return new ActividadResponse(tareaStored,
                archivosAdjuntos.stream().map(archivoAdjunto -> archivosAdjuntosRepo.save(archivoAdjunto)).collect(Collectors.toList()));
    }

    public ActividadResponse findClase(Integer idClase){
        Optional<Clase> clase = claseRepo.findById(idClase);

        if(!clase.isPresent()) return new ActividadResponse();

        List<ArchivosAdjuntos> archivosAdjuntos = archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Actividades.CLASE.name(), idClase);

        return new ActividadResponse(clase.get(), archivosAdjuntos);
    }

    public ActividadResponse findTarea(Integer idTarea){
        Optional<Tarea> tarea = tareaRepo.findById(idTarea);

        if(!tarea.isPresent()) return new ActividadResponse();

        List<ArchivosAdjuntos> archivosAdjuntos = archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Actividades.TAREA.name(), idTarea);

        return new ActividadResponse(tarea.get(), archivosAdjuntos);
    }
}
