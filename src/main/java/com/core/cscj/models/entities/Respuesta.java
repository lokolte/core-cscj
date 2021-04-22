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
@Table(name="respuesta")
@Data
@NamedQuery(name="Respuesta.findAll", query="SELECT r FROM Respuesta r")
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(name="creation_date")
    private Timestamp creationDate;

    @Column(name="last_modified_date")
    private Timestamp lastModifiedDate;

    @ManyToOne
    @JoinColumn(name="evaluacion_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name="person_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Person alumno;

    @OneToMany(mappedBy="respuesta")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<RespuestaTema> respuestaTemas;

    public Respuesta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Person getAlumno() {
        return alumno;
    }

    public void setAlumno(Person alumno) {
        this.alumno = alumno;
    }

    public Set<RespuestaTema> getRespuestaTemas() {
        return respuestaTemas;
    }

    public void setRespuestaTemas(Set<RespuestaTema> respuestaTemas) {
        this.respuestaTemas = respuestaTemas;
    }
}