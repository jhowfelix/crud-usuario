package br.com.fiap.controller.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<StandardError> badRequest(InvalidFormatException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);

    }

}
