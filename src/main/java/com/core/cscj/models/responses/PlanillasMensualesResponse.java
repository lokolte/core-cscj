package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;

import java.io.Serializable;
import java.util.List;

public class PlanillasMensualesResponse implements Serializable {
    private Asignatura asignatura;
    private List<PlanillaMensualResponse> planillasMensuales;

    public PlanillasMensualesResponse() {
    }

    public PlanillasMensualesResponse(Asignatura asignatura, List<PlanillaMensualResponse> planillasMensuales) {
        this.asignatura = asignatura;
        this.planillasMensuales = planillasMensuales;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<PlanillaMensualResponse> getPlanillasMensuales() {
        return planillasMensuales;
    }

    public void setPlanillasMensuales(List<PlanillaMensualResponse> planillasMensuales) {
        this.planillasMensuales = planillasMensuales;
    }
}