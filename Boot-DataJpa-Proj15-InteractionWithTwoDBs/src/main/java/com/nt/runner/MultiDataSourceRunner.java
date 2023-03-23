//MultiDataSourceRunner.java
package com.nt.runner;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promos.Offers;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promos.IOfferRepo;

@Component  
public class MultiDataSourceRunner implements CommandLineRunner {
	@Autowired
	private IProductRepo prodRepo;
	@Autowired
	private IOfferRepo offerRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		//save objects
		/*prodRepo.saveAll(List.of(new Product("Derma Salicylic Acid Serum", 10.0, 599.0), new Product("Derma 20% Vitamin C Face Serum", 15.0, 699.0)));
		System.out.println("Products are saved");
		
		offerRepo.saveAll(List.of(new Offers("BUY 1 GET 1 FREE", "B1G1", 50.0,  LocalDateTime.of(2023, 03, 10, 23, 59)),
														new Offers("HOLI DISCOUNT", "TDC25", 20.0, LocalDateTime.of(2023, 03, 15, 20, 59))));
		System.out.println("Offers are saved");
		System.out.println();*/
		
		//retrieve object
		prodRepo.findAll().forEach(System.out::println);
		System.out.println("=============================================");
		offerRepo.findAll().forEach(System.out::println);
		System.out.println();
	}//run(-)

}//class
