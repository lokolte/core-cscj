package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Planificacion;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.models.requests.EvaluacionRequest;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.models.responses.EvaluacionResponse;
import com.core.cscj.models.responses.RespuestasAsignaturaResponse;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
@CacheConfig(cacheNames = {"cache_asignaturas", "cache_actividades", "cache_evaluaciones", "cache_respuestas"})
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private JwtUtil jwtUtil;

    @Cacheable(cacheNames = {"cache_asignaturas"})
    @GetMapping(value="/{idAsignatura}")
    public Asignatura getAsignaturaById(@PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.findAsignaturaById(idAsignatura);
    }

    @Cacheable(cacheNames = "cache_actividades", keyGenerator = "loggedInKeyGenerator", sync = true)
    @GetMapping(value="/{idAsignatura}/actividades")
    public List<ActividadResponse> getAllActividadesFromAsignatura(@RequestHeader("Authorization") String authorization, @PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.finAllActividades(idAsignatura, jwtUtil.getDocumentFromJwtToken(authorization));
    }

    @CachePut(cacheNames = {"cache_actividades"})
    @PostMapping(value="/{idAsignatura}/clases")
    public ActividadResponse createClase(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "clase") Clase clase,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.createClase(idAsignatura, clase, files);
    }

    @CachePut(cacheNames = {"cache_actividades"})
    @PostMapping(value="/{idAsignatura}/tareas")
    public ActividadResponse createTarea(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "tarea") Tarea tarea,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.createTarea(idAsignatura, tarea, files);
    }

    @CachePut(cacheNames = {"cache_actividades"})
    @PostMapping(value="/{idAsignatura}/planificaciones")
    public ActividadResponse createPlanificacion(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "planificacion") Planificacion planificacion,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.createPlanificacion(idAsignatura, planificacion, files);
    }

    @CacheEvict(cacheNames = {"cache_actividades", "cache_evaluaciones"})
    @PostMapping(value="/{idAsignatura}/evaluaciones")
    public EvaluacionResponse upsertEvaluacion(@PathVariable("idAsignatura") Integer idAsignatura,
                                          @RequestPart(value = "evaluacion") EvaluacionRequest evaluacionRequest,
                                          @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return evaluacionService.upsertEvaluacion(idAsignatura, evaluacionRequest, files);
    }

    @Cacheable(cacheNames = {"cache_respuestas"})
    @GetMapping(value="/{idAsignatura}/evaluaciones")
    public RespuestasAsignaturaResponse getAllRespuestasFromEvaluacion(@PathVariable("idAsignatura") Integer idAsignatura) {
        return evaluacionService.findAllEvaluacionesFromAsignatura(idAsignatura);
    }
}
