package com.core.cscj.models.requests;

import com.core.cscj.models.entities.Person;
import com.core.cscj.models.entities.IndicadoresAlumno;

import java.io.Serializable;
import java.util.List;

public class AlumnoIndicadorRequest implements Serializable {
    private Person alumno;
    private List<IndicadoresAlumno> indicadores;

    public AlumnoIndicadorRequest() {
    }

    public AlumnoIndicadorRequest(Person alumno, List<IndicadoresAlumno> indicadores) {
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