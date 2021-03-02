package com.core.cscj.repos;

import com.core.cscj.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.VideoClase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoClaseRepo extends JpaRepository<VideoClase, Integer>{
    @Query("select vc from VideoClase vc join vc.asignatura a join a.profesor p where p.id = :idProfesor order by vc.date desc")
    List<VideoClase> findVideoClaseByProfesor(@Param("idProfesor") Integer idProfesor);
}
