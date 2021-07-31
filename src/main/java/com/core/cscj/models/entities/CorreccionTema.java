package com.core.cscj.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Table(name="correccion_tema")
@Data
@NamedQuery(name="CorreccionTema.findAll", query="SELECT ct FROM CorreccionTema ct")
public class CorreccionTema implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @Column(name="puntos_logrados", length=200)
    private String puntosLogrados;

    @Column(length=20000)
    private String observacion;

    @ManyToOne
    @JoinColumn(name="correccion_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Correccion correccion;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "respuesta_tema_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RespuestaTema respuestaTema;

    public CorreccionTema() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getPuntosLogrados() {
        return puntosLogrados;
    }

    public void setPuntosLogrados(String puntosLogrados) {
        this.puntosLogrados = puntosLogrados;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Correccion getCorreccion() {
        return correccion;
    }

    public void setCorreccion(Correccion correccion) {
        this.correccion = correccion;
    }

    public RespuestaTema getRespuestaTema() {
        return respuestaTema;
    }

    public void setRespuestaTema(RespuestaTema respuestaTema) {
        this.respuestaTema = respuestaTema;
    }
}