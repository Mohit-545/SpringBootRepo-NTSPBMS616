//MyWebMvcConfigurer.java
package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeCheckIntercepter;

@Component
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	
	public void addInterceptors(InterceptorRegistry register) {
		System.out.println("MyWebMvcConfigurer.addInterceptors()");
		register.addInterceptor(new TimeCheckIntercepter());
	}//method

}//class
