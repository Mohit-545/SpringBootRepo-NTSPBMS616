//OtoMAssociatonServiceMgmtImpl.java
package com.nt.service;

import java.util.HashSet;
import java.util.Set;

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
	public void saveDataUsingParent() {
		// create parent object
		Person per = new Person("Akash", "Hyd");
		//create child objects
		PhoneNumber ph1 = new PhoneNumber(9998885555L, "Airtel", "Prepaid");
		PhoneNumber ph2 = new PhoneNumber(8888666333L, "Jio", "Prepaid");
		
		//add parent to child class object
		ph1.setPersonInfo(per);  ph2.setPersonInfo(per);
		
		//add child to parent class object
		Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>();
		phoneSet.add(ph1); phoneSet.add(ph2);
		per.setContactDetails(phoneSet);
		
		//save parent object
		personRepo.save(per);
		System.out.println("Person and his associated phone numbers are saved (Parent to Child)");
	}//method

	@Override
	public void saveDataUsingChild() {
				// create parent object
				Person per = new Person("Ramesh", "Mumbai");
				//create child objects
				PhoneNumber ph1 = new PhoneNumber(9988665578L, "Idea", "Postpaid");
				PhoneNumber ph2 = new PhoneNumber(8877665544L, "Jio", "Postpaid");
				
				//add parent to child class object
				ph1.setPersonInfo(per);  ph2.setPersonInfo(per);
				
				//add child to parent class object
				Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>();
				phoneSet.add(ph1); phoneSet.add(ph2);
				per.setContactDetails(phoneSet);
				
				//save child object
				phRepo.save(ph1); phRepo.save(ph2);
				System.out.println("Person and his associated phone numbers are saved (Child to Parent )");

	}//method

	@Override
	public void loadDataUsingParent() {
		// get parent class object
		Iterable<Person> it = personRepo.findAll();
		it.forEach(per->{
			System.out.println("Parent :: "+per);
				//get child objects of each parent
 				Set<PhoneNumber> child = per.getContactDetails();
 				child.forEach(ph->{
 					System.out.println("Child :: "+ph.getMobileNo());
 				});//child
		});//parent

	}//method

}//class
