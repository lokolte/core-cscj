package com.core.cscj.services;

import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.CalificacionesResponse;
import com.core.cscj.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private CalificacionRepo calificacionRepo;

    @Autowired
    private EtapaRepo etapaRepo;

    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private CursoService cursoService;

    public CalificacionesResponse findAllCalificacionesFromAsignatura(Integer idAsignatura) {
        Optional<Asignatura> asignaturaOptional = asignaturaRepo.findById(idAsignatura);

        if (!asignaturaOptional.isPresent()) return new CalificacionesResponse();

        return new CalificacionesResponse(asignaturaOptional.get(), asignaturaOptional.get().getCalificaciones().stream().sorted().collect(Collectors.toList()));
    }

    public List<Calificacion> finAllCalificacionesFromAlumno(String document, Integer idAlumno){
        Person person = personRepo.findByDocument(document);

        if(person == null) return new ArrayList<>();

        Account account = accountRepo.findByDocument(document);

        if(account == null) return new ArrayList<>();

        List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        Optional<Person> alumnoOptional = personRepo.findById(idAlumno);

        if(!alumnoOptional.isPresent()) return new ArrayList<>();

        if(roles.contains(Roles.ADMIN.name()) || roles.contains(Roles.ALUMNO.name())
                || roles.contains(Roles.TUTOR.name())
                || roles.contains(Roles.COORDINADOR.name())
                || roles.contains(Roles.SUPERVISOR.name()))
            return alumnoOptional.get().getCalificaciones().stream().collect(Collectors.toList());
        else // This is for roles.contains(Roles.PROFESOR.name())
            return alumnoOptional.get().getCalificaciones()
                    .stream().filter(
                            calificacion -> calificacion.getAsignatura().getProfesor().getId() == person.getId()
                    ).collect(Collectors.toList());
    }

    public Calificacion updateCalificacionFromAlumno(Calificacion calificacion){
        if(calificacion.getId() == null)
            return new Calificacion();

        Optional<Calificacion> calificacionOptional = calificacionRepo.findById(calificacion.getId());

        if(!calificacionOptional.isPresent()) return new Calificacion();

        Calificacion calificacionStored = calificacionOptional.get();

        calificacionStored.setNota(calificacion.getNota());
        calificacionStored.setObservacion(calificacion.getObservacion());

        return calificacionRepo.save(calificacion);
    }

    public void initializeCalificacionesFromAsignaturas(Integer etapa, Boolean withInicial, Boolean onlyInicial) {
        List<Etapa> etapas = etapaRepo.findAll();

        etapas = etapas.stream().filter(
                etapaActual -> etapaActual.getEtapa() == etapa
        ).collect(Collectors.toList());

        if(etapas.size() > 0) return;

        Etapa newEtapa;

        if(etapa == 1) {
            Etapa etapa1 = new Etapa();
            etapa1.setEtapa(1);
            etapa1.setNombreEtapa("Primera Etapa");
            etapa1.setNombreAbreviado("1ra Etapa");
            newEtapa = etapaRepo.save(etapa1);
        } else if(etapa == 2) {
            Etapa etapa2 = new Etapa();
            etapa2.setEtapa(2);
            etapa2.setNombreEtapa("Segunda Etapa");
            etapa2.setNombreAbreviado("2da Etapa");
            newEtapa = etapaRepo.save(etapa2);
        } else {
            Etapa etapa3 = new Etapa();
            etapa3.setEtapa(1);
            etapa3.setNombreEtapa("Tercera Etapa");
            etapa3.setNombreAbreviado("3ra Etapa");
            newEtapa = etapaRepo.save(etapa3);
        }

        List<Curso> cursos = cursoRepo.findAll();

        if(withInicial)
            cursos = cursos.stream().filter(
                    curso -> curso.getNivel() != 0
            ).collect(Collectors.toList());

        if(onlyInicial)
            cursos = cursos.stream().filter(
                    curso -> curso.getNivel() == 0
            ).collect(Collectors.toList());

        cursos.forEach(
                curso ->
                        cursoService.findAllAlumnos(curso.getId())
                                .forEach(
                                        alumno ->
                                            curso.getAsignaturas().forEach(
                                                    asignatura -> {
                                                        Calificacion calificacion = new Calificacion();
                                                        calificacion.setAsignatura(asignatura);
                                                        calificacion.setAlumno(alumno);
                                                        calificacion.setEtapa(newEtapa);
                                                        calificacion.setNota("");
                                                        calificacion.setObservacion("");

                                                        Calificacion calificacionStored = calificacionRepo.save(calificacion);

                                                        asignatura.setCalificacion(calificacionStored);
                                                        asignaturaRepo.save(asignatura);

                                                        alumno.setCalificacion(calificacionStored);
                                                        personRepo.save(alumno);

                                                        newEtapa.setCalificacion(calificacionStored);
                                                        etapaRepo.save(newEtapa);
                                                    }
                                            )
                                )
        );
    }
}
