package com.core.cscj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.cscj.models.entities.Role;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.entities.Account;
import com.core.cscj.models.requests.AccountRequest;
import com.core.cscj.repos.AccountRepo;
import com.core.cscj.repos.RoleRepo;

@Service
public class AccountService {	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	public Account insert(AccountRequest accountRequest) {
		Role role = null;
		
		if(accountRequest.getRole() != null)
			role = roleRepo.findByName(accountRequest.getRole().getName());
		else role = roleRepo.findByName(Roles.ALUMNO.toString());
		
		Account account = new Account();
		account.setDocument(accountRequest.getDocument());
		account.setPassword(accountRequest.getPassword());
		account.setRole(role);
		
		return accountRepo.save(account);
	}
	
	public List<Account> findAll(){
		return accountRepo.findAll();
	}
	
	public Optional<Account> findById(Integer id) {
		return accountRepo.findById(id);
	}
	
	public Account modify(AccountRequest accountRequest){
		Role role = roleRepo.findByName(accountRequest.getRole().getName());
		
		Account account = new Account();
		account.setDocument(accountRequest.getDocument());
		account.setPassword(accountRequest.getPassword());
		account.setRole(role);
		
		return accountRepo.save(account);
	}
	
	public void deleteById(String document) {
		accountRepo.delete(accountRepo.findByDocument(document));
	}
}