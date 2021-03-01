package com.core.cscj.controllers;

import com.core.cscj.authentication.util.JwtUtil;
import com.core.cscj.models.Actividad;
import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.models.enums.Actividades;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.models.responses.LoadedFile;
import com.core.cscj.services.AsignaturaService;
import com.core.cscj.services.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value="/{idAsignatura}")
    public Asignatura getAsignaturaById(@PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.findAsignaturaById(idAsignatura);
    }

    @GetMapping(value="/{idAsignatura}/actividades")
    public List<Actividad> getAllActividadesFromAsignatura(@RequestHeader("Authorization") String authorization, @PathVariable("idAsignatura") Integer idAsignatura) {
        return asignaturaService.finAllActividades(idAsignatura, jwtUtil.getDocumentFromJwtToken(authorization));
    }

    @PostMapping(value="/{idAsignatura}/clases")
    public ActividadResponse createClase(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "clase") Clase clase,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {

        List<LoadedFile> uploadedFiles = (files != null) ?
                fileStorageService.uploadMultipleFiles(Actividades.CLASE.name(), idAsignatura, files) : new ArrayList<>();

        return asignaturaService.createClase(idAsignatura, clase, uploadedFiles);
    }

    @PostMapping(value="/{idAsignatura}/tareas")
    public ActividadResponse createTarea(@PathVariable("idAsignatura") Integer idAsignatura,
                                         @RequestPart(value = "tarea") Tarea tarea,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {

        List<LoadedFile> uploadedFiles = (files != null) ?
                fileStorageService.uploadMultipleFiles(Actividades.TAREA.name(), idAsignatura, files) : new ArrayList<>();

        return asignaturaService.createTarea(idAsignatura, tarea, uploadedFiles);
    }

}
