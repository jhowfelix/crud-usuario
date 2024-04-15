package br.com.fiap.controller.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.fiap.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<StandardError> badRequest(InvalidFormatException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> badRequest(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<StandardError> badRequest(EmptyResultDataAccessException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);

    }

    

}
