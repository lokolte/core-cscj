package com.core.cscj.models.requests;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class EvaluacionRequest implements Serializable {
    private Integer id;
    private String nombre;
    private String etapa;
    private String tipoInstrumento;
    private String capacidades;
    private String indicadores;
    private String instrucciones;
    private Timestamp fecha;
    private String inicio;
    private String fin;
    private String totalPuntos;
    private Integer hsCatedra;
    private Integer minsCatedra;

    private List<TemaRequest> temas;

    public EvaluacionRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(String capacidades) {
        this.capacidades = capacidades;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(String totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public Integer getHsCatedra() {
        return hsCatedra;
    }

    public void setHsCatedra(Integer hsCatedra) {
        this.hsCatedra = hsCatedra;
    }

    public Integer getMinsCatedra() {
        return minsCatedra;
    }

    public void setMinsCatedra(Integer minsCatedra) {
        this.minsCatedra = minsCatedra;
    }

    public List<TemaRequest> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaRequest> temas) {
        this.temas = temas;
    }
}