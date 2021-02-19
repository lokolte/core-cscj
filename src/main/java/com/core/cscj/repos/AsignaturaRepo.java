package com.core.cscj.repos;

import com.core.cscj.models.entities.Asignatura;
import com.core.cscj.models.entities.Clase;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.entities.Planificacion;
import com.core.cscj.models.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsignaturaRepo extends JpaRepository<Asignatura, Integer>{
    @Query("select a from Asignatura a where a.profesor.id = :idProfesor order by a.orden asc")
    List<Asignatura> findAsignaturasByProfesor(@Param("idProfesor") Integer idProfesor);

    @Query("select c from Asignatura a join a.clases c where a.id = :idAsignatura order by c.orden asc")
    List<Clase> findClasesFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select t from Asignatura a join a.tareas t where a.id = :idAsignatura order by t.orden asc")
    List<Tarea> findTareasFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select p from Asignatura a join a.planificaciones p where a.id = :idAsignatura order by p.orden asc")
    List<Planificacion> findPlanificacionesFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select p from Asignatura a join a.profesor p where a.id = :idAsignatura order by p.lastname asc")
    List<Person> findProfesoresFromAsignatura(@Param("idAsignatura") Integer idAsignatura);
}
