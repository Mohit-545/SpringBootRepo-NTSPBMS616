//MVCConfigurer.java
package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Component
public class MVCConfigurer implements WebMvcConfigurer {
	
	/*@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		System.out.println("MVCConfigurer.configureViewResolvers()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(InternalResourceView.class); //or
		//resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}//method
	*/
}//class
