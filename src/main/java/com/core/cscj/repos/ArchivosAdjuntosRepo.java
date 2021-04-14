package com.core.cscj.repos;

import com.core.cscj.models.entities.ArchivosAdjuntos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.ArchivosAdjuntos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArchivosAdjuntosRepo extends JpaRepository<ArchivosAdjuntos, Integer>{
    @Query("select aa from ArchivosAdjuntos aa where aa.tipoEntidad = :tipoEntidad and aa.idEntidad = :idEntidad order by aa.id desc")
    List<ArchivosAdjuntos> findArchivosAdjuntosByTipoAAndIdEntidad(@Param("tipoEntidad") String tipoEntidad, @Param("idEntidad") Integer idEntidad);
}
