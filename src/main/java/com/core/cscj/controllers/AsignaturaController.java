package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.Actividad;
import com.core.cscj.models.entities.*;
import com.core.cscj.models.requests.EvaluacionRequest;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.models.responses.EvaluacionResponse;
import com.core.cscj.models.responses.RespuestasAsignaturaResponse;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.EvaluacionService;
import com.core.cscj.services.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private PlanillaService planillaService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value="/{idAsignatura}")
    public Asignatura getAsignaturaById(@PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.findAsignaturaById(idAsignatura);
    }

    @GetMapping(value="/{idAsignatura}/actividades")
    public List<Actividad> getAllActividadesFromAsignatura(@RequestHeader("Authorization") String authorization, @PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.finAllActividades(idAsignatura, jwtUtil.getDocumentFromJwtToken(authorization));
    }

    @GetMapping(value="/{idAsignatura}/planillasmensuales")
    public List<PlanillaMensual> getAllPlanillasMensualesFromAsignatura(@PathVariable("idAsignatura") Integer idAsignatura) {
        return planillaService.finAllPlanillasMensualesFromAsignatura(idAsignatura);
    }

    @PostMapping(value="/{idAsignatura}/clases")
    public ActividadResponse createClase(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "clase") Clase clase,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.createClase(idAsignatura, clase, files);
    }

    @PostMapping(value="/{idAsignatura}/tareas")
    public ActividadResponse createTarea(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "tarea") Tarea tarea,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.createTarea(idAsignatura, tarea, files);
    }

    @PostMapping(value="/{idAsignatura}/planificaciones")
    public ActividadResponse createPlanificacion(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "planificacion") Planificacion planificacion,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.createPlanificacion(idAsignatura, planificacion, files);
    }

    @PostMapping(value="/{idAsignatura}/evaluaciones")
    public EvaluacionResponse upsertEvaluacion(@PathVariable("idAsignatura") Integer idAsignatura,
                                          @RequestPart(value = "evaluacion") EvaluacionRequest evaluacionRequest,
                                          @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return evaluacionService.upsertEvaluacion(idAsignatura, evaluacionRequest, files);
    }

    @PostMapping(value="/{idAsignatura}/planillasmensuales")
    public PlanillaMensual createPlanillaMensual(@PathVariable("idAsignatura") Integer idAsignatura,
                                                 @RequestBody PlanillaMensual planillaMensual) {
        return planillaService.createPlanillaMensual(idAsignatura, planillaMensual);
    }

    @GetMapping(value="/{idAsignatura}/evaluaciones")
    public RespuestasAsignaturaResponse getAllRespuestasFromEvaluacion(@PathVariable("idAsignatura") Integer idAsignatura) {
        return evaluacionService.findAllEvaluacionesFromAsignatura(idAsignatura);
    }
}
