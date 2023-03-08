//OtoMAssociatonServiceMgmtImpl.java
package com.nt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("OtoMService")
public class OtoMAssociatonServiceMgmtImpl implements IOtoMAssociationServiceMgmt {
	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phRepo;
	
	@Override
	public List<Object[]> fetchDataByJoinsUsingParent() {
		return personRepo.fetchDataUsingJoinsByParent();
	}//method

}//class
