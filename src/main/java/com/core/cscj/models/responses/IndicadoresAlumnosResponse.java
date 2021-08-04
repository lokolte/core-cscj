package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;

import java.io.Serializable;
import java.util.List;

public class IndicadoresAlumnosResponse implements Serializable {
    private Asignatura asignatura;
    private PlanillaMensualResponse planillaMensual;
    private List<AlumnoIndicadorResponse> alumnos;

    public IndicadoresAlumnosResponse() {
    }

    public IndicadoresAlumnosResponse(Asignatura asignatura, PlanillaMensualResponse planillaMensual, List<AlumnoIndicadorResponse> alumnos) {
        this.asignatura = asignatura;
        this.planillaMensual = planillaMensual;
        this.alumnos = alumnos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public PlanillaMensualResponse getPlanillaMensual() {
        return planillaMensual;
    }

    public void setPlanillaMensual(PlanillaMensualResponse planillaMensual) {
        this.planillaMensual = planillaMensual;
    }

    public List<AlumnoIndicadorResponse> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoIndicadorResponse> alumnos) {
        this.alumnos = alumnos;
    }
}