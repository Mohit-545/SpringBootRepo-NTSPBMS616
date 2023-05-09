package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SpringBootApplication
public class BootMvcProj18DifferentViewResolverApplication {
	
	/*@Bean
	public InternalResourceViewResolver createIRViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}//method
	*/
	
	@Bean
	public ResourceBundleViewResolver createRBVR() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		return resolver;
	}//method
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj18DifferentViewResolverApplication.class, args);
	}//main

}//class
