//BootDataJpaProj01CrudRepositoryApplication.java
package com.nt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgmtServiceImpl;

@SpringBootApplication
public class BootDataJpaProj02PandSRepositoryApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj02PandSRepositoryApplication.class, args);
		
		
	}//main

}//class
