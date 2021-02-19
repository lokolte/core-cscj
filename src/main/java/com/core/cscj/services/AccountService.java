package com.core.cscj.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

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
		if(accountRepo.findByDocument(accountRequest.getDocument()) != null) return null;

		Set<Role> roles = new HashSet();

		if(accountRequest.getRoles() != null)
			accountRequest.getRoles().forEach(role -> roles.add(roleRepo.findByName(role.getName())));
		else roles.add(roleRepo.findByName(Roles.ALUMNO.name()));

		Account account = new Account();
		account.setDocument(accountRequest.getDocument());
		account.setPassword(accountRequest.getPassword());
		account.setRoles(roles);

		return accountRepo.save(account);
	}

	public List<Account> findAll(){
		return accountRepo.findAll();
	}

	public Optional<Account> findById(Integer id) {
		return accountRepo.findById(id);
	}

	public Account modify(AccountRequest accountRequest){
		Set<Role> roles = new HashSet();

		if(accountRequest.getRoles() != null)
			accountRequest.getRoles().forEach(role -> roles.add(roleRepo.findByName(role.getName())));

		Account account = accountRepo.findByDocument(accountRequest.getDocument());
		account.setDocument(accountRequest.getDocument());
		account.setPassword(accountRequest.getPassword());
		account.setRoles(roles);

		return accountRepo.save(account);
	}

	public void deleteById(String document) {
		accountRepo.delete(accountRepo.findByDocument(document));
	}
}