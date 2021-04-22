package com.core.cscj.models.responses;

import java.io.Serializable;
import java.util.List;

public class RespuestaTemaItemResponse implements Serializable {
    private Integer id;
    private Integer idTema;
    private Integer orden;
    private String texto;

    private List<RespuestaOpcionResponse> respuestaOpciones;

    public RespuestaTemaItemResponse() {
    }

    public RespuestaTemaItemResponse(Integer id, Integer idTema, Integer orden, String texto, List<RespuestaOpcionResponse> opciones) {
        this.id = id;
        this.idTema = idTema;
        this.orden = orden;
        this.texto = texto;
        this.respuestaOpciones = opciones;
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

    public List<RespuestaOpcionResponse> getRespuestaOpciones() {
        return respuestaOpciones;
    }

    public void setRespuestaOpciones(List<RespuestaOpcionResponse> respuestaOpciones) {
        this.respuestaOpciones = respuestaOpciones;
    }
}