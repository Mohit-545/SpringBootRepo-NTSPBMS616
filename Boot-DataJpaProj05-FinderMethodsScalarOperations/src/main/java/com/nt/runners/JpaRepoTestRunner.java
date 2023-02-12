//JpaRepoTestRunner.java
package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;
import com.nt.view.IResultView1;
import com.nt.view.IResultView2;


@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*		Iterable<IResultView1> it = repo.findBySpecializationIn(List.of("Cardio", "Ortho"));
				it.forEach(doc->{
					System.out.println(doc.getDocName()+"     "+doc.getIncome());
				});*/
		
		
		Iterable<IResultView1> it1 = repo.findByIncomeBetween(50000.0, 200000.0, IResultView1.class);
		it1.forEach(data->{
			System.out.println(data.getDocName()+"   "+data.getIncome());
		});
		
		Iterable<IResultView2> it2 = repo.findByIncomeBetween(1000000.0, 3000000.0, IResultView2.class);
		it2.forEach(data->{
			System.out.println(data.getDocName()+"   "+data.getSpecialization()+"   "+data.getIncome());
		});
		
		}//run()

}//class
