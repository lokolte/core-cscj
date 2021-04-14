package com.core.cscj.models.responses;

import com.core.cscj.models.entities.ArchivosAdjuntos;
import com.core.cscj.models.entities.Entrega;

import java.io.Serializable;
import java.util.List;

public class EntregaResponse implements Serializable, Comparable<EntregaResponse> {
    private Entrega entrega;
    private List<ArchivosAdjuntos> archivosAdjuntos;

    public EntregaResponse() {
    }

    public EntregaResponse(Entrega entrega, List<ArchivosAdjuntos> archivosAdjuntos) {
        this.entrega = entrega;
        this.archivosAdjuntos = archivosAdjuntos;
    }

    @Override
    public int compareTo(EntregaResponse entregaResponse){
        return this.getEntrega().getAlumno().getLastname().compareTo(entregaResponse.getEntrega().getAlumno().getLastname());
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public List<ArchivosAdjuntos> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivosAdjuntos> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}