package com.github.joffryferrater.exodus.dataservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Joffry Ferrater
 *
 */
@Document(collection="account")
public class Account {

	@Id
	private String id;
	private String fullName;
	private String username;
	private String password;
	private String email;
	
	public Account() {
		
	}
	
	@PersistenceConstructor
	public Account(String id, String fullName, String username, String password, String email) {
		super();
		this.id = id;
		this.setFullName(fullName);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
