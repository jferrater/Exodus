package com.github.joffryferrater.exodus.controllers.inputvalidation;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A class that validates http request body.
 * 
 * @author Joffry Ferrater
 *
 */
public class InputValidation {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> errors = new ArrayList<String>();

	private final String errorMessage;
	
	public InputValidation(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void addErrorMessage(String error) {
		errors.add(error);
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
