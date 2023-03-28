//LinksServiceImpl.java
package com.nt.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LinksServiceImpl implements ILinksService {

	@Override
	public String generateWishMessage() {
		// get system date and time
		LocalDateTime dateTime = LocalDateTime.now();
		//get current hour of the day
		int hour = dateTime.getHour();
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else
		return "Good Night";
	}//method

	@Override
	public Set<String> fetchAllLanguages() {
		// get Locales 
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> langSet = new HashSet<String>();
		for(Locale l : locales ) {
			langSet.add(l.getDisplayLanguage());
		}//for
		return langSet;
	}//method

}//class
