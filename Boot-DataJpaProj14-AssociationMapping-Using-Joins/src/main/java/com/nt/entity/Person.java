//Person.java
package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA-OTM-PERSON")
@RequiredArgsConstructor
@Setter
@Getter
public class Person {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	@NonNull
	private String pname;
	@Column(length = 20)
	@NonNull
	private String paddrs;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personInfo")
	//@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> contactDetails;

	//0-param constructor
	public Person() {
		System.out.println("Person::0-param constructor");
	}//constructor

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	
}//class
