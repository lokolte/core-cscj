package com.core.cscj.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="indicadores_alumno")
@Data
@NamedQuery(name="IndicadoresAlumno.findAll", query="SELECT ia FROM IndicadoresAlumno ia")
public class IndicadoresAlumno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(length=1500)
    private Integer puntaje;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person alumno;

    @ManyToOne
    @JoinColumn(name = "indicador_id")
    private Indicador indicador;

    public IndicadoresAlumno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Person getAlumno() {
        return alumno;
    }

    public void setAlumno(Person alumno) {
        this.alumno = alumno;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }
}