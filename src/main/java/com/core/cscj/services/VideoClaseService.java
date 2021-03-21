package com.core.cscj.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.requests.VideoClaseRequest;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.models.responses.VideoClaseResponse;
import com.core.cscj.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoClaseService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private VideoClaseRepo videoClaseRepo;

    public List<VideoClaseResponse> findAllVideoClaseFromPersona(String document){
        Person person = personRepo.findByDocument(document);

        if(person == null) return new ArrayList<>();

        Account account = accountRepo.findByDocument(document);

        if(account == null) return new ArrayList<>();

        List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        Date todayDate = new Date();

        if(roles.contains(Roles.ALUMNO.name()) || roles.contains(Roles.TUTOR.name())) {
            Curso curso = person.getCursos().stream().collect(Collectors.toList()).get(0);
            return videoClaseRepo.findAll().stream().filter(videoclase ->
                            (videoclase.getDate().getYear() == todayDate.getYear()
                            && videoclase.getDate().getMonth() == todayDate.getMonth()
                            && getDay(videoclase.getDate()) == getDay(todayDate)
                            && videoclase.getAsignatura().getCurso().getId() == curso.getId())).collect(Collectors.toList())
                    .stream().map(videoClaseFinal ->
                            new VideoClaseResponse(videoClaseFinal.getAsignatura().getCurso(),
                                    videoClaseFinal.getAsignatura(),
                                    videoClaseFinal)).collect(Collectors.toList());
        }else if(roles.contains(Roles.COORDINADOR.name())){
            List<Integer> cursos = person.getCursos().stream().map(curso -> curso.getId()).collect(Collectors.toList());
            return videoClaseRepo.findAll().stream().filter(videoclase ->
                    (cursos.contains(videoclase.getAsignatura().getCurso().getId()))).collect(Collectors.toList())
                    .stream().map(videoClaseFinal ->
                            new VideoClaseResponse(videoClaseFinal.getAsignatura().getCurso(),
                                    videoClaseFinal.getAsignatura(),
                                    videoClaseFinal)).collect(Collectors.toList());
        }else return videoClaseRepo.findVideoClaseByProfesor(person.getId())
                    .stream().map(videoClaseFinal ->
                            new VideoClaseResponse(videoClaseFinal.getAsignatura().getCurso(),
                                    videoClaseFinal.getAsignatura(),
                                    videoClaseFinal)).collect(Collectors.toList());
    }

    private Integer getDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public VideoClase upsertVideoClase(VideoClaseRequest videoClaseRequest) throws ParseException {
        Optional<Asignatura> asignatura = asignaturaRepo.findById(videoClaseRequest.getMateria());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date date = formatter.parse(videoClaseRequest.getFecha());

        VideoClase videoClase;

        if(videoClaseRequest.getId() != null) {
            Optional<VideoClase> videoClaseOptional = videoClaseRepo.findById(videoClaseRequest.getId());
            if(videoClaseOptional.isPresent()) videoClase = videoClaseOptional.get();
            else videoClase = new VideoClase();
        } else videoClase = new VideoClase();

        videoClase.setAsignatura(asignatura.get());
        videoClase.setMinsCatedra(videoClaseRequest.getMinsCatedra());
        videoClase.setHsCatedra(videoClaseRequest.getHsCatedra());
        videoClase.setDate(new Timestamp(date.getTime()));
        videoClase.setInicio(videoClaseRequest.getInicio());
        videoClase.setFin(videoClaseRequest.getFin());
        videoClase.setTitle(videoClaseRequest.getTitulo());
        videoClase.setLink(videoClaseRequest.getLink());

        return videoClaseRepo.save(videoClase);
    }

    public void deleteVideoClase(Integer idVideoClase) throws Exception {
        Optional<VideoClase> videoClase = videoClaseRepo.findById(idVideoClase);

        if(!videoClase.isPresent()) throw new Exception("No existe la video clase con id: " + idVideoClase);

        videoClaseRepo.delete(videoClase.get());
    }

    public VideoClaseResponse getVideoClase(Integer idVideoClase) throws Exception {
        Optional<VideoClase> videoClase = videoClaseRepo.findById(idVideoClase);

        if(!videoClase.isPresent()) throw new Exception("No existe la video clase con id: " + idVideoClase);

        return new VideoClaseResponse(videoClase.get().getAsignatura().getCurso(),
                videoClase.get().getAsignatura(),
                videoClase.get());
    }
}
