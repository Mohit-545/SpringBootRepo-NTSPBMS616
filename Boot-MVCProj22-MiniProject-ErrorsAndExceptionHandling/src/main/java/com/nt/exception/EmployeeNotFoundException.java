//EmployeeNotFoundException.java
package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)	//for 502 error
public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException() {
		
	}//constructor1
	
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}//constructor2

}//class
