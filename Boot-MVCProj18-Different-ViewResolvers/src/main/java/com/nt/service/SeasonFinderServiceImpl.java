//SeasonFinderServiceImpl.java
package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class SeasonFinderServiceImpl implements ISeasonFinderService {

	@Override
	public String findSeason() {
		// get system date 
		LocalDateTime ldt = LocalDateTime.now();
		//get current month
		int month = ldt.getMonthValue();
		// b.logic for finding season as per month value
		if(month>=3 && month<=6)
		return "CURRENT SEASON :: SUMMER SEASON";
		else if(month>=7 && month<=10){
			return "CURRENT SEASON :: RAINY SEASON";	
		}
		else return "CURRENT SEASON :: WINTER SEASON";
	}//method

}//class
