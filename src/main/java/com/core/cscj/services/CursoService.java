package com.core.cscj.services;

import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.repos.AccountRepo;
import com.core.cscj.repos.AsignaturaRepo;
import com.core.cscj.repos.CursoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AsignaturaRepo asignaturaRepo;

    public CursoResponse findById(Integer idCurso, String document){
        Account account = accountRepo.findByDocument(document);
        List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        List<Curso> cursos;
        Curso cursoStored;

        if(roles.contains(Roles.SUPERVISOR.name())) {
            cursoStored = cursoRepo.findById(idCurso).orElse(null);
        }else{
            cursos = account.getPerson().getCursos().stream().filter(curso -> curso.getId().equals(idCurso)).collect(Collectors.toList());
            cursoStored = (cursos.size() > 0) ? cursos.get(0) : null;
        }

        if(cursoStored == null) return null;

        return new CursoResponse(cursoStored, findCursoWithAsignaturasFromPersonBasedOnRole(cursoStored.getId(), account.getPerson().getId(), roles, false));
    }

    private List<Asignatura> findCursoWithAsignaturasFromPersonBasedOnRole(Integer idCurso, Integer idPersona, List<String> roles, Boolean fromVideoClase){
        if(((roles.contains(Roles.ALUMNO.name()) || roles.contains(Roles.COORDINADOR.name()) || roles.contains(Roles.SUPERVISOR.name())) && !fromVideoClase)
                || roles.contains(Roles.ADMIN.name())) {
            return findAllAsignaturasFromCurso(idCurso);
        } else {
            return asignaturaRepo.findAsignaturasFromCursoByPersona(idPersona, idCurso);
        }
    }

    public List<CursoResponse> findAllCursosFromPerson(String document, Boolean withAsignaturas, Boolean fromVideoClase) {
        Account account = accountRepo.findByDocument(document);
        List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        if(roles.contains(Roles.SUPERVISOR.name()))
            return cursoRepo.findAll().stream().map(
                    curso ->
                            (withAsignaturas) ?
                                    new CursoResponse(curso, findCursoWithAsignaturasFromPersonBasedOnRole(curso.getId(), account.getPerson().getId(), roles, fromVideoClase))
                                    : new CursoResponse(curso, new ArrayList<>())
            ).collect(Collectors.toList());

        else return account.getPerson().getCursos().stream().sorted().collect(Collectors.toList()).stream()
                .map(curso ->
                        (withAsignaturas) ?
                                new CursoResponse(curso, findCursoWithAsignaturasFromPersonBasedOnRole(curso.getId(), account.getPerson().getId(), roles, fromVideoClase))
                                : new CursoResponse(curso, new ArrayList<>())
                ).collect(Collectors.toList());
    }

    public List<Person> findAllAlumnos(Integer idCurso){
        return cursoRepo.findPersonsFromCurso(Roles.ALUMNO.name(), idCurso);
    }

    public List<Asignatura> findAllAsignaturasFromCurso(Integer idCurso){
        return cursoRepo.findAsignaturasFromCurso(idCurso);
    }
}
