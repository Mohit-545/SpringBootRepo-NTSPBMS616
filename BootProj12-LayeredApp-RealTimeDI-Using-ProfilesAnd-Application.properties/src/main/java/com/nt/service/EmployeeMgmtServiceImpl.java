//EmployeeMgmtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl::0-param Constructor");
	}
	
@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public String registerEmployee(Employee emp) throws Exception {
		
		//calculate the gross Salary and net Salary (b.logic of the project)
				double grossSalary = emp.getBasicSalary()+(emp.getBasicSalary()*0.4f);
				double netSalary = grossSalary-(grossSalary*0.2f);
				
		//add both gross and net Salary to Employee class Object
				emp.setGrossSalary(grossSalary);
				emp.setNetSalary(netSalary);
				
		//use DAO to get the count result
				int count = empDAO.insertEmployee(emp);
	
		//return the final result - here using Ternary Operator to return the result
				return count==0?"Employee is not Registered":"Employee is Registered with :-\n"
						+"Basic Salary = "+emp.getBasicSalary()+"\nGross Salary = "+grossSalary+"\nNet Salary = "+netSalary;
	}//method

}//class
