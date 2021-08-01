package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.PlanillaMensual;

import java.io.Serializable;
import java.util.List;

public class PlanillasMensualesResponse implements Serializable {
    private Asignatura asignatura;
    private List<PlanillaMensual> planillasMensuales;

    public PlanillasMensualesResponse() {
    }

    public PlanillasMensualesResponse(Asignatura asignatura, List<PlanillaMensual> planillasMensuales) {
        this.asignatura = asignatura;
        this.planillasMensuales = planillasMensuales;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<PlanillaMensual> getPlanillasMensuales() {
        return planillasMensuales;
    }

    public void setPlanillasMensuales(List<PlanillaMensual> planillasMensuales) {
        this.planillasMensuales = planillasMensuales;
    }
}