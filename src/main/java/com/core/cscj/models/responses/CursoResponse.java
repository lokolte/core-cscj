package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Curso;

import java.io.Serializable;
import java.util.List;

public class CursoResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Curso curso;

    private final List<Asignatura> asignaturas;

    public CursoResponse(Curso curso, List<Asignatura> asignaturas) {
        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}