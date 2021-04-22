package com.core.cscj.models.responses;

import com.core.cscj.models.entities.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class RespuestaItemResponse implements Serializable {
    private Integer id;
    private Timestamp creationDate;
    private Timestamp lastModifiedDate;
    private Person alumno;
    private List<RespuestaTemaResponse> respuestasTemas;

    public RespuestaItemResponse() {
    }

    public RespuestaItemResponse(Integer id, Timestamp creationDate, Timestamp lastModifiedDate, Person alumno, List<RespuestaTemaResponse> respuestasTemas) {
        this.id = id;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.alumno = alumno;
        this.respuestasTemas = respuestasTemas;
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

    public Person getAlumno() {
        return alumno;
    }

    public void setAlumno(Person alumno) {
        this.alumno = alumno;
    }

    public List<RespuestaTemaResponse> getRespuestasTemas() {
        return respuestasTemas;
    }

    public void setRespuestasTemas(List<RespuestaTemaResponse> respuestasTemas) {
        this.respuestasTemas = respuestasTemas;
    }
}