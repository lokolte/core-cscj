package com.core.cscj.controllers;

import com.core.cscj.models.Actividad;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping(value="/{idAsignatura}/actividades")
    public List<Actividad> getAllActividadesFromAsignatura(@PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.finAllActividades(idAsignatura);
    }

    @PostMapping(value="/{idAsignatura}/clases")
    public Actividad createClase(@PathVariable("idAsignatura") Integer idAsignatura, @RequestBody Clase clase) {
        return asignaturaService.createClase(idAsignatura, clase);
    }

    @PostMapping(value="/{idAsignatura}/tareas")
    public Actividad createTarea(@PathVariable("idAsignatura") Integer idAsignatura, @RequestBody Tarea tarea) {
        return asignaturaService.createTarea(idAsignatura, tarea);
    }

    @GetMapping(value="/{idAsignatura}")
    public Asignatura getAsignaturaById(@PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.findAsignaturaById(idAsignatura);
    }

}
