//BootMvcProj21TilesFrameworkApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@SpringBootApplication
public class BootMvcProj21TilesFrameworkApplication {
	
	@Bean
	public TilesConfigurer createTileConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");		
		return configurer;
	}//method
	
	@Bean
	public TilesViewResolver createResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		return resolver;
	}//method

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj21TilesFrameworkApplication.class, args);
	}//main

}//class
