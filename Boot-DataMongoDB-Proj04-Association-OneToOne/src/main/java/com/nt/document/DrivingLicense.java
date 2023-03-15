//DrivingLicense.java  (Child class)
package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class DrivingLicense {
	@Id
	@NonNull
	private Integer licenseNo;
	@NonNull
	private String type;
	@NonNull
	private LocalDate expiryTime;
	// for one to one HAS-A relation
	private Person personDetails;
	
	
	@Override
	public String toString() {
		return "DrivingLicense [licenseNo=" + licenseNo + ", type=" + type + ", expiryTime=" + expiryTime + "]";
	}//toString()

}//class
