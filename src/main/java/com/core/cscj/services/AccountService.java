package com.core.cscj.services;

import java.io.IOException;
import java.util.*;

import com.core.cscj.controllers.AsignaturaController;
import com.core.cscj.models.entities.Curso;
import com.core.cscj.models.entities.Person;
import com.core.cscj.repos.CursoRepo;
import com.core.cscj.repos.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import com.core.cscj.models.entities.Role;
import com.core.cscj.models.enums.Roles;
import com.core.cscj.models.entities.Account;
import com.core.cscj.models.requests.AccountRequest;
import com.core.cscj.repos.AccountRepo;
import com.core.cscj.repos.RoleRepo;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private CursoRepo cursoRepo;

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

	public void loadData(MultipartFile file) throws IOException, InvalidFormatException {
		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Row> rowIterator = sheet.rowIterator();
		int rowNumber = 0;

		String document = null;
		String name = null;
		String lastname = null;
		Integer cursoOrden = null;

		// iterate rows
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (rowNumber == 0) {
				rowNumber++;
			} else {
				Iterator<Cell> cellIterator = row.cellIterator();
				int col = 0;
				// iterate columns
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);
					logger.info("############################# cellValue " + cellValue + "   " + col);
					if (col == 0) document = cellValue;
					else if (col == 1) name = cellValue;
					else if (col == 2) lastname = cellValue;
					else if (col == 3) cursoOrden = Integer.valueOf(cellValue);
					col++;
				}

				Person person = personRepo.findByDocument(document);

				if (person == null) person = new Person();

				Curso curso = cursoRepo.findCursoByOrden(cursoOrden);

				person.setDocument(document);
				person.setName(name);
				person.setLastname(lastname);
				person = personRepo.save(person);

				if(person.getCursos() == null) person.setCursos(new HashSet<Curso>());
				person.getCursos().add(curso);

				person = personRepo.save(person);

				if(curso.getPersons() == null) curso.setPersons(new HashSet<Person>());

				curso.getPersons().add(person);
				cursoRepo.save(curso);

				Account account = accountRepo.findByDocument(document);

				if (account != null) {
					if (person.getAccounts() != null && person.getAccounts().size() > 0) {
						List<Account> accounts = new ArrayList<>(person.getAccounts());
						account = accounts.get(0);
					}
				}else account = new Account();

				Role role = roleRepo.findByName(Roles.ALUMNO.name());
				account.setDocument(document);
				account.setPassword(document);
				account.setPerson(person);
				accountRepo.save(account);

				if(account.getRoles() == null) account.setRoles(new HashSet<Role>());
				account.getRoles().add(role);
				accountRepo.save(account);

				if(role.getAccounts() == null) role.setAccounts(new HashSet<Account>());
				role.getAccounts().add(account);
				roleRepo.save(role);

				logger.info("Usuario cargado con nombre: " + name + ", apellido: " + lastname + ", documento: " + document + ", Curso: " + curso.getNombre());
			}
		}
	}
}