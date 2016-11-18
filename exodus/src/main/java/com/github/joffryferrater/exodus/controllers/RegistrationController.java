package com.github.joffryferrater.exodus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.joffryferrater.exodus.dataservice.entities.Account;
import com.github.joffryferrater.exodus.dataservice.repositories.AccountRepo;

/**
 * 
 * @author Joffry Ferrater
 *
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	private final AccountRepo accountRepo;
	
	@Autowired
	public RegistrationController(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
		String id = java.util.UUID.randomUUID().toString();
		if(account != null) {
			accountRepo.save(new Account(id, account.getFullName()
					, account.getUsername(), account.getPassword()
					, account.getEmail()));
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
}
