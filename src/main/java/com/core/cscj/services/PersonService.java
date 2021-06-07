package com.core.cscj.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.cscj.models.entities.Account;
import com.core.cscj.models.entities.Person;
import com.core.cscj.models.requests.PersonRequest;
import com.core.cscj.repos.AccountRepo;
import com.core.cscj.repos.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private AccountRepo accountRepo;

	public Person insert(PersonRequest personRequest, String document) {
		Account account = accountRepo.findByDocument(document);

		Person person = new Person();
		person.setDocument(personRequest.getDocument());
		person.setName(personRequest.getName());
		person.setLastname(personRequest.getLastname());
		person.setPhone(personRequest.getPhone());
		person.setSex(personRequest.getSex());

		Person personResult = personRepo.save(person);

		account.setPerson(person);
		accountRepo.save(account);

		return personResult;
	}

	public List<Person> findAll() {
		return personRepo.findAll();
	}

	public Person findByDocument(String document) {
		return accountRepo.findByDocument(document).getPerson();
	}

	public Person findById(Integer idPerson){
		Optional<Person> person = personRepo.findById(idPerson);

		return person.orElseGet(Person::new);
	}

	public Person modify(Person person) {
		Account account = accountRepo.findByDocument(person.getDocument());

		Person personRecovered = personRepo.findByDocument(person.getDocument());

		personRecovered.setDocument(person.getDocument());
		personRecovered.setName(person.getName());
		personRecovered.setLastname(person.getLastname());
		personRecovered.setBirthDate(person.getBirthDate());
		personRecovered.setPhone(person.getPhone());
		personRecovered.setSex(person.getSex());
		personRecovered.setAddress(person.getAddress());

		Person personResult = personRepo.save(personRecovered);

		account.setPerson(personResult);
		accountRepo.save(account);

		return personResult;
	}

	public void delete(String document) {
		Account account = accountRepo.findByDocument(document);

		Person personToDelete = account.getPerson();

		account.setPerson(null);

		accountRepo.save(account);

		personToDelete.setAccounts(null);

		personRepo.save(personToDelete);

		personRepo.delete(personToDelete);
	}

	public Set<Person> getAllAlumnosFromCurso(Curso curso) {
		return curso.getPersons().stream().filter(
				person -> {
					Account account = person.getAccounts().stream().collect(Collectors.toList()).get(0);
					List<String> roles = account.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());
					return roles.contains(Roles.ALUMNO.name());
				}
		).collect(Collectors.toSet());
	}

}
