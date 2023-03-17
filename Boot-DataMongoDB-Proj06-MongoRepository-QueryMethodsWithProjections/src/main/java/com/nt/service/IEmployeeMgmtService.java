//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
	
	public List<Object[]> searchEmpDataByAddress(String addrs);
	
	public List<Employee> searchAllEmpsDataByAddress(String addrs);
	public List<Employee> showAllEmpsDataByAddressAndName(String addrs, String name);
	public List<Employee> showAllEmpsDataBySalaryRange(double startSalary, double endSalary);
	public List<Employee> showAllEmpsDataForSpecificAddresses(String addrs1, String addrs2);
	public List<Employee> showAllEmpsDataByEnameForSpecificChars(String chars);
	
	public int showAllEmpsCountBySalaryRange(double start, double end);
	public List<Employee> showAllEmpsByEnameSorted();
	public int deleteEmpsWithNoVaccination();
	public String showEmpsWithoutAddress();
	
	
	
}//interface
