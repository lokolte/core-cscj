package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Devolucion;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.models.responses.EntregaResponse;
import com.core.cscj.services.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<EntregaResponse> getAllEntregasFromAlumno(@PathVariable("idAlumno") Integer idAlumno) {
        return entregaService.findAllEntregasFromAlumno(idAlumno);
    }
}