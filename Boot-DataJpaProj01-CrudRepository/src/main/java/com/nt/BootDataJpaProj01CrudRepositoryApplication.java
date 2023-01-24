//BootDataJpaProj01CrudRepositoryApplication.java
package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgmtServiceImpl;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootDataJpaProj01CrudRepositoryApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj01CrudRepositoryApplication.class, args);
		//get Service class object
		IDoctorService service = ctx.getBean("doctorService",DoctorMgmtServiceImpl.class);
		//invoke the b.method for save(-) method
//		try {
//			Doctor doc = new Doctor();
//			doc.setDocName("Alok Nath"); doc.setSpecialization("MD-Orthopedics"); doc.setIncome(450000.0);
//			String msgRes = service.registerDoctor(doc);
//			System.out.println(msgRes);
//		}//try
		//invoke the b.method for saveAll(-) method
		try {
			Doctor doc1 = new Doctor();
				doc1.setDocName("Pramod Mishra"); doc1.setSpecialization("Physician"); doc1.setIncome(145000.0);
			Doctor doc2 = new Doctor();
				doc2.setDocName("Kayum Khan"); doc2.setSpecialization("Gynecology"); doc2.setIncome(345000.0);
			Doctor doc3 = new Doctor();
				doc3.setDocName("Ashish Kumar"); doc3.setSpecialization("Radiology"); doc3.setIncome(560000.0);
			
			String resMesg = service.registerGroupOfDoctors(List.of(doc1, doc2, doc3));
			System.out.println(resMesg);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
		//close the Container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class
