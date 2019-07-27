package com.hcl.trainingcenter.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.trainingcenter.dto.ResponseData;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	 	@Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        ResponseData error = new ResponseData("Validation Failed", status, details);
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
	 
	 	@ExceptionHandler(ResourceNotFoundException.class)
	    public final ResponseEntity<Object> handleAllExceptions(ResourceNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getMessage());
	        ResponseData error = new ResponseData(ex.getMessage(), HttpStatus.BAD_REQUEST, null);
	        return new ResponseEntity<>(error, error.getHttpStatus());
	    }
	
	 	@ExceptionHandler(BookMyFlightException.class)
	    public final ResponseEntity<Object> handleAllExceptions(BookMyFlightException ex, WebRequest request) {
	 		 List<String> details = new ArrayList<>();
		     details.add(ex.getMessage());
		     ResponseData error = new ResponseData(ex.getMessage(), HttpStatus.BAD_REQUEST, null);
		     return new ResponseEntity<>(error, error.getHttpStatus());
	    }
}
