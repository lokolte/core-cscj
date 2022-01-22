package com.core.cscj.models.requests;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.PlanillaMensual;

import java.io.Serializable;
import java.util.List;

public class IndicadoresAlumnosRequest implements Serializable {
    private Asignatura asignatura;
    private PlanillaMensual planillaMensual;
    private List<AlumnoIndicadorRequest> alumnos;

    public IndicadoresAlumnosRequest() {
    }

    public IndicadoresAlumnosRequest(Asignatura asignatura, PlanillaMensual planillaMensual, List<AlumnoIndicadorRequest> alumnos) {
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

    public List<AlumnoIndicadorRequest> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoIndicadorRequest> alumnos) {
        this.alumnos = alumnos;
    }
}