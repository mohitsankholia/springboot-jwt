package com.mohit.spring_jwt.ExceptionController;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mohit.spring_jwt.exceptions.CustomExceptions;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = CustomExceptions.class)
	public ResponseEntity<Object> Exception(CustomExceptions exception) {
		return new ResponseEntity<>("department not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> Exception1(CustomExceptions exception) {
		return new ResponseEntity<>("Null value Present", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = PropertyValueException.class)
	public ResponseEntity<Object> Exception2(CustomExceptions exception) {
		return new ResponseEntity<>("field is empty", HttpStatus.BAD_REQUEST);
	}

}
