//BootMvcProj16FileUploadingAndDownloadingApplication.java (main class)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingAndDownloadingApplication {
	
	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver createResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		return resolver;
	}//method

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingAndDownloadingApplication.class, args);
	}//main

}//class
