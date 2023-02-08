//PandSRepoTestRunner.java
package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PandSRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		//invoke the service class method
		/*service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println();
		service.showDoctorsBySorting(false, "income", "docName").forEach(System.out::println);;
		System.out.println();*/
		
		service.showDoctorsInfoByPageNo(1, 3, true, "docName").forEach(System.out::println);
		System.out.println();
		Page<Doctor> page = service.showDoctorsInfoByPageNo(0, 5, false, "income");
		System.out.println("Page Number :: "+page.getNumber());
		System.out.println("Page Count :: "+page.getTotalPages());
		System.out.println("Is it first Page :: "+page.isFirst());
		System.out.println("Is it last Page :: "+page.isLast());
		System.out.println("Page Size :: "+page.getSize());
		System.out.println("Page Elements Count :: "+page.getNumberOfElements());
		if(!page.isEmpty()) {
			List<Doctor> list = page.getContent();
			list.forEach(System.out::println);
		}//if
		else {
			System.out.println("Page Not Found !!!!!");
		}
		System.out.println();
	}

}//class
