package com.core.cscj.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Table(name="archivos_adjuntos")
@Data
@NamedQuery(name="ArchivosAdjuntos.findAll", query="SELECT aa FROM ArchivosAdjuntos aa")
public class ArchivosAdjuntos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false, length=1000)
    private String nombre;

    @Column(name="creation_date")
    private Timestamp creationDate;

    @Column(name = "download_url", nullable=false, length=1000)
    private String downloadUrl;

    @Column(name = "file_type", nullable=false, length=200)
    private String fileType;

    @Column(nullable=false, length=100)
    private long size;

    @Column(name = "tipo_entidad", nullable=false, length=100)
    private String tipoEntidad;

    @Column(name = "id_entidad", nullable=false)
    private Integer idEntidad;

    public ArchivosAdjuntos(){

    }

    public ArchivosAdjuntos(String nombre, Timestamp creationDate, String downloadUrl, String fileType, long size, String tipoEntidad, Integer idEntidad) {
        this.nombre = nombre;
        this.creationDate = creationDate;
        this.downloadUrl = downloadUrl;
        this.fileType = fileType;
        this.size = size;
        this.tipoEntidad = tipoEntidad;
        this.idEntidad = idEntidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }
}