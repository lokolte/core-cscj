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
@Table(name="entrega")
@Data
@NamedQuery(name="Entrega.findAll", query="SELECT e FROM Entrega e")
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(name="fecha_entrega")
    private Timestamp fechaEntrega;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person alumno;

    @ManyToOne
    @JoinColumn(name="tarea_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Tarea tarea;

    public Entrega() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Timestamp fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Person getAlumno() {
        return alumno;
    }

    public void setAlumno(Person alumno) {
        this.alumno = alumno;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}