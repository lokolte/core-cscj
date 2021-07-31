package com.core.cscj.models.responses;

import com.core.cscj.models.entities.ArchivosAdjuntos;

import java.io.Serializable;
import java.util.List;

public class RespuestaTemaResponse implements Serializable, Comparable<RespuestaTemaResponse> {
    private RespuestaTemaItemResponse respuestaTema;
    private List<ArchivosAdjuntos> archivosAdjuntos;

    public RespuestaTemaResponse() {
    }

    public RespuestaTemaResponse(RespuestaTemaItemResponse respuestaTema, List<ArchivosAdjuntos> archivosAdjuntos) {
        this.respuestaTema = respuestaTema;
        this.archivosAdjuntos = archivosAdjuntos;
    }

    @Override
    public int compareTo(RespuestaTemaResponse respuestaTemaResponse){
        return this.getRespuestaTema().getOrden().compareTo(respuestaTemaResponse.getRespuestaTema().getOrden());
    }

    public RespuestaTemaItemResponse getRespuestaTema() {
        return respuestaTema;
    }

    public void setRespuestaTema(RespuestaTemaItemResponse respuestaTema) {
        this.respuestaTema = respuestaTema;
    }

    public List<ArchivosAdjuntos> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivosAdjuntos> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}