package com.core.cscj.models.responses;

import java.io.Serializable;

public class CorreccionTemaResponse implements Serializable, Comparable<CorreccionTemaResponse> {
    private Integer id;
    private String puntosLogrados;
    private String observaciones;
    private Integer idRespuestaTema;
    private Integer orden;

    public CorreccionTemaResponse() {
    }

    public CorreccionTemaResponse(Integer id, String puntosLogrados, String observaciones, Integer idRespuestaTema, Integer orden) {
        this.id = id;
        this.puntosLogrados = puntosLogrados;
        this.observaciones = observaciones;
        this.idRespuestaTema = idRespuestaTema;
        this.orden = orden;
    }

    @Override
    public int compareTo(CorreccionTemaResponse correccionTemaResponse) {
        return this.getOrden().compareTo(correccionTemaResponse.getOrden());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuntosLogrados() {
        return puntosLogrados;
    }

    public void setPuntosLogrados(String puntosLogrados) {
        this.puntosLogrados = puntosLogrados;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIdRespuestaTema() {
        return idRespuestaTema;
    }

    public void setIdRespuestaTema(Integer idRespuestaTema) {
        this.idRespuestaTema = idRespuestaTema;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}