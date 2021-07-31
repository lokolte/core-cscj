package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Curso;

import java.io.Serializable;
import java.util.List;

public class RespuestasEvaluacionResponse implements Serializable {
    private Curso curso;
    private EvaluacionResponse evaluacion;
    private List<RespuestaItemResponse> respuestas;

    public RespuestasEvaluacionResponse() {
    }

    public RespuestasEvaluacionResponse(Curso curso, EvaluacionResponse evaluacion, List<RespuestaItemResponse> respuestas) {
        this.curso = curso;
        this.evaluacion = evaluacion;
        this.respuestas = respuestas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public EvaluacionResponse getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(EvaluacionResponse evaluacion) {
        this.evaluacion = evaluacion;
    }

    public List<RespuestaItemResponse> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaItemResponse> respuestas) {
        this.respuestas = respuestas;
    }
}