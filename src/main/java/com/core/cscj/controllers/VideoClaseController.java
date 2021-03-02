package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.VideoClase;
import com.core.cscj.repos.VideoClaseRepo;
import com.core.cscj.services.AccountService;
import com.core.cscj.services.VideoClaseService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/videoclases")
public class VideoClaseController {
    @Autowired
    private VideoClaseService videoClaseService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<VideoClase> findAll(@RequestHeader("Authorization") String authorization) {
        return videoClaseService.findAllVideoClaseFromPersona(jwtUtil.getDocumentFromJwtToken(authorization));
    }
}