package com.core.cscj.models.requests;

import java.io.Serializable;
import java.util.List;

public class OrdenArchivosAdjuntosRequest implements Serializable {
    private Integer orden;
    private List<ArchivoAdjuntoRequest> archivosAdjuntos;

    public OrdenArchivosAdjuntosRequest() {
    }

    public OrdenArchivosAdjuntosRequest(Integer orden, List<ArchivoAdjuntoRequest> archivosAdjuntos) {
        this.orden = orden;
        this.archivosAdjuntos = archivosAdjuntos;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<ArchivoAdjuntoRequest> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivoAdjuntoRequest> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}