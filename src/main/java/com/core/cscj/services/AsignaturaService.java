package com.core.cscj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.models.entities.Planificacion;
import com.core.cscj.models.Actividad;
import com.core.cscj.repos.AsignaturaRepo;
import com.core.cscj.repos.ClaseRepo;
import com.core.cscj.repos.TareaRepo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

    public List<Actividad> finAllActividades(Integer idAsignatura){
        List<Actividad> actividades = new ArrayList();

        List<Clase> clases = asignaturaRepo.findClasesFromAsignatura(idAsignatura);
        List<Tarea> tareas = asignaturaRepo.findTareasFromAsignatura(idAsignatura);
        List<Planificacion> planificaciones = asignaturaRepo.findPlanificacionesFromAsignatura(idAsignatura);

        clases.forEach(clase -> actividades.add(clase));
        tareas.forEach(tarea -> actividades.add(tarea));
        planificaciones.forEach(planificacion -> actividades.add(planificacion));

        return actividades.stream().sorted().collect(Collectors.toList());
    }

    public Asignatura findAsignaturaById(Integer idAsignatura){
        return asignaturaRepo.findById(idAsignatura).orElse(null);
    }

    public List<Asignatura> findAllAsignaturasFromPersona(Integer idPersona, Integer idCurso){
        return asignaturaRepo.findAsignaturasFromCursoByPersona(idPersona, idCurso);
    }

    public Clase createClase(Integer idAsignatura, Clase clase){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return null;

        clase.setAsignatura(asignatura.get());
        return claseRepo.save(clase);
    }

    public Tarea createTarea(Integer idAsignatura, Tarea tarea){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return null;

        tarea.setAsignatura(asignatura.get());
        return tareaRepo.save(tarea);
    }
}
