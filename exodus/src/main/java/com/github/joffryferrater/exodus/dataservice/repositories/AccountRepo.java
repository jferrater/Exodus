package com.github.joffryferrater.exodus.dataservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.github.joffryferrater.exodus.dataservice.entities.Account;

/**
 * 
 * @author Joffry Ferrater
 *
 */
public interface AccountRepo extends MongoRepository<Account, String>{

	@Query("{'name' : ?0}")
	public Iterable<Account> searchByUsername(String username);
	
	public Account findByUsername(String username);
}
