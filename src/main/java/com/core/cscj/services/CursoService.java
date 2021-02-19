package com.core.cscj.services;

import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.repos.CursoRepo;

import com.core.cscj.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private PersonRepo personRepo;

    public CursoResponse findById(Integer idCurso){
        return new CursoResponse(cursoRepo.findById(idCurso).orElse(null), findAllAsignaturas(idCurso));
    }

    public List<Curso> findAllCursosFromPerson(Integer idPerson) {
        return personRepo.findById(idPerson).map(person -> person.getCursos().stream().sorted().collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    public List<Person> findAllAlumnos(Integer idCurso){
        return cursoRepo.findPersonsFromCurso(Roles.ALUMNO.name(), idCurso);
    }

    public List<Asignatura> findAllAsignaturas(Integer idCurso){
        return cursoRepo.findAsignaturasFromCurso(idCurso);
    }
}
