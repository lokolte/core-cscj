package com.core.cscj.repos;

import com.core.cscj.models.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsignaturaRepo extends JpaRepository<Asignatura, Integer>{
    @Query("select a from Curso c join c.asignaturas a where c.id = :idCurso and a.profesor.id = :idPersona order by a.orden asc")
    List<Asignatura> findAsignaturasFromCursoByPersona(@Param("idPersona") Integer idPersona, @Param("idCurso") Integer idCurso);

    @Query("select c from Asignatura a join a.clases c where a.id = :idAsignatura order by c.orden asc")
    List<Clase> findClasesFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select t from Asignatura a join a.tareas t where a.id = :idAsignatura order by t.orden asc")
    List<Tarea> findTareasFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select e from Asignatura a join a.evaluaciones e where a.id = :idAsignatura order by e.orden asc")
    List<Evaluacion> findEvaluacionesFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select p from Asignatura a join a.planificaciones p where a.id = :idAsignatura order by p.orden asc")
    List<Planificacion> findPlanificacionesFromAsignatura(@Param("idAsignatura") Integer idAsignatura);

    @Query("select p from Asignatura a join a.profesor p where a.id = :idAsignatura order by p.lastname asc")
    List<Person> findProfesoresFromAsignatura(@Param("idAsignatura") Integer idAsignatura);
}
