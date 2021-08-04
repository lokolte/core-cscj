package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.IndicadoresAlumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndicadoresAlumnoRepo extends JpaRepository<IndicadoresAlumno, Integer>{
    @Query("select ia from IndicadoresAlumno ia where ia.indicador.id = :idIndicador")
    List<IndicadoresAlumno> findAllIndicadoresAlumnoByIdIndicador(@Param("idIndicador") Integer idIndicador);

    @Query("select ia from IndicadoresAlumno ia where ia.planillaMensual.id = :idPlanillMensual and ia.alumno.id = :idAlumno order by ia.indicador.capacidad.orden, ia.indicador.orden")
    List<IndicadoresAlumno> findAllIndicadoresAlumnoByFromPlanillaMensualAndAlumno(
            @Param("idPlanillMensual") Integer idPlanillMensual,
            @Param("idAlumno") Integer idAlumno);
}
