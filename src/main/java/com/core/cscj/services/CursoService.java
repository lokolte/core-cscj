package com.core.cscj.services;

import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.repos.AccountRepo;
import com.core.cscj.repos.AsignaturaRepo;
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

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AsignaturaRepo asignaturaRepo;

    public CursoResponse findById(Integer idCurso, String document){
        Account account = accountRepo.findByDocument(document);
        List<String> roles = (new ArrayList<>(account.getRoles())).stream().map(role -> role.getName()).collect(Collectors.toList());

        List<Curso> cursosFiltered = (new ArrayList<>(account.getPerson().getCursos())).stream().filter(curso -> curso.getId().equals(idCurso)).collect(Collectors.toList());
        Curso cursoFiltered = (cursosFiltered.size() > 0) ? cursosFiltered.get(0) : null;

        if(cursoFiltered == null) return null;

        if(roles.contains(Roles.ALUMNO.name()) || roles.contains(Roles.COORDINADOR.name())) {
            return new CursoResponse(cursoFiltered, findAllAsignaturasFromCurso(idCurso));
        }else{
            return new CursoResponse(cursoFiltered, asignaturaRepo.findAsignaturasFromCursoByPersona(account.getPerson().getId(), idCurso));
        }
    }

    public List<Curso> findAllCursosFromPerson(Integer idPerson) {
        return personRepo.findById(idPerson).map(person -> person.getCursos().stream().sorted().collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    public List<Person> findAllAlumnos(Integer idCurso){
        return cursoRepo.findPersonsFromCurso(Roles.ALUMNO.name(), idCurso);
    }

    public List<Asignatura> findAllAsignaturasFromCurso(Integer idCurso){
        return cursoRepo.findAsignaturasFromCurso(idCurso);
    }
}
