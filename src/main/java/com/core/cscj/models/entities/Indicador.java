package com.core.cscj.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="indicador")
@Data
@NamedQuery(name="Indicador.findAll", query="SELECT i FROM Indicador i")
public class Indicador implements Serializable, Comparable<Indicador> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=1000)
    private String nombre;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @Column(name="puntaje_maximo", nullable=false)
    private Integer puntajeMaximo;

    @ManyToOne
    @JoinColumn(name="capacidad_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Capacidad capacidad;

    @OneToMany(mappedBy = "indicador")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<IndicadoresAlumno> indicadoresAlumnos;

    public Indicador() {
    }

    @Override
    public int compareTo(Indicador indicador){
        return this.getOrden().compareTo(indicador.getOrden());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}