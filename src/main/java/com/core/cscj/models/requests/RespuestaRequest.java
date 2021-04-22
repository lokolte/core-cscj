package com.core.cscj.models.requests;

import java.io.Serializable;
import java.util.List;

public class RespuestaRequest implements Serializable {
    private Integer id;
    private List<RespuestaTemaRequest> respuestasTemas;

    public RespuestaRequest() {
    }

    public RespuestaRequest(Integer id, List<RespuestaTemaRequest> respuestasTemas) {
        this.id = id;
        this.respuestasTemas = respuestasTemas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RespuestaTemaRequest> getRespuestasTemas() {
        return respuestasTemas;
    }

    public void setRespuestasTemas(List<RespuestaTemaRequest> respuestasTemas) {
        this.respuestasTemas = respuestasTemas;
    }
}