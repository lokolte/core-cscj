package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.Planificacion;

public interface PlanificacionRepo extends JpaRepository<Planificacion, Integer>{
}
