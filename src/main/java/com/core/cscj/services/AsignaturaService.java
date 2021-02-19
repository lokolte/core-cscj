package com.core.cscj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.models.entities.Planificacion;
import com.core.cscj.models.Actividad;
import com.core.cscj.repos.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {
    @Autowired
    private AsignaturaRepo asignaturaRepo;

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

    public List<Asignatura> findAllAsignaturasFromProfesor(Integer idProfesor){
        return asignaturaRepo.findAsignaturasByProfesor(idProfesor);
    }
}
