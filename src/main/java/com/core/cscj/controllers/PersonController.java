package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Calificacion;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.responses.*;
import com.core.cscj.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private PersonService personService;

    @Autowired
    private EntregaService entregaService;

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private CalificacionService calificacionService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value="/cursos")
    public List<CursoResponse> getAllCursosFromProfesor(@RequestHeader("Authorization") String authorization,
                                                        @RequestParam Boolean withAsignaturas,
                                                        @RequestParam(defaultValue = "false") Boolean fromVideoClase) {
        return cursoService.findAllCursosFromPerson(jwtUtil.getDocumentFromJwtToken(authorization), withAsignaturas, fromVideoClase);
    }

    @GetMapping(value="/{idPerson}")
    public Person getPersonById(@PathVariable("idPerson") Integer idPersona) {
        return personService.findById(idPersona);
    }

    @GetMapping(value="/{idPersona}/cursos/{idCurso}/asignaturas")
    public List<Asignatura> getAllAsignaturasFromProfesor(@PathVariable("idPersona") Integer idPersona, @PathVariable("idCurso") Integer idCurso) {
        return asignaturaService.findAllAsignaturasFromPersona(idPersona, idCurso);
    }

    @GetMapping(value="/{idAlumno}/entregas")
    public AlumnoEntregasResponse getAllEntregasFromAlumno(@RequestHeader("Authorization") String authorization, @PathVariable("idAlumno") Integer idAlumno) {
        return entregaService.findAllEntregasFromAlumno(jwtUtil.getDocumentFromJwtToken(authorization), idAlumno);
    }

    @GetMapping(value="/{idAlumno}/evaluaciones")
    public List<RespuestaResponse> getAllRespuestasFromEvaluacion(@RequestHeader("Authorization") String authorization, @PathVariable("idAlumno") Integer idAlumno) {
        return evaluacionService.findAllEvaluacionesAndRespuestasFromAlumno(jwtUtil.getDocumentFromJwtToken(authorization), idAlumno);
    }

    @GetMapping(value="/{idAlumno}/calificaciones")
    public List<Calificacion> getAllCalificacionesFromAlumno(@RequestHeader("Authorization") String authorization, @PathVariable("idAlumno") Integer idAlumno) {
        return calificacionService.finAllCalificacionesFromAlumno(jwtUtil.getDocumentFromJwtToken(authorization), idAlumno);
    }
}