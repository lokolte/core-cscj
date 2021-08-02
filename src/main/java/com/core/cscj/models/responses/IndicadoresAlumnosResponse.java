package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.PlanillaMensual;

import java.io.Serializable;
import java.util.List;

public class IndicadoresAlumnosResponse implements Serializable {
    private Asignatura asignatura;
    private PlanillaMensual planillaMensual;
    private List<AlumnoIndicadorResponse> alumnos;

    public IndicadoresAlumnosResponse() {
    }

    public IndicadoresAlumnosResponse(Asignatura asignatura, PlanillaMensual planillaMensual, List<AlumnoIndicadorResponse> alumnos) {
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

    public PlanillaMensual getPlanillaMensual() {
        return planillaMensual;
    }

    public void setPlanillaMensual(PlanillaMensual planillaMensual) {
        this.planillaMensual = planillaMensual;
    }

    public List<AlumnoIndicadorResponse> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoIndicadorResponse> alumnos) {
        this.alumnos = alumnos;
    }
}