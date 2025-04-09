package com.example.festora.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EventoNotFoundException() {
		super("O evento não foi encontrado.");
	}

}
