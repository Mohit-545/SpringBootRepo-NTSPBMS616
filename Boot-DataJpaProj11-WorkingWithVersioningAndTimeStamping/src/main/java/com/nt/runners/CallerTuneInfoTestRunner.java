//CallerTuneInfoTestRunner.java
package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTuneInfo;
import com.nt.service.ICallerTuneInfoMgmtService;



@Component
public class CallerTuneInfoTestRunner implements CommandLineRunner {
	@Autowired
	private ICallerTuneInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		// invoke the business method
		try {
			System.out.println();
			/*CallerTuneInfo info = new CallerTuneInfo("OO ANTAVA MAMA", "PUSHPA");
			System.out.println(service.saveCallerTuneInfo(info));*/

			System.out.println(service.updateCallerTuneInfoById(2, "JAI HO", "SLUMDOG MILLIONAIR"));
			System.out.println("===========================================================================");
			System.out.println(service.showCallerTuneInfoById(1));
			System.out.println();
			
		}//try 
		catch (Exception e) {
			e.printStackTrace();
		}//catch

	}//run(-)
}//class
