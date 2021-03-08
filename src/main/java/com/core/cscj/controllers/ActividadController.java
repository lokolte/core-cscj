package com.core.cscj.controllers;

import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Tarea;
import com.core.cscj.models.responses.ActividadResponse;
import com.core.cscj.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping(value="/clases/{idClase}")
    public ActividadResponse findClase(@PathVariable("idClase") Integer idClase) {
        return asignaturaService.findClase(idClase);
    }

    @GetMapping(value="/tareas/{idTarea}")
    public ActividadResponse findTarea(@PathVariable("idTarea") Integer idTarea) {
        return asignaturaService.findTarea(idTarea);
    }

    @PutMapping(value="/clases/{idClase}")
    public ActividadResponse updateClase(@PathVariable("idClase") Integer idClase,
                                         @RequestPart(value = "clase") Clase clase,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.updateClase(idClase, clase, files);
    }

    @PutMapping(value="/tareas/{idTarea}")
    public ActividadResponse updateTarea(@PathVariable("idTarea") Integer idTarea,
                                         @RequestPart(value = "tarea") Tarea tarea,
                                         @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return asignaturaService.updateTarea(idTarea, tarea, files);
    }
}
