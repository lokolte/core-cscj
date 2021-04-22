package com.core.cscj.services;

import com.core.cscj.exceptions.FileStorageException;
import com.core.cscj.exceptions.MyFileNotFoundException;
import com.core.cscj.models.entities.ArchivosAdjuntos;
import com.core.cscj.models.requests.ArchivoAdjuntoRequest;
import com.core.cscj.models.requests.OrdenArchivosAdjuntosRequest;
import com.core.cscj.models.responses.LoadedFileResponse;
import com.core.cscj.properties.FileStorageProperties;
import com.core.cscj.repos.ArchivosAdjuntosRepo;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileStorageService {

    @Autowired
    private ArchivosAdjuntosRepo archivosAdjuntosRepo;

    private final String configuredDir;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.configuredDir = fileStorageProperties.getUploadDir();
        createDir(null);
    }

    public String getConfiguredDir() {
        return configuredDir;
    }

    private Path createDir(String aditional) {
        String postfix = (aditional != null) ? "/" + aditional : "";

        Path fileStorageLocation = Paths.get(getConfiguredDir() + postfix)
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

        return Paths.get(getConfiguredDir() + postfix)
                .toAbsolutePath().normalize();
    }

    private String getFileName(MultipartFile file){
        return StringUtils.cleanPath(file.getOriginalFilename());
    }

    private void storeFile(String tipoActividad, Integer idActividad, Integer idArchivoAdjunto, MultipartFile file, String fileName) {
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = createDir(tipoActividad + "/" + idActividad + "/" + idArchivoAdjunto).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new FileStorageException("No se puede guardar el archivo " + fileName + ". Por favor intente nuevamente!", ex);
        }
    }

    public Resource loadFileAsResource(String tipoEntidad, Integer idEntidad, Integer idArchivoAdjunto, String fileName) {
        try {
            Path filePath = getPath(tipoEntidad + "/" + idEntidad + "/" + idArchivoAdjunto).resolve(fileName).normalize();
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

    public ArchivosAdjuntos uploadFile(String tipoActividad, Integer idActividad, MultipartFile file, String fileNameExtracted) {
        ArchivosAdjuntos archivoAdjunto = new ArchivosAdjuntos(
                "",
                new Timestamp(new Date().getTime()),
                "",
                "",
                0L,
                tipoActividad,
                idActividad
        );
        archivoAdjunto = archivosAdjuntosRepo.save(archivoAdjunto);

        String fileName;
        if(fileNameExtracted != null)
            fileName = fileNameExtracted;
        else fileName = getFileName(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("archivos/download/" + tipoActividad + "/" + idActividad + "/" + archivoAdjunto.getId() + "/")
                .path(fileName)
                .toUriString();

        LoadedFileResponse loadedFile = new LoadedFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());

        archivoAdjunto.setNombre(loadedFile.getFileName());
        archivoAdjunto.setDownloadUrl(loadedFile.getFileDownloadUri());
        archivoAdjunto.setFileType(loadedFile.getFileType());
        archivoAdjunto.setSize(loadedFile.getSize());

        archivoAdjunto = archivosAdjuntosRepo.save(archivoAdjunto);

        storeFile(tipoActividad, idActividad, archivoAdjunto.getId(), file, fileName);

        return archivoAdjunto;
    }

    public List<ArchivosAdjuntos> uploadMultipleFiles(String tipoActividad, Integer idActividad, MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(tipoActividad, idActividad, file, null))
                .collect(Collectors.toList());
    }

    // this function needs to be refactored, we need to delete just the file deleted in another call
    public List<ArchivosAdjuntos> uploadNotRepeatedFiles(String tipoEntidad, Integer idEntidad, List<ArchivosAdjuntos> archivosAdjuntos, MultipartFile[] files) {
        if(files.length > 0)
            for (ArchivosAdjuntos archivoAdjunto : archivosAdjuntos) {
                try {
                    String directory = getConfiguredDir() + "/" + tipoEntidad + "/" + idEntidad + "/" + archivoAdjunto.getId();
                    FileUtils.deleteDirectory(new File(directory));
                    archivosAdjuntosRepo.delete(archivoAdjunto);
                } catch (MalformedURLException ex) {
                    throw new MyFileNotFoundException("Archivo no encontrado " + archivoAdjunto.getNombre(), ex);
                } catch (IOException ioEx) {
                    throw new FileStorageException("Existio un error al borrar el archivo.", ioEx);
                }
            }
        return uploadMultipleFiles(tipoEntidad, idEntidad, files);
    }

    public List<ArchivosAdjuntos> uploadMultipleFilesWihtFormatName(
            String tipoActividad, Integer idActividad,
            List<OrdenArchivosAdjuntosRequest> ordenArchivosAdjuntosRequests,
            Integer orden, MultipartFile[] files
    ) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadOnlyCoincidence(tipoActividad, idActividad, ordenArchivosAdjuntosRequests, orden, file))
                .filter(archivosAdjuntos -> archivosAdjuntos != null)
                .collect(Collectors.toList());
    }

    private ArchivosAdjuntos uploadOnlyCoincidence(String tipoActividad, Integer idActividad,
                                                   List<OrdenArchivosAdjuntosRequest> ordenArchivosAdjuntosRequests,
                                                   Integer orden, MultipartFile file){
        String fileName = obtainNameFromTemaRequest(ordenArchivosAdjuntosRequests, orden, file);

        if(fileName != null)
            return uploadFile(tipoActividad, idActividad, file, fileName);
        else return null;
    }

    private String obtainNameFromTemaRequest(List<OrdenArchivosAdjuntosRequest> ordenArchivosAdjuntosRequests, Integer orden, MultipartFile file) {
        String[] values = getFileName(file).split(":", 0);

        if(values.length != 2) throw new FileStorageException("El formato de los nombres de los archivos debe ser \"ordenItem:ordenArchivo\".");

        Integer ordenItem = Integer.valueOf(values[0]);
        Integer ordenArchivo = Integer.valueOf(values[1]);

        List<OrdenArchivosAdjuntosRequest> ordenArchivosAdjuntosRequestsFiltered = ordenArchivosAdjuntosRequests.stream().filter(
                item -> item.getOrden().equals(orden) && ordenItem.equals(orden)
        ).collect(Collectors.toList());

        if(ordenArchivosAdjuntosRequestsFiltered.size() != 1) return null;

        List<ArchivoAdjuntoRequest> archivoAdjuntoFiltered = ordenArchivosAdjuntosRequestsFiltered.get(0).getArchivosAdjuntos().stream().filter(
                archivoAdjunto -> archivoAdjunto.getOrden() == ordenArchivo
        ).collect(Collectors.toList());

        if(archivoAdjuntoFiltered.size() != 1) throw new FileStorageException("El formato de los nombres de los archivos debe ser \"ordenItem:ordenArchivo\".");

        return archivoAdjuntoFiltered.get(0).getNombre();
    }

    public void deleteFile(String tipoEntidad, Integer idEntidad, ArchivosAdjuntos archivoAdjunto) {
        try {
            String directory = getConfiguredDir() + "/" + tipoEntidad + "/" + idEntidad + "/" + archivoAdjunto.getId();
            FileUtils.deleteDirectory(new File(directory));
            archivosAdjuntosRepo.delete(archivoAdjunto);
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("Archivo no encontrado " + archivoAdjunto.getNombre(), ex);
        } catch (IOException ioEx) {
            throw new FileStorageException("Existio un error al borrar el archivo.", ioEx);
        }
    }
}