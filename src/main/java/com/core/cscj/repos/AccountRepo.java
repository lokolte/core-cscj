package com.core.cscj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.cscj.models.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{
	
	Account findByDocument(String document);

}
