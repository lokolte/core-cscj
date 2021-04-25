package com.core.cscj.models.responses;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class CorreccionResponse implements Serializable {
    private Integer id;
    private String puntosLogrados;
    private String observaciones;
    private Timestamp creationDate;
    private Timestamp lastModifiedDate;
    private List<CorreccionTemaResponse> correccionTemas;

    public CorreccionResponse() {
    }

    public CorreccionResponse(Integer id, String puntosLogrados, String observaciones, Timestamp creationDate, Timestamp lastModifiedDate, List<CorreccionTemaResponse> correccionTemas) {
        this.id = id;
        this.puntosLogrados = puntosLogrados;
        this.observaciones = observaciones;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
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

    public List<CorreccionTemaResponse> getCorreccionTemas() {
        return correccionTemas;
    }

    public void setCorreccionTemas(List<CorreccionTemaResponse> correccionTemas) {
        this.correccionTemas = correccionTemas;
    }
}