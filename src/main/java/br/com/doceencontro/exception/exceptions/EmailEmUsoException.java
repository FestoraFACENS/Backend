package br.com.doceencontro.exception.exceptions;

public class EmailEmUsoException extends ConflictException {
	private static final long serialVersionUID = 1L;

	public EmailEmUsoException() {
		super("Email em uso.");
	}

}
