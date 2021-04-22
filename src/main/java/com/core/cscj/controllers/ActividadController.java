package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.models.requests.RespuestaRequest;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.models.responses.EntregaResponse;
import com.core.cscj.models.responses.EntregasResponse;
import com.core.cscj.models.responses.RespuestaResponse;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.EntregaService;
import com.core.cscj.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private EntregaService entregaService;

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value="/clases/{idClase}")
    public ActividadResponse findClase(@PathVariable("idClase") Integer idClase) {
        return asignaturaService.findClase(idClase);
    }

    @GetMapping(value="/tareas/{idTarea}")
    public ActividadResponse findTarea(
            @RequestHeader("Authorization") String authorization,
            @PathVariable("idTarea") Integer idTarea) {
        return asignaturaService.findTarea(jwtUtil.getDocumentFromJwtToken(authorization), idTarea);
    }

    @PutMapping(value="/clases/{idClase}")
    public ActividadResponse updateClase(@PathVariable("idClase") Integer idClase,
                                         @RequestPart(value = "clase") Clase clase,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.updateClase(idClase, clase, files);
    }

    @PutMapping(value="/tareas/{idTarea}")
    public ActividadResponse updateTarea(@PathVariable("idTarea") Integer idTarea,
                                         @RequestPart(value = "tarea") Tarea tarea,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.updateTarea(idTarea, tarea, files);
    }

    @GetMapping(value="/tareas/{idTarea}/entregas")
    public EntregasResponse getAllEntregasFromAsignatura(@PathVariable("idTarea") Integer idTarea) {
        return entregaService.findAllEntregasByIdTarea(idTarea);
    }

    @PostMapping(value="/tareas/{idTarea}/entrega")
    public EntregaResponse upsertEntrega(@PathVariable("idTarea") Integer idTarea,
                                         @RequestHeader("Authorization") String authorization,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return entregaService.upsertEntrega(jwtUtil.getDocumentFromJwtToken(authorization), idTarea, files);
    }

    @PostMapping(value="/evaluaciones/{idEvaluacion}/respuesta")
    public RespuestaResponse upsertRespuesta(@PathVariable("idEvaluacion") Integer idEvaluacion,
                                             @RequestHeader("Authorization") String authorization,
                                             @RequestPart(value = "respuesta") RespuestaRequest respuestaRequest,
                                             @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return evaluacionService.upsertRespuesta(jwtUtil.getDocumentFromJwtToken(authorization), idEvaluacion, respuestaRequest, files);
    }
}
