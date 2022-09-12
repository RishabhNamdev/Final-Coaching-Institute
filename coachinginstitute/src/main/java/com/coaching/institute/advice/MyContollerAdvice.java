package com.coaching.institute.advice;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.coaching.institute.exception.CustomException;
import com.coaching.institute.exception.EmptyInputException;
import com.coaching.institute.responsedto.CustomExceptionResponse;

@RestControllerAdvice
public class MyContollerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleEmptyInput(Exception e) {
		return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleEmptyInput(CustomException e) {
		CustomExceptionResponse response  = new CustomExceptionResponse();
		response.setDate(e.getDate());
		response.setMessage(e.getMessage());
		response.setStatusCode(e.getStatusCode());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}


