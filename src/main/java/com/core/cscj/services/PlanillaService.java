package com.core.cscj.services;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.requests.IndicadoresAlumnosRequest;
import com.core.cscj.models.responses.*;
import com.core.cscj.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanillaService {
    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @Autowired
    private PlanillaMensualRepo planillaMensualRepo;

    @Autowired
    private CapacidadRepo capacidadRepo;

    @Autowired
    private IndicadorRepo indicadorRepo;

    @Autowired
    private IndicadoresAlumnoRepo indicadoresAlumnoRepo;

    @Autowired
    private CursoService cursoService;

    private IndicadoresAlumnosResponse createIndicadoresAlumnosResponse(PlanillaMensual planillaMensual, List<Person> alumnos) {
        return new IndicadoresAlumnosResponse(
                planillaMensual.getAsignatura(),
                new PlanillaMensualDummyResponse(
                        planillaMensual.getId(),
                        planillaMensual.getFecha(),
                        planillaMensual.getEtapa(),
                        planillaMensual.getCreationDate(),
                        planillaMensual.getLastModifiedDate(),
                        planillaMensual.getCapacidades().stream().map(
                                capacidad -> new CapacidadResponse(
                                        capacidad.getId(),
                                        capacidad.getNombre(),
                                        capacidad.getOrden(),
                                        capacidad.getIndicadores().stream().sorted().collect(Collectors.toList()))
                        ).sorted().collect(Collectors.toList()),
                        planillaMensual.getAsignatura()
                ),
                alumnos.stream().map(
                        alumno -> new AlumnoIndicadorResponse(
                                alumno,
                                indicadoresAlumnoRepo
                                        .findAllIndicadoresAlumnoByFromPlanillaMensualAndAlumno(
                                                planillaMensual.getId(),
                                                alumno.getId()
                                        )
                        )
                ).collect(Collectors.toList())
        );
    }

    private PlanillaMensualResponse createPlanillaMensualResponse(PlanillaMensual planillaMensual, List<Person> alumnos) {
        return new PlanillaMensualResponse(
                planillaMensual.getId(),
                planillaMensual.getFecha(),
                planillaMensual.getEtapa(),
                planillaMensual.getCreationDate(),
                planillaMensual.getLastModifiedDate(),
                planillaMensual.getCapacidades().stream().map(
                        capacidad -> new CapacidadResponse(
                                capacidad.getId(),
                                capacidad.getNombre(),
                                capacidad.getOrden(),
                                capacidad.getIndicadores().stream().sorted().collect(Collectors.toList()))
                ).sorted().collect(Collectors.toList()),
                planillaMensual.getAsignatura(),
                createIndicadoresAlumnosResponse(planillaMensual, alumnos));
    }

    private PlanillaMensualDummyResponse createPlanillaMensualDummyResponse(PlanillaMensual planillaMensual) {
        return new PlanillaMensualDummyResponse(
                planillaMensual.getId(),
                planillaMensual.getFecha(),
                planillaMensual.getEtapa(),
                planillaMensual.getCreationDate(),
                planillaMensual.getLastModifiedDate(),
                planillaMensual.getCapacidades().stream().map(
                        capacidad -> new CapacidadResponse(
                                capacidad.getId(),
                                capacidad.getNombre(),
                                capacidad.getOrden(),
                                capacidad.getIndicadores().stream().sorted().collect(Collectors.toList()))
                ).sorted().collect(Collectors.toList()),
                planillaMensual.getAsignatura());
    }

    public PlanillasMensualesResponse finAllPlanillasMensualesFromAsignatura(Integer idAsignatura){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return new PlanillasMensualesResponse();

        List<Person> alumnos = cursoService.findAllAlumnos(asignatura.get().getCurso().getId());

        List<PlanillaMensualResponse> planillasMensualesResponse = asignatura.get().getPlanillasMensuales().stream().map(
                planillaMensual -> createPlanillaMensualResponse(planillaMensual, alumnos)
        ).sorted().collect(Collectors.toList());

        return new PlanillasMensualesResponse(asignatura.get(), planillasMensualesResponse);
    }

    public IndicadoresAlumnosResponse finAllIndicadoresAlumnosFromPlanillaMensual(Integer idPlanillaMensual){
        Optional<PlanillaMensual> planillaMensualOptional = planillaMensualRepo.findById(idPlanillaMensual);

        if(!planillaMensualOptional.isPresent()) return new IndicadoresAlumnosResponse();

        List<Person> alumnos = cursoService.findAllAlumnos(planillaMensualOptional.get().getAsignatura().getCurso().getId());

        return new IndicadoresAlumnosResponse(
                planillaMensualOptional.get().getAsignatura(),
                createPlanillaMensualDummyResponse(planillaMensualOptional.get()),
                alumnos.stream().map(
                        alumno -> new AlumnoIndicadorResponse(
                                alumno,
                                indicadoresAlumnoRepo
                                        .findAllIndicadoresAlumnoByFromPlanillaMensualAndAlumno(
                                                planillaMensualOptional.get().getId(),
                                                alumno.getId()
                                        )
                        )
                ).collect(Collectors.toList())
        );
    }

    public PlanillaMensualDummyResponse findPlanillaMensual(Integer idPlanillaMensual){
        Optional<PlanillaMensual> planillaMensual = planillaMensualRepo.findById(idPlanillaMensual);

        if(!planillaMensual.isPresent()) return new PlanillaMensualDummyResponse();

        return createPlanillaMensualDummyResponse(planillaMensual.get());
    }

    public PlanillaMensual upsertPlanillaMensual(Integer idAsignatura, PlanillaMensual planillaMensual) {
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);
        if(!asignatura.isPresent()) return new PlanillaMensual();

        PlanillaMensual planillaMensualStored;
        Optional<PlanillaMensual> planillaMensualStoredOptional = Optional.empty();

        if(planillaMensual.getId() != null)
            planillaMensualStoredOptional = planillaMensualRepo.findById(planillaMensual.getId());

        if(!planillaMensualStoredOptional.isPresent()) {
            planillaMensualStored = new PlanillaMensual();
            planillaMensualStored.setCreationDate(new Timestamp(new Date().getTime()));
            planillaMensualStored.setAsignatura(asignatura.get());
            planillaMensualStored = planillaMensualRepo.save(planillaMensualStored);
        } else {
            planillaMensualStored = planillaMensualStoredOptional.get();
            planillaMensualStored.setLastModifiedDate(new Timestamp(new Date().getTime()));
        }

        if(planillaMensualStored.getCapacidades() != null) {
            HashMap<Integer, Capacidad> capacidadesInRequest = new HashMap<>();
            HashMap<Integer, Indicador> indicadoresInRequest = new HashMap<>();

            planillaMensual.getCapacidades().forEach(
                    capacidad -> {
                        if (capacidad.getId() != null) {
                            capacidadesInRequest.put(capacidad.getId(), capacidad);
                            capacidad.getIndicadores().forEach(
                                    indicador -> {
                                        if (indicador.getId() != null)
                                            indicadoresInRequest.put(indicador.getId(), indicador);
                                    }
                            );
                        }
                    }
            );

            Set<Capacidad> capacidadesUpdated = new HashSet<>();
            Set<Indicador> indicadoresUpdated = new HashSet<>();
            Set<IndicadoresAlumno> indicadoresAlumnoUpdated = new HashSet<>();
            planillaMensualStored.getCapacidades().forEach(
                    capacidad -> {
                        // If capacidad was deleted, then delete the indicador and respectives indicadores alumnos.
                        if (capacidadesInRequest.get(capacidad.getId()) == null) {
                            capacidad.getIndicadores().forEach(
                                    indicador -> {
                                        indicadoresAlumnoRepo.findAllIndicadoresAlumnoByIdIndicador(indicador.getId())
                                                .forEach(
                                                        indicadoresAlumno -> indicadoresAlumnoRepo.delete(indicadoresAlumno)
                                                );
                                        indicadorRepo.delete(indicador);
                                    }
                            );
                            capacidadRepo.delete(capacidad);
                            // If indicadores wasn't deleted, then verify which indicador was delete and delete his respective indicadores alumnos.
                        } else {
                            capacidad.getIndicadores().forEach(
                                    indicador -> {
                                        if (indicadoresInRequest.get(indicador.getId()) == null) {
                                            indicadoresAlumnoRepo.findAllIndicadoresAlumnoByIdIndicador(indicador.getId())
                                                    .forEach(
                                                            indicadoresAlumno -> indicadoresAlumnoRepo.delete(indicadoresAlumno)
                                                    );
                                            indicadorRepo.delete(indicador);
                                        } else {
                                            indicadoresUpdated.add(indicador);
                                            indicadoresAlumnoUpdated.addAll(indicador.getIndicadoresAlumnos());
                                        }
                                    }
                            );
                            capacidad.setIndicadores(indicadoresUpdated);
                            Capacidad capacidadUpdated = capacidadRepo.save(capacidad);
                            capacidadesUpdated.add(capacidadUpdated);
                        }
                    }
            );
            planillaMensualStored.setCapacidades(capacidadesUpdated);
            planillaMensualStored.setIndicadoresAlumnos(indicadoresAlumnoUpdated);

            planillaMensualStored = planillaMensualRepo.save(planillaMensualStored);
        }

        PlanillaMensual finalPlanillaMensualStored = planillaMensualStored;
        List<Person> alumnos = cursoService.findAllAlumnos(asignatura.get().getCurso().getId());

        Set<Capacidad> capacidades = planillaMensual.getCapacidades().stream().map(
                capacidad -> upsertCapacidad(capacidad, finalPlanillaMensualStored, alumnos)
        ).collect(Collectors.toSet());

        planillaMensualStored.setCapacidades(capacidades);
        planillaMensualStored.setFecha(planillaMensual.getFecha());
        planillaMensualStored.setEtapa(planillaMensual.getEtapa());

        planillaMensualStored = planillaMensualRepo.save(planillaMensualStored);

        return planillaMensualStored;
    }

    public Capacidad upsertCapacidad(Capacidad capacidad, PlanillaMensual planillaMensual, List<Person> alumnos){
        Capacidad capacidadToStore;

        if(capacidad.getId() != null) {
            capacidadToStore = capacidadRepo.findById(capacidad.getId()).orElseGet(Capacidad::new);
        } else capacidadToStore = new Capacidad();

        capacidadToStore.setPlanillaMensual(planillaMensual);
        capacidadToStore.setNombre(capacidad.getNombre());
        capacidadToStore.setOrden(capacidad.getOrden());

        Capacidad capacidadStored = capacidadRepo.save(capacidadToStore);

        Set<Indicador> indicadores = capacidad.getIndicadores().stream().map(
                indicador -> upsertIndicador(indicador, capacidadStored, planillaMensual, alumnos)
        ).collect(Collectors.toSet());

        capacidadStored.setIndicadores(indicadores);

        return capacidadRepo.save(capacidadStored);
    }

    public Indicador upsertIndicador(Indicador indicador, Capacidad capacidad, PlanillaMensual planillaMensual, List<Person> alumnos){
        Indicador indicadorToStore;
        Boolean indicadorExist = false;

        if(indicador.getId() != null) {
            Optional<Indicador> indicadorStoredOptional = indicadorRepo.findById(indicador.getId());
            if(!indicadorStoredOptional.isPresent()) {
                indicadorToStore = new Indicador();
            } else {
                indicadorToStore = indicadorStoredOptional.get();
                indicadorExist = true;
            }
        } else indicadorToStore = new Indicador();

        indicadorToStore.setCapacidad(capacidad);
        indicadorToStore.setNombre(indicador.getNombre());
        indicadorToStore.setOrden(indicador.getOrden());
        indicadorToStore.setPuntajeMaximo(indicador.getPuntajeMaximo());

        Indicador finalIndicadorStored = indicadorRepo.save(indicadorToStore);

        if(!indicadorExist) {
            Set<IndicadoresAlumno> indicadoresAlumnos = alumnos.stream().map(
                    alumno -> {
                        IndicadoresAlumno indicadoresAlumno = new IndicadoresAlumno();
                        indicadoresAlumno.setIndicador(finalIndicadorStored);
                        indicadoresAlumno.setAlumno(alumno);
                        indicadoresAlumno.setPuntaje(0);
                        indicadoresAlumno.setPlanillaMensual(capacidad.getPlanillaMensual());
                        return indicadoresAlumnoRepo.save(indicadoresAlumno);
                    }
            ).collect(Collectors.toSet());

            finalIndicadorStored.setIndicadoresAlumnos(indicadoresAlumnos);

            if(planillaMensual.getIndicadoresAlumnos() != null)
                planillaMensual.getIndicadoresAlumnos().addAll(indicadoresAlumnos);
            else planillaMensual.setIndicadoresAlumnos(indicadoresAlumnos);

            planillaMensualRepo.save(planillaMensual);

            return indicadorRepo.save(finalIndicadorStored);
        }

        return finalIndicadorStored;
    }

    public void deletePlanillaMensual(Integer idPlanillaMensual) {
        PlanillaMensual planillaMensualStored;
        Optional<PlanillaMensual> planillaMensualStoredOptional = planillaMensualRepo.findById(idPlanillaMensual);

        if(!planillaMensualStoredOptional.isPresent()) {
            return;
        } else {
            planillaMensualStored = planillaMensualStoredOptional.get();

            planillaMensualStored.getCapacidades().forEach(
                    capacidad -> {
                        capacidad.getIndicadores().forEach(
                                    indicador -> {
                                        indicadoresAlumnoRepo.findAllIndicadoresAlumnoByIdIndicador(indicador.getId())
                                                .forEach(
                                                        indicadoresAlumno -> indicadoresAlumnoRepo.delete(indicadoresAlumno)
                                                );
                                        indicadorRepo.delete(indicador);
                                    }
                            );
                        capacidadRepo.delete(capacidad);
                    }
            );

            planillaMensualRepo.delete(planillaMensualStored);
        }
    }

    public IndicadoresAlumnosResponse updateAllIndicadoresAlumnosFromPlanillaMensual(Integer idPlanillaMensual, IndicadoresAlumnosRequest indicadoresAlumnosRequest) {
        Optional<PlanillaMensual> planillaMensualOptional = planillaMensualRepo.findById(idPlanillaMensual);

        if(!planillaMensualOptional.isPresent()) return new IndicadoresAlumnosResponse();

        return new IndicadoresAlumnosResponse(
                indicadoresAlumnosRequest.getAsignatura(),
                createPlanillaMensualDummyResponse(indicadoresAlumnosRequest.getPlanillaMensual()),
                indicadoresAlumnosRequest.getAlumnos().stream().map(
                        alumnoIndicadorRequest -> new AlumnoIndicadorResponse(
                                alumnoIndicadorRequest.getAlumno(),
                                alumnoIndicadorRequest.getIndicadores().stream().map(
                                        indicadoresAlumno -> {
                                            IndicadoresAlumno indicadoresAlumnoStored = indicadoresAlumnoRepo.findById(indicadoresAlumno.getId()).get();
                                            indicadoresAlumnoStored.setPuntaje(indicadoresAlumno.getPuntaje());
                                            return indicadoresAlumnoRepo.save(indicadoresAlumnoStored);
                                        }
                                ).collect(Collectors.toList())
                        )
                ).collect(Collectors.toList())
        );
    }
}
