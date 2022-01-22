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
@Table(name="opcion")
@Data
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=1000)
    private String texto;

    @Column(nullable=false)
    private Boolean principal;

    @Column(nullable=false)
    private Integer orden;

    @Column
    private Boolean correcta;

    @ManyToOne
    @JoinColumn(name="tema_id")
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Tema tema;

    @OneToMany(mappedBy="opcion", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<RespuestaOpcion> respuestasOpciones;

    public Opcion() {
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

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Set<RespuestaOpcion> getRespuestasOpciones() {
        return respuestasOpciones;
    }

    public void setRespuestasOpciones(Set<RespuestaOpcion> respuestasOpciones) {
        this.respuestasOpciones = respuestasOpciones;
    }
}