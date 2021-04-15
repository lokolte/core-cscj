package com.core.cscj.controllers;

import com.core.cscj.models.responses.EvaluacionResponse;
import com.core.cscj.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping(value="/{idEvaluacion}")
    public EvaluacionResponse getEvaluacionByIdWithoutAlumnoDataAndRespuestas(@PathVariable("idEvaluacion") Integer idEvaluacion) {
        return evaluacionService.findEvaluacionByIdWithoutAlumnoDataAndRespuestas(idEvaluacion);
    }
}
