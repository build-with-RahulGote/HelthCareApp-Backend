package com.techhub.hms.Exception;

public class patientsNotFoundException extends RuntimeException {
	private String message;
	public patientsNotFoundException(String message)
	{
		super(message);
		this.message=message;
	}

}
