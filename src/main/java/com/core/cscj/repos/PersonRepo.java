package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{
	Person findByDocument(String document);
}
