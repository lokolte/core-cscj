package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value="/clases/{idClase}")
    public ActividadResponse findClase(@PathVariable("idClase") Integer idClase) {
        return asignaturaService.findClase(idClase);
    }

    @GetMapping(value="/tareas/{idTarea}")
    public ActividadResponse findTarea(@PathVariable("idTarea") Integer idTarea) {
        return asignaturaService.findTarea(idTarea);
    }
}
