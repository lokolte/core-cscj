package com.core.cscj.models.requests;

import java.io.Serializable;

public class ArchivoAdjuntoRequest implements Serializable {
    private String nombre;
    private Integer orden;

    public ArchivoAdjuntoRequest() {
    }

    public ArchivoAdjuntoRequest(String nombre, Integer orden) {
        this.nombre = nombre;
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}