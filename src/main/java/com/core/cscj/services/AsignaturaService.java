package com.core.cscj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.Actividad;
import com.core.cscj.models.enums.Entidades;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private FileStorageService fileStorageService;

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

    public ActividadResponse createClase(Integer idAsignatura, Clase clase, MultipartFile[] files){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return new ActividadResponse();

        clase.setAsignatura(asignatura.get());
        clase.setOrden(getNextOrder(idAsignatura));
        clase.setTipoActividad(Entidades.CLASE.name());

        Clase claseStored = claseRepo.save(clase);

        return new ActividadResponse(claseStored, (files != null) ?
                fileStorageService.uploadMultipleFiles(Entidades.CLASE.name(), claseStored.getId(), files) : new ArrayList<>());
    }

    public ActividadResponse createTarea(Integer idAsignatura, Tarea tarea, MultipartFile[] files){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return null;

        tarea.setAsignatura(asignatura.get());
        tarea.setOrden(getNextOrder(idAsignatura));
        tarea.setTipoActividad(Entidades.TAREA.name());

        Tarea tareaStored = tareaRepo.save(tarea);

        return new ActividadResponse(tareaStored, (files != null) ?
                fileStorageService.uploadMultipleFiles(Entidades.TAREA.name(), tareaStored.getId(), files) : new ArrayList<>());
    }

    public ActividadResponse findClase(Integer idClase){
        Optional<Clase> clase = claseRepo.findById(idClase);

        if(!clase.isPresent()) return new ActividadResponse();

        List<ArchivosAdjuntos> archivosAdjuntos = archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.CLASE.name(), idClase);

        return new ActividadResponse(clase.get(), archivosAdjuntos);
    }

    public ActividadResponse findTarea(Integer idTarea){
        Optional<Tarea> tarea = tareaRepo.findById(idTarea);

        if(!tarea.isPresent()) return new ActividadResponse();

        List<ArchivosAdjuntos> archivosAdjuntos = archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.TAREA.name(), idTarea);

        return new ActividadResponse(tarea.get(), archivosAdjuntos);
    }

    public ActividadResponse updateClase(Integer idClase, Clase clase, MultipartFile[] files){
        Optional<Clase> claseStored = claseRepo.findById(idClase);

        if(!claseStored.isPresent()) return new ActividadResponse();

        Clase claseStoredUnit = claseStored.get();

        claseStoredUnit.setNombre(clase.getNombre());
        claseStoredUnit.setDescription(clase.getDescription());
        claseStoredUnit.setOrden(getNextOrder(claseStoredUnit.getAsignatura().getId()));
        claseStoredUnit.setTipoActividad(Entidades.CLASE.name());

        claseStoredUnit = claseRepo.save(claseStoredUnit);

        return new ActividadResponse(claseStoredUnit,
                fileStorageService.uploadNotRepeatedFiles(
                        Entidades.CLASE.name(),
                        idClase,
                        archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.CLASE.name(), idClase), files)
        );
    }

    public ActividadResponse updateTarea(Integer idTarea, Tarea tarea, MultipartFile[] files){
        Optional<Tarea> tareaStored = tareaRepo.findById(idTarea);

        if(!tareaStored.isPresent()) return new ActividadResponse();

        Tarea tareaStoredUnit = tareaStored.get();

        tareaStoredUnit.setNombre(tarea.getNombre());
        tareaStoredUnit.setDescription(tarea.getDescription());
        tareaStoredUnit.setOrden(getNextOrder(tareaStoredUnit.getAsignatura().getId()));
        tareaStoredUnit.setTipoActividad(Entidades.TAREA.name());

        tareaStoredUnit = tareaRepo.save(tareaStoredUnit);

        return new ActividadResponse(tareaStoredUnit,
                fileStorageService.uploadNotRepeatedFiles(
                        Entidades.TAREA.name(),
                        idTarea,
                        archivosAdjuntosRepo.findArchivosAdjuntosByTipoAAndIdEntidad(Entidades.TAREA.name(), idTarea), files)
        );
    }
}
