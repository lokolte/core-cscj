package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Indicador;

import java.io.Serializable;
import java.util.List;

public class CapacidadResponse implements Serializable, Comparable<CapacidadResponse> {
    private Integer id;

    private String nombre;

    private Integer orden;

    private List<Indicador> indicadores;

    public CapacidadResponse() {
    }

    public CapacidadResponse(Integer id, String nombre, Integer orden, List<Indicador> indicadores) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.indicadores = indicadores;
    }

    @Override
    public int compareTo(CapacidadResponse capacidad){
        return this.getOrden().compareTo(capacidad.getOrden());
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

    public void setNombre(String name) {
        this.nombre = name;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }
}