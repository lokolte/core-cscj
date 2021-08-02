package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Person;
import com.core.cscj.models.entities.IndicadoresAlumno;

import java.io.Serializable;
import java.util.List;

public class AlumnoIndicadorResponse implements Serializable {
    private Person alumno;
    private List<IndicadoresAlumno> indicadores;

    public AlumnoIndicadorResponse() {
    }

    public AlumnoIndicadorResponse(Person alumno, List<IndicadoresAlumno> indicadores) {
        this.alumno = alumno;
        this.indicadores = indicadores;
    }

    public Person getAlumno() {
        return alumno;
    }

    public void setAlumno(Person alumno) {
        this.alumno = alumno;
    }

    public List<IndicadoresAlumno> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<IndicadoresAlumno> indicadores) {
        this.indicadores = indicadores;
    }
}