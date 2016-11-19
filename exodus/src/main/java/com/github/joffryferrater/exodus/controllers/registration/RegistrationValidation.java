package com.github.joffryferrater.exodus.controllers.registration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.joffryferrater.exodus.controllers.inputvalidation.InputErrorBuilder;
import com.github.joffryferrater.exodus.controllers.inputvalidation.InputValidation;

/**
 * Validates http request body of /registration endpoint.
 * 
 * @author Joffry Ferrater
 *
 */
@ControllerAdvice(assignableTypes = RegistrationController.class)
public class RegistrationValidation extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid (
    				MethodArgumentNotValidException exception,
    				HttpHeaders headers, 
    				HttpStatus status, 
    				WebRequest request) {
    	InputValidation error = InputErrorBuilder.fromBindingErrors(exception.getBindingResult());
        return super.handleExceptionInternal(exception, error, headers, status, request);
    }
}
