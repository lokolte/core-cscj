package com.core.cscj.models.responses;

import com.core.cscj.models.entities.*;

import java.io.Serializable;
import java.util.List;

public class RespuestasAsignaturaResponse implements Serializable {
    private Curso curso;
    private Asignatura asignatura;
    private List<EvaluacionResponse> evaluaciones;

    public RespuestasAsignaturaResponse() {
    }

    public RespuestasAsignaturaResponse(Curso curso, Asignatura asignatura, List<EvaluacionResponse> evaluaciones) {
        this.curso = curso;
        this.asignatura = asignatura;
        this.evaluaciones = evaluaciones;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<EvaluacionResponse> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionResponse> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
}