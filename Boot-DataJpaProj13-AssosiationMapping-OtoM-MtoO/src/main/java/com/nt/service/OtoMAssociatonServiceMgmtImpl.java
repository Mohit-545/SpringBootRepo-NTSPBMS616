//OtoMAssociatonServiceMgmtImpl.java
package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
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

	@Override
	public String deleteByPersonId(int personId) {
		Optional<Person> opt = personRepo.findById(personId);
		if(opt.isPresent()) {
			personRepo.delete(opt.get());
			return "Person and his PhoneNumbers are deleted";
		}//if
		return "Person Details not found";
	}//method

	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		//Load parent object
		Optional<Person> opt = personRepo.findById(personId);
		if(opt.isPresent()) {
			//loading all childs of the parent
			Set<PhoneNumber> childs = opt.get().getContactDetails();
			childs.forEach(ph->{
				ph.setPersonInfo(null);
			});
			phRepo.deleteAll(childs);
			return childs.size()+" PhoneNumbers of "+personId+" Person are deleted";
		}//if
		return "Person id not found";
	}//method

	@Override
	public void addNewChildToAPersonById(int personId) {
		//load parent object
		Optional<Person> opt = personRepo.findById(personId);
		if(opt.isPresent()) {
			Person per = opt.get();
			//load all childs of parent
			Set<PhoneNumber> childs = per.getContactDetails();
			//create new child object
			PhoneNumber ph = new PhoneNumber(5554449856L, "VI", "Personal");
			//link to parent object
			ph.setPersonInfo(per);
			//add to childs object
			childs.add(ph);
			//save child object
			phRepo.save(ph);
			System.out.println("New child is added to existing childs of parent");
		}//if
		else {
			System.out.println(personId+" Person not found");
		}//else
		
	}//method

}//class
