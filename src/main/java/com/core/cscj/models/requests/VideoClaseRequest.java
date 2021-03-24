package com.core.cscj.models.requests;

import java.io.Serializable;
import java.sql.Timestamp;

public class VideoClaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer curso;
    private Integer materia;
    private Integer minsCatedra;
    private Integer hsCatedra;
    private String inicio;
    private String fin;
    private String link;
    private String titulo;
    private String fecha;
    private Timestamp fechaStr;

    public VideoClaseRequest(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getMateria() {
        return materia;
    }

    public void setMateria(Integer materia) {
        this.materia = materia;
    }

    public Integer getMinsCatedra() {
        return minsCatedra;
    }

    public void setMinsCatedra(Integer minsCatedra) {
        this.minsCatedra = minsCatedra;
    }

    public Integer getHsCatedra() {
        return hsCatedra;
    }

    public void setHsCatedra(Integer hsCatedra) {
        this.hsCatedra = hsCatedra;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaStr() {
        return fechaStr;
    }

    public void setFechaStr(Timestamp fechaStr) {
        this.fechaStr = fechaStr;
    }
}
