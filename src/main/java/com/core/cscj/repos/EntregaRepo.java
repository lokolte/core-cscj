package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.Entrega;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntregaRepo extends JpaRepository<Entrega, Integer>{
    @Query("select e from Tarea t join t.entregas e where t.id = :idTarea order by e.alumno.lastname asc")
    List<Entrega> findEntregasByIdTarea(@Param("idTarea") Integer idTarea);

    @Query("select e from Entrega e where e.alumno.id= :idAlumno and e.tarea.id = :idTarea")
    Entrega findEntregaByIdAlumnoAndIdTarea(@Param("idAlumno") Integer idAlumno, @Param("idTarea") Integer idTarea);
}
