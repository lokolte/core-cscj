package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.entities.Asignatura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepo extends JpaRepository<Curso, Integer>{
    @Query("select c from Curso c join c.persons p join p.accounts a join a.roles r where r.name = :role and p.id = :idProfesor order by c.orden asc")
    List<Curso> findCursosByPerson(@Param("role") String role, @Param("idProfesor") Integer idProfesor);

    @Query("select p from Curso c join c.persons p join p.accounts a join a.roles r where r.name = :role and c.id = :idCurso order by p.lastname asc")
    List<Person> findPersonsFromCurso(@Param("role") String role, @Param("idCurso") Integer idCurso);

    @Query("select a from Curso c join c.asignaturas a where c.id = :idCurso order by a.orden asc")
    List<Asignatura> findAsignaturasFromCurso(@Param("idCurso") Integer idCurso);

    @Query("select c from Curso c where c.orden = :orden")
    Curso findCursoByOrden(@Param("orden") Integer orden);
}
