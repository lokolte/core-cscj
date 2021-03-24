package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.entities.VideoClase;

import java.io.Serializable;

public class VideoClaseResponse implements Serializable, Comparable<VideoClaseResponse> {
    private Curso curso;
    private Asignatura asignatura;
    private VideoClase videoClase;

    public VideoClaseResponse() {
    }

    public VideoClaseResponse(Curso curso, Asignatura asignatura, VideoClase videoClase) {
        this.curso = curso;
        this.asignatura = asignatura;
        this.videoClase = videoClase;
    }

    @Override
    public int compareTo(VideoClaseResponse videoClaseResponse){
        return videoClaseResponse.getVideoClase().getDate().compareTo(this.getVideoClase().getDate());
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public VideoClase getVideoClase() {
        return videoClase;
    }

    public void setVideoClase(VideoClase videoClase) {
        this.videoClase = videoClase;
    }
}