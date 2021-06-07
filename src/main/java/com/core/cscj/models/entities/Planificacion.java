package com.core.cscj.models.entities;

import javax.persistence.*;

import com.core.cscj.models.Actividad;

import com.core.cscj.models.enums.Entidades;
import lombok.Data;

import java.sql.Timestamp;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="planificacion")
@Data
@NamedQuery(name="Planificacion.findAll", query="SELECT p FROM Planificacion p")
public class Planificacion implements Actividad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(name="tipo_actividad", nullable=false, length=300)
    private String tipoActividad;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @Column
    private Timestamp fecha;

    @Column(length=2000)
    private String tema;

    @Column(length=10000)
    private String capacidades;

    @Column(length=10000)
    private String indicadores;

    @Column(length=10000)
    private String inicio;

    @Column(length=10000)
    private String desarrollo;

    @Column(length=10000)
    private String fijacion;

    @Column(length=10000)
    private String observacion;

    @Column(length=10000)
    private String duracion;

    @Column(name="cantidad_alumnos")
    private Integer cantidadAlumnos;

    @Column(name="ambito", length=10000)
    private String ambito;

    @Column(name="contenido", length=10000)
    private String contenido;

    @Column(name="creation_date")
    private Timestamp creationDate;

    @Column(name="last_modified_date")
    private Timestamp lastModifiedDate;

    @ManyToOne
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;

    public Planificacion() {
        this.tipoActividad = Entidades.PLANIFICACION.name();
    }

    @Override
    public int compareTo(Actividad planificacion){
        return this.getOrden().compareTo(planificacion.getOrden());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(String capacidades) {
        this.capacidades = capacidades;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }

    public String getFijacion() {
        return fijacion;
    }

    public void setFijacion(String fijacion) {
        this.fijacion = fijacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Integer getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(Integer cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}