package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.responses.AlumnoEntregasResponse;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.models.responses.EntregasResponse;
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
    private JwtUtil jwtUtil;

    @GetMapping(value="/cursos")
    public List<CursoResponse> getAllCursosFromProfesor(@RequestHeader("Authorization") String authorization, @RequestParam Boolean withAsignaturas) {
        return cursoService.findAllCursosFromPerson(jwtUtil.getDocumentFromJwtToken(authorization), withAsignaturas);
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
    public AlumnoEntregasResponse getAllEntregasFromAlumno(@PathVariable("idAlumno") Integer idAlumno) {
        return entregaService.findAllEntregasFromAlumno(idAlumno);
    }
}