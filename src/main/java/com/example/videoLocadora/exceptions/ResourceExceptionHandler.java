package com.example.videoLocadora.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<ErroPadrao>
	atorNaoEncontradoHandle(NaoEncontradoException e, HttpServletRequest req){
	ErroPadrao err = new ErroPadrao();
	err.setError("Resource not found");
	err.setMessage(e.getMessage());
	err.setPath(req.getRequestURI());
	err.setStatus(HttpStatus.NOT_FOUND.value());
	err.setTimestamp(Instant.now());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
