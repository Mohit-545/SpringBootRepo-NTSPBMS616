//BootDataJpaProj01CrudRepositoryApplication.java
package com.nt;

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
		//invoke the b.method
		try {
			Doctor doc = new Doctor();
			doc.setDocName("Alok Nath"); doc.setSpecialization("MD-Orthopedics"); doc.setIncome(450000.0);
			String msgRes = service.registerDoctor(doc);
			System.out.println(msgRes);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
		//close the Container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class
