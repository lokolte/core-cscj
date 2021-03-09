package com.core.cscj.models.entities;

import javax.persistence.*;

import com.core.cscj.models.Actividad;

import com.core.cscj.models.enums.Entidades;
import lombok.Data;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="clase")
@Data
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Actividad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=700)
    private String nombre;

    @Column(length=1500)
    private String description;

    @Column(name="tipo_actividad", nullable=false, length=300)
    private String tipoActividad;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @ManyToOne
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;

    public Clase() {
        this.tipoActividad = Entidades.CLASE.name();
    }

    @Override
    public int compareTo(Actividad clase){
        return this.getOrden().compareTo(clase.getOrden());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}