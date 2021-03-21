package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Curso;

import java.io.Serializable;
import java.util.List;

public class AlumnoEntregasResponse implements Serializable {
    private Curso curso;
    private List<EntregasResponse> tareas;

    public AlumnoEntregasResponse() {
    }

    public AlumnoEntregasResponse(Curso curso, List<EntregasResponse> tareas) {
        this.curso = curso;
        this.tareas = tareas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<EntregasResponse> getTareas() {
        return tareas;
    }

    public void setTareas(List<EntregasResponse> tareas) {
        this.tareas = tareas;
    }
}