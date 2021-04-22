package com.core.cscj.models.requests;

import java.io.Serializable;
import java.util.List;

public class RespuestaTemaRequest implements Serializable {
    private Integer id;
    private Integer idTema;
    private Integer orden;
    private String texto;

    private List<RespuestaOpcionRequest> opciones;
    private List<ArchivoAdjuntoRequest> archivosAdjuntos;

    public RespuestaTemaRequest() {
    }

    public RespuestaTemaRequest(Integer id, Integer idTema, Integer orden, String texto, List<RespuestaOpcionRequest> opciones, List<ArchivoAdjuntoRequest> archivosAdjuntos) {
        this.id = id;
        this.idTema = idTema;
        this.orden = orden;
        this.texto = texto;
        this.opciones = opciones;
        this.archivosAdjuntos = archivosAdjuntos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<RespuestaOpcionRequest> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<RespuestaOpcionRequest> opciones) {
        this.opciones = opciones;
    }

    public List<ArchivoAdjuntoRequest> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivoAdjuntoRequest> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}