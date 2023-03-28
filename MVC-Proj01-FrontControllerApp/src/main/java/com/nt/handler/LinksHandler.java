//LinksHandler.java
package com.nt.handler;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.nt.service.ILinksService;
import com.nt.service.LinksServiceImpl;

public class LinksHandler {
	private ILinksService service;
	
	public LinksHandler() {
		service = new LinksServiceImpl();
	}//constructor
	
	//handler method1
	public String showWishMessage(HttpServletRequest req) {
		//use service to get result
		String resultMsg = service.generateWishMessage();
		//keep result in request scope
		req.setAttribute("wishMsg", resultMsg);
		//return Logica View Name (LVN) based on which physical jsp file name and location will be decided
		return "wish_result";
	}//method

	//handler method2 
	public String showAllLanguages(HttpServletRequest req) {
		Set<String> langSet = service.fetchAllLanguages();
		//keep in request scope
		req.setAttribute("langInfo", langSet);
		//return logical view name
		return "all_langs";
	}//method
	
}//class
