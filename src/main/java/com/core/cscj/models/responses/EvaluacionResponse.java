package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.entities.Evaluacion;

import java.io.Serializable;
import java.util.List;

public class EvaluacionResponse implements Serializable, Comparable<EvaluacionResponse> {
    private Evaluacion evaluacion;
    private Curso curso;
    private List<TemaResponse> temas;

    public EvaluacionResponse() {
    }

    public EvaluacionResponse(Evaluacion evaluacion, Curso curso, List<TemaResponse> temas) {
        this.evaluacion = evaluacion;
        this.curso = curso;
        this.temas = temas;
    }

    @Override
    public int compareTo(EvaluacionResponse evaluacionResponse) {
        return evaluacionResponse.getEvaluacion().getCreationDate().compareTo(this.getEvaluacion().getCreationDate());
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<TemaResponse> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaResponse> temas) {
        this.temas = temas;
    }
}