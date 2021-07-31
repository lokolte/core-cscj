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
@Table(name="respuesta_opcion")
@Data
@NamedQuery(name="RespuestaOpcion.findAll", query="SELECT ro FROM RespuestaOpcion ro")
public class RespuestaOpcion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(length=200)
    private String texto;

    @ManyToOne
    @JoinColumn(name="respuesta_tema_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RespuestaTema respuestaTema;

    @ManyToOne
    @JoinColumn(name="opcion_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Opcion opcion;

    public RespuestaOpcion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public RespuestaTema getRespuestaTema() {
        return respuestaTema;
    }

    public void setRespuestaTema(RespuestaTema respuestaTema) {
        this.respuestaTema = respuestaTema;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
}