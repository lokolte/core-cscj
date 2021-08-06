package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class PlanillaMensualDummyResponse implements Serializable, Comparable<PlanillaMensualResponse>  {
    private Integer id;

    private Timestamp fecha;

    private String etapa;

    private Timestamp creationDate;

    private Timestamp lastModifiedDate;

    private List<CapacidadResponse> capacidades;

    private Asignatura asignatura;

    public PlanillaMensualDummyResponse() {
    }

    public PlanillaMensualDummyResponse(Integer id, Timestamp fecha, String etapa, Timestamp creationDate, Timestamp lastModifiedDate, List<CapacidadResponse> capacidades, Asignatura asignatura) {
        this.id = id;
        this.fecha = fecha;
        this.etapa = etapa;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.capacidades = capacidades;
        this.asignatura = asignatura;
    }

    @Override
    public int compareTo(PlanillaMensualResponse planillaMensual){
        return this.getFecha().compareTo(planillaMensual.getFecha());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<CapacidadResponse> getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(List<CapacidadResponse> capacidades) {
        this.capacidades = capacidades;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}