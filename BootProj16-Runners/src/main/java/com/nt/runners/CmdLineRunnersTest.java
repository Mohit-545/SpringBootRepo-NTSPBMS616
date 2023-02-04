//CmdLineRunnersTest.java
package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineRunnersTest implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CmdLineRunnersTest.run()");
		System.out.println("Testing of Runner :- "+Arrays.toString(args));

	}// method

}//class
