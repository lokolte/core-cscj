package com.core.cscj.controllers;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Curso;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping(value="/{id}/cursos")
    public List<Curso> getAllCursosFromProfesor(@PathVariable("id") Integer id) {
        return cursoService.findAllCursosFromPerson(id);
    }

    @GetMapping(value="/{idPersona}/cursos/{idCurso}/asignaturas")
    public List<Asignatura> getAllAsignaturasFromProfesor(@PathVariable("idPersona") Integer idPersona, @PathVariable("idCurso") Integer idCurso) {
        return asignaturaService.findAllAsignaturasFromPersona(idPersona, idCurso);
    }
}