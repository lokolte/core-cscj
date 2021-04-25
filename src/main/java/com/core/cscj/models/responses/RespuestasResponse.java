package com.core.cscj.models.responses;

import com.core.cscj.models.entities.*;

import java.io.Serializable;
import java.util.List;

public class RespuestasResponse implements Serializable {
    private Curso curso;
    private List<RespuestaResponse> respuestas;

    public RespuestasResponse() {
    }

    public RespuestasResponse(Curso curso, List<RespuestaResponse> respuestas) {
        this.curso = curso;
        this.respuestas = respuestas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<RespuestaResponse> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaResponse> respuestas) {
        this.respuestas = respuestas;
    }
}