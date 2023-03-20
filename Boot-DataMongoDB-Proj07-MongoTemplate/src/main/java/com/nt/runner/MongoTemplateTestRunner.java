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
		/*try {
			System.out.println(service.registerStockDetails(new StokeDetails(new Random().nextInt(10000), "L&T", 2150.0, "NSE")));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch*/		
		
		/*try {
			StokeDetails sd1 = new StokeDetails(new Random().nextInt(1500), "Olectra", 700.0, "NSE");
			StokeDetails sd2 = new StokeDetails(new Random().nextInt(3500), "ICICI", 3000.0, "BSE");
			StokeDetails sd3 = new StokeDetails(new Random().nextInt(10000), "INFY", 1650.0, "NSE");
			System.out.println(service.registerStockDetailsByBatch(List.of(sd1, sd2, sd3)));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch*/		
		
		/*try {
			service.fetchStockDetailsByPriceRange(500.0, 2500.0).forEach(System.out::println);
			System.out.println("================================================================");
			service.fetchStockDetailsByExchange("BSE").forEach(System.out::println);
			System.out.println("================================================================");
			System.out.println(service.fetchStockDetailsByStockId(714));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch*/		
		
		/*try {
			System.out.println(service.fetchAndUpdateStockDetailsByStockId(3859, 1800.0, "BSE"));
			System.out.println("================================================================");
			System.out.println(service.modifyExchangeByStockPriceRange(2500.0, 3500.0, "DSE"));
			System.out.println("================================================================");
			System.out.println(service.registerOrUpdateStockByStockName("Graphite India", 410.0, "NSE"));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch*/
		
		try {
			System.out.println(service.removeStocksByPriceRange(2500.0, 3500.0));
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
		
	}// run(-)

}// class
