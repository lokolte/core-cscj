package com.core.cscj.models.requests;

import java.io.Serializable;

public class CorreccionTemaRequest implements Serializable {
    private Integer id;
    private String puntosLogrados;
    private String observaciones;
    private Integer idRespuestaTema;
    private Integer orden;

    public CorreccionTemaRequest() {
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