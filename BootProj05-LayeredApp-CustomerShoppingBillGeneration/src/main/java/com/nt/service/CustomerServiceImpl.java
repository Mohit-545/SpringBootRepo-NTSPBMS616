//CustomerServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	//injecting DAO class obj
	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	public String registerCustomer(Customer cust) throws Exception {
		// calculate final bill amount of the customer (b.method)
		double finalBill = cust.getBillAmt()+(cust.getBillAmt()*0.16f);
		//set final bill amount to customer obj
		cust.setFinalBillAmt(finalBill);
		//use DAO to get final count
		int count = customerDAO.insertCustomerInfo(cust);
		//return the final result
		return count==0?"Customer's bill not Generated":"Customer's bill Generated with\n"
				+ "Gross bill = "+cust.getBillAmt()+"\nFinal Bill with GST = "+cust.getFinalBillAmt();
	}//method

}//class
