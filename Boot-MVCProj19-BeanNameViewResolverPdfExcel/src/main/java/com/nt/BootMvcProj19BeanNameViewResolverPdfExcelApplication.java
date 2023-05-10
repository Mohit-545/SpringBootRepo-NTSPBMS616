//BootMvcProj19BeanNameViewResolverPdfExcelApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class BootMvcProj19BeanNameViewResolverPdfExcelApplication {
	
	@Bean
	public BeanNameViewResolver createResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}//method

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj19BeanNameViewResolverPdfExcelApplication.class, args);
	}//main

}//class
