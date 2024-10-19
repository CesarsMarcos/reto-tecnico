package com.reto.tecnico.exception;

public class ErrorNotFoundException extends RuntimeException {
	
	public ErrorNotFoundException(String id) {
		super("Post:" + id + " is not found.");
	}
}
