package com.core.cscj.models.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="planilla_mensual")
@Data
@NamedQuery(name="PlanillaMensual.findAll", query="SELECT pm FROM PlanillaMensual pm")
public class PlanillaMensual implements Serializable, Comparable<PlanillaMensual>  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column
    private Timestamp fecha;

    @Column(name="etapa", length=200)
    private String etapa;

    @Column(name="creation_date")
    private Timestamp creationDate;

    @Column(name="last_modified_date")
    private Timestamp lastModifiedDate;

    @OneToMany(mappedBy="planillaMensual")
    private Set<Capacidad> capacidades;

    @OneToMany(mappedBy="planillaMensual")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<IndicadoresAlumno> indicadoresAlumnos;

    @ManyToOne
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;

    public PlanillaMensual() {
    }

    @Override
    public int compareTo(PlanillaMensual planillaMensual){
        return this.getFecha().compareTo(planillaMensual.getFecha());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<Capacidad> getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(Set<Capacidad> capacidades) {
        this.capacidades = capacidades;
    }

    public Set<IndicadoresAlumno> getIndicadoresAlumnos() {
        return indicadoresAlumnos;
    }

    public void setIndicadoresAlumnos(Set<IndicadoresAlumno> indicadoresAlumnos) {
        this.indicadoresAlumnos = indicadoresAlumnos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}