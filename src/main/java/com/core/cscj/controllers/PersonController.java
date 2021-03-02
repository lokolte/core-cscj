package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.services.AccountService;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.CursoService;
import com.core.cscj.services.PersonService;
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
}