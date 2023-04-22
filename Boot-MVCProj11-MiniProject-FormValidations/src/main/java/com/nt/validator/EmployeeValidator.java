//EmployeeValidator.java
package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.entity.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// to check if correct model class is taken or not, if return true then only validate(-) method executes
		return clazz.isAssignableFrom(Employee.class);
	}//method

	@Override
	public void validate(Object target, Errors errors) {
		// type casting with model class
		Employee emp = (Employee) target;
		
		// placing server side validation logics and putting errors in error object
		if(emp.getEname()==null || emp.getEname().isBlank()) {
			errors.rejectValue("ename", "emp.name.required");
		}//if
		else if(emp.getEname().length() <=5 || emp.getEname().length() >=15) {
			errors.rejectValue("ename", "emp.name.length");
		}//else if
	
		if(emp.getJob()==null || emp.getJob().isBlank()) {
			errors.rejectValue("job", "emp.job.required");
		}//if
		else if(emp.getJob().length() <=5 || emp.getJob().length() >=15) {
			errors.rejectValue("job", "emp.job.length");
		}//else if

		if(!errors.hasFieldErrors("sal")) {
				if(emp.getSal()==null) {
					errors.rejectValue("sal", "emp.salary.required");
				}//if
				else if(emp.getSal()<10000 || emp.getSal()>200000) {
					errors.rejectValue("sal", "emp.salary.range");
				}//else if
		}//if
		if(emp.getDeptno()==null) {
			errors.rejectValue("deptno", "emp.deptno.required");
		}//if
		
	}//method

}//class
