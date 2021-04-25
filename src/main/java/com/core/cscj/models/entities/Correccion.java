package com.core.cscj.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="correccion")
@Data
@NamedQuery(name="Correccion.findAll", query="SELECT c FROM Correccion c")
public class Correccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(name="puntos_logrados", length=200)
    private String puntosLogrados;

    @Column(length=20000)
    private String observaciones;

    @Column(name="creation_date")
    private Timestamp creationDate;

    @Column(name="last_modified_date")
    private Timestamp lastModifiedDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "respuesta_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Respuesta respuesta;

    @OneToMany(mappedBy="correccion")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<CorreccionTema> correccionTemas;

    public Correccion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuntosLogrados() {
        return puntosLogrados;
    }

    public void setPuntosLogrados(String puntosLogrados) {
        this.puntosLogrados = puntosLogrados;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Set<CorreccionTema> getCorreccionTemas() {
        return correccionTemas;
    }

    public void setCorreccionTemas(Set<CorreccionTema> correccionTemas) {
        this.correccionTemas = correccionTemas;
    }
}