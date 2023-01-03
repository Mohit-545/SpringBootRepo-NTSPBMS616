//EmployeeDAOImpl.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
@Repository("empDAO-oracle")
public class OracleEmployeeDAOImpl implements IEmployeeDAO {
	//String Query
	private static final String Insert_Employee_Query = "INSERT INTO EMPLOYEE_INFO VALUES (ENO1_ID.NEXTVAL,?,?,?,?,?)";
	
	//injecting DataSource obj ref
	@Autowired
	private DataSource ds;
	
	@Override
	public int insertEmployee(Employee emp) throws Exception {
		System.out.println("Injected DataSource Object Class Name :: "+ds.getClass().getName());
		int count = 0;
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(Insert_Employee_Query)){
			//add values to query param
			if(ps!=null) {
				ps.setString(1,emp.getEName());
				ps.setString(2, emp.getEAdd());
				ps.setDouble(3, emp.getBasicSalary());
				ps.setDouble(4, emp.getGrossSalary());
				ps.setDouble(5, emp.getNetSalary());
			}
			//execute the query
			count = ps.executeUpdate();
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return count;
	}//method

}//class
