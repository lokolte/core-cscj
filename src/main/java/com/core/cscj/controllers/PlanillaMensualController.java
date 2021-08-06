package com.core.cscj.controllers;

import com.core.cscj.models.requests.IndicadoresAlumnosRequest;
import com.core.cscj.models.responses.IndicadoresAlumnosResponse;
import com.core.cscj.models.responses.PlanillaMensualDummyResponse;
import com.core.cscj.models.responses.PlanillaMensualResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.core.cscj.services.PlanillaService;

@RestController
@RequestMapping("/planillasmensuales")
public class PlanillaMensualController {
    @Autowired
    private PlanillaService planillaService;

    @GetMapping(value="/{idPlanillaMensual}")
    public PlanillaMensualDummyResponse getPlanillaMensual(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual) {
        return planillaService.findPlanillaMensual(idPlanillaMensual);
    }

    @GetMapping(value="/{idPlanillaMensual}/content")
    public IndicadoresAlumnosResponse getPlanillaMensualContent(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual) {
        return planillaService.finAllIndicadoresAlumnosFromPlanillaMensual(idPlanillaMensual);
    }

    @PostMapping(value="/{idPlanillaMensual}/complete")
    public IndicadoresAlumnosResponse completePlanillaMensualContent(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual,
                                                                     @RequestBody IndicadoresAlumnosRequest indicadoresAlumnosRequest) {
        return planillaService.updateAllIndicadoresAlumnosFromPlanillaMensual(idPlanillaMensual, indicadoresAlumnosRequest);
    }

    @DeleteMapping(value="/{idPlanillaMensual}")
    public void deletePlanillaMensualContent(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual) {
        planillaService.deletePlanillaMensual(idPlanillaMensual);
    }
}
