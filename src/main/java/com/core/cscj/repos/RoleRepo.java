package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
