package com.core.cscj.models.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="etapa")
@Data
@NamedQuery(name="Etapa.findAll", query="SELECT e FROM Etapa e")
public class Etapa implements Serializable, Comparable<Etapa> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column
    private Integer etapa;

    @Column(name="nombre_etapa", length = 100)
    private String nombreEtapa;

    @Column(name="nombre_abreviado", length = 100)
    private String nombreAbreviado;

    @OneToMany(mappedBy = "etapa")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Calificacion> calificaciones;

    public Etapa() {
    }

    @Override
    public int compareTo(Etapa etapa) {
        return this.etapa.compareTo(etapa.getEtapa());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEtapa() {
        return etapa;
    }

    public void setEtapa(Integer etapa) {
        this.etapa = etapa;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public String getNombreAbreviado() {
        return nombreAbreviado;
    }

    public void setNombreAbreviado(String nombreAbreviado) {
        this.nombreAbreviado = nombreAbreviado;
    }

    public Set<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Set<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void setCalificacion(Calificacion calificacion) {
        if(this.calificaciones == null)
            this.calificaciones = new HashSet<>();
        this.calificaciones.add(calificacion);
    }
}