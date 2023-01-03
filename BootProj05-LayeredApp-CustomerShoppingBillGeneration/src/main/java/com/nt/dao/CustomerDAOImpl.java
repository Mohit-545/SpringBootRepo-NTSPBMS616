//CustomerDAOImpl.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;
@Repository
public class CustomerDAOImpl implements ICustomerDAO {
	//jdbc query declaration
	private static final String Customer_Info_Query = "INSERT INTO CUSTOMER_INFO VALUES (PID_SEQ.NEXTVAL,?,?,?,?,?)";
	
	//injecting dataSource obj 
	@Autowired
	private DataSource ds;

	@Override
	public int insertCustomerInfo(Customer cust) throws Exception {
		System.out.println("Injected DataSource Class Object Name :: "+ds.getClass().getName());
		int count = 0;
		// jdbc code for registering patient's info
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(Customer_Info_Query)){
			//set values to query params
			if(ps!=null)
				ps.setString(1, cust.getCName());
				ps.setString(2, cust.getCAdd());
				ps.setDouble(3, cust.getMobileNo());
				ps.setDouble(4, cust.getBillAmt());
				ps.setDouble(5, cust.getFinalBillAmt());
				
				//execute the query
				count = ps.executeUpdate();
		}//try
		catch (SQLException se) {
			// Exception re-throwing
			throw se;
		}
		catch (Exception e) {
			// Exception re-throwing
			throw e;
		}
		return count;
	}//method

}//class
