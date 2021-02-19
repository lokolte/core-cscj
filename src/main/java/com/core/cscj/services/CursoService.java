package com.core.cscj.services;

import java.util.*;

import com.core.cscj.models.entities.Account;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.repos.AccountRepo;
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

    public Set<Curso> findAllCursosFromPerson(Integer idPerson) {
        Optional<Person> person = personRepo.findById(idPerson);

        if(!person.isPresent()) return new HashSet<>();

        return person.get().getCursos();
    }

    public List<Person> findAllAlumnos(Integer idCurso){
        return cursoRepo.findPersonsFromCurso(Roles.ALUMNO.name(), idCurso);
    }

    public List<Asignatura> findAllAsignaturas(Integer idCurso){
        return cursoRepo.findAsignaturasFromCurso(idCurso);
    }
}
