package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value="/{idCurso}")
    public CursoResponse getCursoById(@RequestHeader("Authorization") String authorization, @PathVariable("idCurso") Integer idCurso) {
        return cursoService.findById(idCurso, jwtUtil.getDocumentFromJwtToken(authorization));
    }

    @GetMapping(value="/{idCurso}/alumnos")
    public List<Person> getAllAlumnosFromCurso(@PathVariable("idCurso") Integer idCurso) {
        return cursoService.findAllAlumnos(idCurso);
    }

    @GetMapping(value="/{idCurso}/asignaturas")
    public List<Asignatura> getAllAsignaturasFromCurso(@PathVariable("idCurso") Integer idCurso) {
        return cursoService.findAllAsignaturasFromCurso(idCurso);
    }
}
