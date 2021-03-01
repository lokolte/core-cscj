package com.core.cscj.services;

import com.core.cscj.exceptions.FileStorageException;
import com.core.cscj.exceptions.MyFileNotFoundException;
import com.core.cscj.models.responses.LoadedFile;
import com.core.cscj.properties.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    private final String configuredDir;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.configuredDir = fileStorageProperties.getUploadDir();
        this.fileStorageLocation = createDir(null);
    }

    private Path createDir(String aditional){
        String postfix = (aditional != null) ? "/" + aditional : "";

        Path fileStorageLocation = Paths.get(this.configuredDir + postfix)
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("No se puede crear el directorio donde los archivos seran guardados.", ex);
        }

        return fileStorageLocation;
    }

    private Path getPath(String aditional){
        String postfix = (aditional != null) ? "/" + aditional : "";

        return Paths.get(this.configuredDir + postfix)
                .toAbsolutePath().normalize();
    }

    private String storeFile(String tipoActividad, Integer idActividad, MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Lo sentimos! El archivo contiene caracteres inválidos " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = createDir(tipoActividad + "/" + idActividad).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("No se puede guardar el archivo " + fileName + ". Por favor intente nuevamente!", ex);
        }
    }

    public Resource loadFileAsResource(String tipoEntidad, Integer idEntidad, String fileName) {
        try {
            Path filePath = getPath(tipoEntidad + "/" + idEntidad).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("Archivo no encontrado " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("Archivo no encontrado " + fileName, ex);
        }
    }

    private LoadedFile uploadFile(String tipoActividad, Integer idActividad, MultipartFile file) {
        String fileName = storeFile(tipoActividad, idActividad, file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("archivos/download/" + tipoActividad + "/" + idActividad + "/")
                .path(fileName)
                .toUriString();

        return new LoadedFile(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    public List<LoadedFile> uploadMultipleFiles(String tipoActividad, Integer idActividad, MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(tipoActividad, idActividad, file))
                .collect(Collectors.toList());
    }
}