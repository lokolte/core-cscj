package com.core.cscj.models.requests;

import java.io.Serializable;
import java.util.List;

public class CorreccionRequest implements Serializable {
    private Integer id;
    private String puntosLogrados;
    private String observaciones;
    private List<CorreccionTemaRequest> correccionTemas;

    public CorreccionRequest() {
    }

    public CorreccionRequest(Integer id, String puntosLogrados, String observaciones, List<CorreccionTemaRequest> correccionTemas) {
        this.id = id;
        this.puntosLogrados = puntosLogrados;
        this.observaciones = observaciones;
        this.correccionTemas = correccionTemas;
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

    public List<CorreccionTemaRequest> getCorreccionTemas() {
        return correccionTemas;
    }

    public void setCorreccionTemas(List<CorreccionTemaRequest> correccionTemas) {
        this.correccionTemas = correccionTemas;
    }
}