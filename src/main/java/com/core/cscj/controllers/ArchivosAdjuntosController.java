package com.core.cscj.controllers;

import com.core.cscj.services.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/archivos")
public class ArchivosAdjuntosController {
    private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/download/{tipoEntidad}/{idEntidad}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("tipoEntidad") String tipoEntidad,
                                                 @PathVariable("idEntidad") Integer idEntidad,
                                                 @PathVariable("fileName") String fileName,
                                                 HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(tipoEntidad, idEntidad, fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("No se puede determinar el tipo de archivo.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
