package com.core.cscj.services;

import java.util.*;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.*;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.responses.CursoResponse;
import com.core.cscj.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoClaseService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private VideoClaseRepo videoClaseRepo;

    public List<VideoClase> findAllVideoClaseFromPersona(String document){
        Person person = personRepo.findByDocument(document);

        if(person == null) return new ArrayList<>();

        Account account = accountRepo.findByDocument(document);

        if(account == null) return new ArrayList<>();

        List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        Date todayDate = new Date();

        if(roles.contains(Roles.ALUMNO.name()) || roles.contains(Roles.TUTOR.name())) {
            return videoClaseRepo.findAll().stream().filter(videoclase ->
                            (videoclase.getDate().getYear() == todayDate.getYear()
                            && videoclase.getDate().getMonth() == todayDate.getMonth()
                            && videoclase.getDate().getDay() == todayDate.getDay())).collect(Collectors.toList());
        }else return videoClaseRepo.findVideoClaseByProfesor(person.getId());
    }
}
