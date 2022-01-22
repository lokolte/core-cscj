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
@Table(name="capacidad")
@Data
@NamedQuery(name="Capacidad.findAll", query="SELECT c FROM Capacidad c")
public class Capacidad implements Serializable, Comparable<Capacidad> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=1000)
    private String nombre;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @OneToMany(mappedBy="capacidad")
    private Set<Indicador> indicadores;

    @ManyToOne
    @JoinColumn(name="planilla_mensual_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PlanillaMensual planillaMensual;

    public Capacidad() {
    }

    @Override
    public int compareTo(Capacidad capacidad){
        return this.getOrden().compareTo(capacidad.getOrden());
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

    public Set<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(Set<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public PlanillaMensual getPlanillaMensual() {
        return planillaMensual;
    }

    public void setPlanillaMensual(PlanillaMensual planillaMensual) {
        this.planillaMensual = planillaMensual;
    }
}