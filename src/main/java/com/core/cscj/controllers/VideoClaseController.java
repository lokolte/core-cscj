package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.responses.VideoClaseResponse;
import com.core.cscj.services.VideoClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videoclases")
public class VideoClaseController {
    @Autowired
    private VideoClaseService videoClaseService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<VideoClaseResponse> findAll(@RequestHeader("Authorization") String authorization) {
        return videoClaseService.findAllVideoClaseFromPersona(jwtUtil.getDocumentFromJwtToken(authorization));
    }
}