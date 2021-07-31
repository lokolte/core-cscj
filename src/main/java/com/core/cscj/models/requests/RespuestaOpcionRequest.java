package com.core.cscj.models.requests;

import java.io.Serializable;

public class RespuestaOpcionRequest implements Serializable {
    private Integer idOpcion;
    private String texto;

    public RespuestaOpcionRequest() {
    }

    public RespuestaOpcionRequest(Integer idOpcion, String texto) {
        this.idOpcion = idOpcion;
        this.texto = texto;
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}