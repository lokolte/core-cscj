package com.core.cscj.models.requests;

import java.io.Serializable;
import java.util.List;

public class TemaRequest implements Serializable {
    private String sentencia;
    private String puntos;
    private String tipoTema;
    private Boolean permitirAdjuntos;
    private Integer orden;

    private List<OpcionRequest> opciones;
    private List<ArchivoAdjuntoRequest> archivosAdjuntos;

    public TemaRequest() {
    }

    public TemaRequest(String sentencia, Boolean permitirAdjuntos, String tipoTema, String puntos, Integer orden, List<OpcionRequest> opciones, List<ArchivoAdjuntoRequest> archivosAdjuntos) {
        this.sentencia = sentencia;
        this.puntos = puntos;
        this.tipoTema = tipoTema;
        this.permitirAdjuntos = permitirAdjuntos;
        this.orden = orden;
        this.opciones = opciones;
        this.archivosAdjuntos = archivosAdjuntos;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getTipoTema() {
        return tipoTema;
    }

    public void setTipoTema(String tipoTema) {
        this.tipoTema = tipoTema;
    }

    public Boolean getPermitirAdjuntos() {
        return permitirAdjuntos;
    }

    public void setPermitirAdjuntos(Boolean permitirAdjuntos) {
        this.permitirAdjuntos = permitirAdjuntos;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<OpcionRequest> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionRequest> opciones) {
        this.opciones = opciones;
    }

    public List<ArchivoAdjuntoRequest> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivoAdjuntoRequest> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}