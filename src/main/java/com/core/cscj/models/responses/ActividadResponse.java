package com.core.cscj.models.responses;

import com.core.cscj.models.Actividad;
import com.core.cscj.models.entities.ArchivosAdjuntos;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

public class ActividadResponse implements Serializable, Comparable<ActividadResponse> {
    private Actividad actividad;
    private EntregaResponse entrega;
    private List<ArchivosAdjuntos> archivosAdjuntos;

    public ActividadResponse() {
    }

    public ActividadResponse(Actividad actividad, EntregaResponse entrega, List<ArchivosAdjuntos> archivosAdjuntos) {
        this.actividad = actividad;
        this.archivosAdjuntos = archivosAdjuntos;
        this.entrega = entrega;
    }

    @Override
    public int compareTo(ActividadResponse actividadResponse) {
        return actividadResponse.getActividad().getOrden().compareTo(this.actividad.getOrden());
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public EntregaResponse getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaResponse entrega) {
        this.entrega = entrega;
    }

    public List<ArchivosAdjuntos> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivosAdjuntos> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}