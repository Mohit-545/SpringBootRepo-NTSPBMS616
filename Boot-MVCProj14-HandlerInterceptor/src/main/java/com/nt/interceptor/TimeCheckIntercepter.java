//TimeCheckInterceptor.java
package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckIntercepter implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		System.out.println("TimeCheckIntercepter.preHandle()");
		// check for home page logic
		if(req.getServletPath().equalsIgnoreCase("/")) {
			System.out.println("if-executed(1)");
			return true;
		}//if
			//get System date and time	
			LocalDateTime ldt = LocalDateTime.now();
			int hour = ldt.getHour();
				if(hour>=9 && hour<=17) {
					System.out.println("if-executed(2)");
					return true;
				}//if
				else {
					RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
					rd.forward(req, res);
					System.out.println("else-executed");
					return false;
				}//else
	}//method

}//class
