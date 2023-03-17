//MongoTemplateTestRunner.java
package com.nt.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StokeDetails;
import com.nt.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	@Autowired
	private IStockMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		try {
			System.out.println(service.registerStockDetails(new StokeDetails(new Random().nextInt(10000), "L&T", 2150.0, "NSE")));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
		
		
		
	}// run(-)

}// class
