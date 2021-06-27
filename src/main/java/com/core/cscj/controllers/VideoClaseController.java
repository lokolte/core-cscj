package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.entities.VideoClase;
import com.core.cscj.models.requests.VideoClaseRequest;
import com.core.cscj.models.responses.VideoClaseResponse;
import com.core.cscj.services.VideoClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/videoclases")
@CacheConfig(cacheNames = {"cache_videoclases"})
public class VideoClaseController {
    @Autowired
    private VideoClaseService videoClaseService;

    @Autowired
    private JwtUtil jwtUtil;

    @Cacheable
    @GetMapping
    public List<VideoClaseResponse> findAll(@RequestHeader("Authorization") String authorization) {
        return videoClaseService.findAllVideoClaseFromPersona(jwtUtil.getDocumentFromJwtToken(authorization));
    }

    @CachePut
    @PostMapping
    public VideoClase upsertVideoClase(@RequestBody VideoClaseRequest videoClaseRequest)  throws ParseException {
        return videoClaseService.upsertVideoClase(videoClaseRequest);
    }

    @DeleteMapping(value = "/{idVideoClase}")
    public void deleteVideoClase(@PathVariable("idVideoClase") Integer idVideoClase)  throws Exception {
        videoClaseService.deleteVideoClase(idVideoClase);
    }

    @Cacheable
    @GetMapping(value = "/{idVideoClase}")
    public VideoClaseResponse getVideoClase(@PathVariable("idVideoClase") Integer idVideoClase)  throws Exception {
        return videoClaseService.getVideoClase(idVideoClase);
    }
}