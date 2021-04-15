package com.core.cscj.models.entities;

import javax.persistence.*;

import com.core.cscj.models.Actividad;

import com.core.cscj.models.enums.Entidades;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Set;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="evaluacion")
@Data
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Actividad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=500)
    private String nombre;

    @Column(length=100)
    private String etapa;

    @Column(name="tipo_instrumento", length=1000)
    private String tipoInstrumento;

    @Column(length=10000)
    private String capacidades;

    @Column(length=10000)
    private String indicadores;

    @Column(length=10000)
    private String instrucciones;

    @Column(name="tipo_actividad", nullable=false, length=300)
    private String tipoActividad;

    //Is created at the creation moment considering the other activities of the asignatura
    @Column(nullable=false)
    private Integer orden;

    //This is setted to false by default, but only setted on creation, will be updated by an extra endpoint
    @Column(nullable=false)
    private Boolean habilitado;

    @Column(nullable=false)
    private Timestamp fecha;

    @Column(length=50)
    private String inicio;

    //Updated when a evaluacion habilitado = true
    @Column(name="inicio_date")
    private Timestamp inicioDate;

    @Column(length=50)
    private String fin;

    //Updated when habilitado = true and setted back to false
    @Column(name="fin_date")
    private Timestamp finDate;

    @Column(name = "total_puntos", length=100)
    private String totalPuntos;

    @Column(name = "hs_catedra", nullable=false)
    private Integer hsCatedra;

    @Column(name = "mins_catedra", nullable=false)
    private Integer minsCatedra;

    @Column(name="creation_date")
    private Timestamp creationDate;

    @Column(name="last_modified_date")
    private Timestamp lastModifiedDate;

    @ManyToMany
    @JoinTable(name = "evaluacion_persons",
            joinColumns = @JoinColumn(name = "evaluacion_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Person> alumnos;

    @ManyToOne
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;

    @OneToMany(mappedBy="evaluacion")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Tema> temas;

    public Evaluacion() {
        this.tipoActividad = Entidades.EVALUACION.name();
    }

    @Override
    public int compareTo(Actividad evaluacion){
        return this.getOrden().compareTo(evaluacion.getOrden());
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
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

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
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

    public Integer getHsCatedra() {
        return hsCatedra;
    }

    public void setHsCatedra(Integer hsCatedra) {
        this.hsCatedra = hsCatedra;
    }

    public Integer getMinsCatedra() {
        return minsCatedra;
    }

    public void setMinsCatedra(Integer minsCatedra) {
        this.minsCatedra = minsCatedra;
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

    public Set<Person> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Person> alumnos) {
        this.alumnos = alumnos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Set<Tema> getTemas() {
        return temas;
    }

    public void setTemas(Set<Tema> temas) {
        this.temas = temas;
    }
}