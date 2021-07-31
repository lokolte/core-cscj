package com.core.cscj.services;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
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

    public List<PlanillaMensual> finAllPlanillasMensualesFromAsignatura(Integer idAsignatura){
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return new ArrayList<>();

        return asignatura.get().getPlanillasMensuales().stream().collect(Collectors.toList());
    }

    public PlanillaMensual createPlanillaMensual(Integer idAsignatura, PlanillaMensual planillaMensual) {
        Optional<Asignatura> asignatura = asignaturaRepo.findById(idAsignatura);

        if(!asignatura.isPresent()) return new PlanillaMensual();

        planillaMensual.setAsignatura(asignatura.get());
        planillaMensual.setCreationDate(new Timestamp(new Date().getTime()));

        PlanillaMensual planillaMensualStored =  planillaMensualRepo.save(planillaMensual);

        Set<Capacidad> capacidades = planillaMensual.getCapacidades().stream().map(
                capacidad -> createCapacidad(capacidad, planillaMensualStored)
        ).collect(Collectors.toSet());

        planillaMensualStored.setCapacidades(capacidades);

        PlanillaMensual finalPlanillaMensualStored = planillaMensualRepo.save(planillaMensualStored);

        return finalPlanillaMensualStored;
    }

    public PlanillaMensual findPlanillaMensual(Integer idPlanillaMensual){
        Optional<PlanillaMensual> planillaMensual = planillaMensualRepo.findById(idPlanillaMensual);

        if(!planillaMensual.isPresent()) return new PlanillaMensual();

        return planillaMensual.get();
    }

    public PlanillaMensual updatePlanillaMensual(Integer idPlanillaMensual, PlanillaMensual planillaMensual) {
        Optional<PlanillaMensual> planillaMensualStoredOptional = planillaMensualRepo.findById(idPlanillaMensual);

        if(!planillaMensualStoredOptional.isPresent()) return new PlanillaMensual();

        PlanillaMensual planillaMensualStored = planillaMensualStoredOptional.get();

        planillaMensualStored.setFecha(planillaMensual.getFecha());
        planillaMensualStored.getCapacidades().forEach(
                capacidad -> {
                    capacidad.getIndicadores().forEach(
                            indicador -> indicadorRepo.delete(indicador)
                    );
                    capacidadRepo.delete(capacidad);
                }
        );

        PlanillaMensual finalPlanillaMensualStored = planillaMensualStored;

        Set<Capacidad> capacidades = planillaMensual.getCapacidades().stream().map(
                capacidad -> createCapacidad(capacidad, finalPlanillaMensualStored)
        ).collect(Collectors.toSet());

        planillaMensualStored.setCapacidades(capacidades);
        planillaMensualStored.setLastModifiedDate(new Timestamp(new Date().getTime()));

        planillaMensualStored = planillaMensualRepo.save(planillaMensualStored);

        return planillaMensualStored;
    }

    public Capacidad createCapacidad(Capacidad capacidad, PlanillaMensual planillaMensual){
        Capacidad capacidadToStore = new Capacidad();

        capacidadToStore.setPlanillaMensual(planillaMensual);
        capacidadToStore.setNombre(capacidad.getNombre());
        capacidadToStore.setOrden(capacidad.getOrden());

        Capacidad capacidadStored = capacidadRepo.save(capacidadToStore);

        Set<Indicador> indicadores = capacidad.getIndicadores().stream().map(
                indicador -> createIndicador(indicador, capacidadStored)
        ).collect(Collectors.toSet());

        capacidadStored.setIndicadores(indicadores);

        return capacidadRepo.save(capacidadStored);
    }

    public Indicador createIndicador(Indicador indicador, Capacidad capacidad){
        Indicador indicadorToStore = new Indicador();

        indicadorToStore.setCapacidad(capacidad);
        indicadorToStore.setNombre(indicador.getNombre());
        indicadorToStore.setOrden(indicador.getOrden());
        indicadorToStore.setPuntajeMaximo(indicador.getPuntajeMaximo());

        Indicador indicadorStored = indicadorRepo.save(indicadorToStore);

        return indicadorStored;
    }
}
