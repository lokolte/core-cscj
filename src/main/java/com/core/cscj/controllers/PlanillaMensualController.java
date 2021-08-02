package com.core.cscj.controllers;

import com.core.cscj.models.responses.IndicadoresAlumnosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.core.cscj.models.entities.PlanillaMensual;
import com.core.cscj.services.PlanillaService;

@RestController
@RequestMapping("/planillasmensuales")
public class PlanillaMensualController {
    @Autowired
    private PlanillaService planillaService;

    @GetMapping(value="/{idPlanillaMensual}")
    public PlanillaMensual getPlanillaMensual(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual) {
        return planillaService.findPlanillaMensual(idPlanillaMensual);
    }

    @GetMapping(value="/{idPlanillaMensual}/content")
    public IndicadoresAlumnosResponse getPlanillaMensualContent(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual) {
        return planillaService.finAllIndicadoresAlumnosFromPlanillaMensual(idPlanillaMensual);
    }
}
