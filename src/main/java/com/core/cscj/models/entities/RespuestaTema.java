package com.core.cscj.models.entities;

import java.io.Serializable;
import java.util.Set;
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
@Table(name="respuesta_tema")
@Data
@NamedQuery(name="RespuestaTema.findAll", query="SELECT rt FROM RespuestaTema rt")
public class RespuestaTema implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(name="orden", nullable=false)
    private Integer orden;

    @Column(length=20000)
    private String texto;

    @ManyToOne
    @JoinColumn(name="respuesta_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Respuesta respuesta;

    @ManyToOne
    @JoinColumn(name="tema_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Tema tema;

    @OneToMany(mappedBy="respuestaTema")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<RespuestaOpcion> respuestaOpciones;

    public RespuestaTema() {
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Set<RespuestaOpcion> getRespuestaOpciones() {
        return respuestaOpciones;
    }

    public void setRespuestaOpciones(Set<RespuestaOpcion> respuestaOpciones) {
        this.respuestaOpciones = respuestaOpciones;
    }
}