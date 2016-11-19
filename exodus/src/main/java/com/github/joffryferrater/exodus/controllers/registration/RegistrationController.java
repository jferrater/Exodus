package com.github.joffryferrater.exodus.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.joffryferrater.exodus.dataservice.entities.Account;
import com.github.joffryferrater.exodus.dataservice.repositories.AccountRepo;

/**
 * Account registration endpoint.
 * 
 * @author Joffry Ferrater
 *
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
//	private final AccountRepo accountRepo;
//	
//	@Autowired
//	public RegistrationController(AccountRepo accountRepo) {
//		this.accountRepo = accountRepo;
//	}

	@RequestMapping(method = RequestMethod.POST, 
			        consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Account registerAccount(@RequestBody Account request) {
		Account account = request;
//		String id = java.util.UUID.randomUUID().toString();
//		if(request != null) {
//			accountRepo.save(new Account(id, account.getFullName()
//					, account.getUsername(), account.getPassword()
//					, account.getEmail()));
//		}
		return account;
	}
}
