package com.github.joffryferrater.exodus.controllers.inputvalidation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * Build the error message into json
 * 
 * @author Joffry Ferrater
 *
 */
public class InputErrorBuilder {

	/**
	 * {
  		"errorMessage": "Validation failed. 1 error(s)",
  		"errors": [
    			"User name must not be blank!"
  				]
		}
	 * @param errors
	 * @return
	 */
    public static InputValidation fromBindingErrors(Errors errors) {
    	InputValidation error = new InputValidation("Validation failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addErrorMessage(objectError.getDefaultMessage());
        }
        return error;
    }
}
