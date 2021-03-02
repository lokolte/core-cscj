package com.core.cscj.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Table(name="video_clase")
@Data
@NamedQuery(name="VideoClase.findAll", query="SELECT vc FROM VideoClase vc")
public class VideoClase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=200)
    private String title;

    @Column(name="date", nullable=false)
    private Timestamp date;

    @Column(name = "hs_catedra", nullable=false)
    private Integer hsCatedra;

    @Column(nullable=false, length=200)
    private String inicio;

    @Column(nullable=false, length=200)
    private String fin;

    @Column(nullable=false, length=500)
    private String link;

    @Column(name = "mins_catedra", nullable=false)
    private Integer minsCatedra;

    @ManyToOne
    @JoinColumn(name="asignatura_id")
    private Asignatura asignatura;

    public VideoClase() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getHsCatedra() {
        return hsCatedra;
    }

    public void setHsCatedra(Integer hsCatedra) {
        this.hsCatedra = hsCatedra;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getMinsCatedra() {
        return minsCatedra;
    }

    public void setMinsCatedra(Integer minsCatedra) {
        this.minsCatedra = minsCatedra;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}