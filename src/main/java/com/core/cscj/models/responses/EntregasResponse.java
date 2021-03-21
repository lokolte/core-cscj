package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Tarea;

import java.io.Serializable;
import java.util.List;

public class EntregasResponse implements Serializable, Comparable<EntregasResponse> {
    private Tarea tarea;
    private List<EntregaResponse> entregas;

    public EntregasResponse() {
    }

    public EntregasResponse(Tarea tarea, List<EntregaResponse> entregas) {
        this.tarea = tarea;
        this.entregas = entregas;
    }

    @Override
    public int compareTo(EntregasResponse entregasResponse){
        return entregasResponse.getTarea().getCreationDate().compareTo(this.getTarea().getCreationDate());
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public List<EntregaResponse> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaResponse> entregas) {
        this.entregas = entregas;
    }
}