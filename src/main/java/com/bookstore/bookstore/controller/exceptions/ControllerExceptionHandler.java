package com.bookstore.bookstore.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookstore.bookstore.service.exceptions.DataIntegrityViolationException;
import com.bookstore.bookstore.service.exceptions.ObjectNotFound;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFound e, ServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<StandardError>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<StandardError>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, ServletRequest request) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");
        
        for(FieldError x: e.getBindingResult().getFieldErrors()) {
            error.addErrors(x.getField(), x.getDefaultMessage());
        }

        return new ResponseEntity<StandardError>(error, HttpStatus.BAD_REQUEST);
    }

}
