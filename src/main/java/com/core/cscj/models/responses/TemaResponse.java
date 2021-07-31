package com.core.cscj.models.responses;

import com.core.cscj.models.entities.ArchivosAdjuntos;
import com.core.cscj.models.entities.Tema;

import java.io.Serializable;
import java.util.List;

public class TemaResponse implements Serializable, Comparable<TemaResponse> {
    private Tema tema;
    private List<ArchivosAdjuntos> archivosAdjuntos;

    public TemaResponse() {
    }

    public TemaResponse(Tema tema, List<ArchivosAdjuntos> archivosAdjuntos) {
        this.tema = tema;
        this.archivosAdjuntos = archivosAdjuntos;
    }

    @Override
    public int compareTo(TemaResponse temaResponse){
        return this.getTema().getOrden().compareTo(temaResponse.getTema().getOrden());
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<ArchivosAdjuntos> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<ArchivosAdjuntos> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }
}