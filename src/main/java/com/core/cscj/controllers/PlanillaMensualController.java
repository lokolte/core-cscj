package com.core.cscj.controllers;

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

    @PutMapping(value="/{idPlanillaMensual}")
    public PlanillaMensual updatePlanillaMensual(@PathVariable("idPlanillaMensual") Integer idPlanillaMensual,
                                                 @RequestBody PlanillaMensual planillaMensual) {
        return planillaService.updatePlanillaMensual(idPlanillaMensual, planillaMensual);
    }
}
