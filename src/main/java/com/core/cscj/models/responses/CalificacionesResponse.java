package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Calificacion;

import java.io.Serializable;
import java.util.List;

public class CalificacionesResponse implements Serializable {
    private Asignatura asignatura;
    private List<Calificacion> calificaciones;

    public CalificacionesResponse() {
    }

    public CalificacionesResponse(Asignatura asignatura, List<Calificacion> calificaciones) {
        this.asignatura = asignatura;
        this.calificaciones = calificaciones;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}