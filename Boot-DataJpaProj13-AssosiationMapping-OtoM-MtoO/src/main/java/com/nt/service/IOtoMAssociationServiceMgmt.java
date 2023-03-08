//IOtoMAssociationServiceMgmt.java
package com.nt.service;

public interface IOtoMAssociationServiceMgmt {
	
	public void saveDataUsingParent();
	public void saveDataUsingChild();
	public void loadDataUsingParent();
	
	public String deleteByPersonId(int personId);	
	public String deleteAllPhoneNumbersOfAPerson(int personId);
	
	public void addNewChildToAPersonById(int personId);

}//interface
