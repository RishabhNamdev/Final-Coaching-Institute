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

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
		return new ResponseEntity<String>("Input field is empty", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleEmptyInput(CustomException e) {
		CustomExceptionResponse response  = new CustomExceptionResponse();
		response.setDate(e.getDate());
		response.setMessage(e.getMessage());
		response.setStatusCode(e.getStatusCode());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleEmptyInput(Exception exception) {
//		throw new CustomException(603, "Something went wrong", LocalDate.now());
		// return new ResponseEntity<String>("Input field is
		// empty",HttpStatus.BAD_REQUEST);
	
//	@ExceptionHandler(CustomException.class)
//	public ResponseEntity<String> handleEmptyInput1(CustomException e) {
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//	}
//	
	@ExceptionHandler
	public ResponseEntity<String> handleEmptyInput1(CustomException e) {
		return new ResponseEntity<String>("List is empty", HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleEmptyInput2(CustomException e) {
		return new ResponseEntity<String>("is not updated student", HttpStatus.BAD_REQUEST);
	
	}
	@ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleEmptyInput3(CustomException e) {
		return new ResponseEntity<String>("id not found", HttpStatus.INTERNAL_SERVER_ERROR);	
	
	}
}


