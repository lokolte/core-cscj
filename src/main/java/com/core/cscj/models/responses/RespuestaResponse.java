package com.core.cscj.models.responses;

import java.io.Serializable;

public class RespuestaResponse implements Serializable, Comparable<RespuestaResponse>  {
    private EvaluacionResponse evaluacion;
    private RespuestaItemResponse respuesta;

    public RespuestaResponse() {
    }

    public RespuestaResponse(EvaluacionResponse evaluacion, RespuestaItemResponse respuesta) {
        this.evaluacion = evaluacion;
        this.respuesta = respuesta;
    }

    @Override
    public int compareTo(RespuestaResponse respuestaResponse){
        return respuestaResponse.getRespuesta().getCreationDate().compareTo(this.getRespuesta().getCreationDate());
    }

    public EvaluacionResponse getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(EvaluacionResponse evaluacion) {
        this.evaluacion = evaluacion;
    }

    public RespuestaItemResponse getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaItemResponse respuesta) {
        this.respuesta = respuesta;
    }
}