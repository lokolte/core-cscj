package com.core.cscj.models.responses;

import java.io.Serializable;
import java.util.List;

public class RespuestasEvaluacionResponse implements Serializable {
    private EvaluacionResponse evaluacion;
    private List<RespuestaItemResponse> respuestas;

    public RespuestasEvaluacionResponse() {
    }

    public RespuestasEvaluacionResponse(EvaluacionResponse evaluacion, List<RespuestaItemResponse> respuestas) {
        this.evaluacion = evaluacion;
        this.respuestas = respuestas;
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