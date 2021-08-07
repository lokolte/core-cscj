package com.core.cscj.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jdk.jfr.events.CertificateId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name="calificacion")
@Data
@NamedQuery(name="Calificacion.findAll", query="SELECT c FROM Calificacion c")
public class Calificacion implements Serializable, Comparable<Calificacion> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(length = 200)
    private String nota;

    @Column(length = 1000)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person alumno;

    public Calificacion() {
    }

    @Override
    public int compareTo(Calificacion calificacion) {
        return this.getAlumno().getLastname().compareTo(calificacion.getAlumno().getLastname());
    }
}