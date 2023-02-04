//ApplicationRunnersTest.java
package com.nt.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnersTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("ApplicationRunnersTest.run()");
		System.out.println("Non-Option arg values are :- "+args.getNonOptionArgs());
		
		System.out.println("Option args names and values are :-");
		for(String names:args.getOptionNames()) {
			System.out.println(names+" ---> "+args.getOptionValues(names));
		}//for 
		System.out.println();
	}//method

}//class
