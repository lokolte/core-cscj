package com.core.cscj.controllers;

import com.core.cscj.models.entities.Calificacion;
import com.core.cscj.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public Calificacion updateCalificacionFromAlumno(@RequestBody Calificacion calificacion) {
        return calificacionService.updateCalificacionFromAlumno(calificacion);
    }

    @PostMapping(value="/initialize")
    public void initializeCalificacionesForEtapa(@RequestParam Integer etapa,
                                                 @RequestParam(defaultValue = "false") Boolean withInicial,
                                                 @RequestParam(defaultValue = "false") Boolean onlyInicial) {
        calificacionService.initializeCalificacionesFromAsignaturas(etapa, withInicial, onlyInicial);
    }
}
