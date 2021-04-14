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
@Table(name="asignatura")
@Data
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable, Comparable<Asignatura> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=1000)
    private String nombre;

    @Column(length=1500)
    private String description;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @ManyToOne
    @JoinColumn(name="curso_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person profesor;

    @OneToMany(mappedBy="asignatura")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Clase> clases;

    @OneToMany(mappedBy="asignatura")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Tarea> tareas;

    @OneToMany(mappedBy="asignatura")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Planificacion> planificaciones;

    @OneToMany(mappedBy="asignatura")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Evaluacion> evaluaciones;

    @OneToMany(mappedBy="asignatura", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<VideoClase> videoClases;

    public Asignatura() {
    }

    @Override
    public int compareTo(Asignatura asignatura){
        return this.getOrden().compareTo(asignatura.getOrden());
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Person getProfesor() {
        return profesor;
    }

    public void setProfesor(Person profesor) {
        this.profesor = profesor;
    }

    public Set<Clase> getClases() {
        return clases;
    }

    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Set<Planificacion> getPlanificaciones() {
        return planificaciones;
    }

    public void setPlanificaciones(Set<Planificacion> planificaciones) {
        this.planificaciones = planificaciones;
    }

    public Set<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(Set<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Set<VideoClase> getVideoClases() {
        return videoClases;
    }

    public void setVideoClases(Set<VideoClase> videoClases) {
        this.videoClases = videoClases;
    }
}