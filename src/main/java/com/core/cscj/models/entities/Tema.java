package com.core.cscj.models.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@Table(name="tema")
@Data
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=20000)
    private String sentencia;

    @Column(length = 100)
    private String puntos;

    @Column(length = 200)
    private String tipoTema;

    @Column(name="permitir_adjuntos")
    private Boolean permitirAdjuntos;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @ManyToOne
    @JoinColumn(name="evaluacion_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Evaluacion evaluacion;

    @OneToMany(mappedBy="tema")
    private Set<Opcion> opciones;

    public Tema() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getTipoTema() {
        return tipoTema;
    }

    public void setTipoTema(String tipoTema) {
        this.tipoTema = tipoTema;
    }

    public Boolean getPermitirAdjuntos() {
        return permitirAdjuntos;
    }

    public void setPermitirAdjuntos(Boolean permitirAdjuntos) {
        this.permitirAdjuntos = permitirAdjuntos;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Set<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(Set<Opcion> opciones) {
        this.opciones = opciones;
    }
}