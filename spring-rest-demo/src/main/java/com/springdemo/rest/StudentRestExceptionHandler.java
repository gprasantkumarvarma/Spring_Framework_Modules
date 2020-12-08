package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@@Real time use of AOP (Global Exception handling)
@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add exception handling code here
	
	// add an exception handler using @ExceptionHandler

		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}

		// add another excption handler...to catch any type of excetpion

		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			// return ResponseEntity
			
		  return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}

}
