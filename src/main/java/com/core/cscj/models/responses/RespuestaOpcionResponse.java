package com.core.cscj.models.responses;

import java.io.Serializable;

public class RespuestaOpcionResponse implements Serializable {
    private Integer id;
    private Integer idOpcion;
    private String texto;

    public RespuestaOpcionResponse() {
    }

    public RespuestaOpcionResponse(Integer id, Integer idOpcion, String texto) {
        this.id = id;
        this.idOpcion = idOpcion;
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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