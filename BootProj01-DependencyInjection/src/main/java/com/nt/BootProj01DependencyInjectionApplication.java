//BootProj01DependencyInjectionApplication.java (main class)
package com.nt;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	@Bean("ld")
	public LocalDate createDate() {
		return LocalDate.now();
	}
	public static void main(String[] args) {
		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//get the target spring bean class obj ref 
		SeasonFinder finder = ctx.getBean("sf", SeasonFinder.class);
		//invoke the b.method 
		String mesg = finder.findSeason();
		//display the message
		System.out.println("Current Season : "+mesg);
		//get all the spring bean id internally created by the IOC Container
		System.out.println("Spring Bean Count : "+ctx.getBeanDefinitionCount());
		String id[] = ctx.getBeanDefinitionNames();
		System.out.println("Spring Bean Id Name : "+Arrays.toString(id));
		//close the container
		((ConfigurableApplicationContext)ctx).close();
	}//main

}//class
