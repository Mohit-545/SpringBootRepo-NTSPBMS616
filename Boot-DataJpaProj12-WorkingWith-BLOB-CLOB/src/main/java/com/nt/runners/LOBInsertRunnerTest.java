//LOBInsertRunnerTest.java
package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMarriageSeekerServiceMgmt;

@Component
public class LOBInsertRunnerTest implements CommandLineRunner {
	@Autowired
	private IMarriageSeekerServiceMgmt msService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
				// get data from end-user
				Scanner sc = new Scanner(System.in);
				/*	System.out.print("Enter Seeker Name :: ");
				String name = sc.nextLine();
				
				System.out.print("Enter Seeker Address :: ");
				String addrs = sc.next();
				
				System.out.print("Enter Seeker D.O.B(YYYY-MM-DDThh:mm:ss) :: ");
				String sdob = sc.next(); 
				//converting string date to java.time.LocalDate value
				LocalDateTime dob = LocalDateTime.parse(sdob);
				
				System.out.print("Is Seeker Indian? :: ");
				boolean isIndian = sc.nextBoolean();
				
				System.out.print("Enter Seeker photo path :: ");
				sc.nextLine();
				String photoPath = sc.next();
				
				System.out.print("Enter Seeker biodata path :: ");
				String biodataPath = sc.next();
				
				//prepare byte[] representing photo file content
				InputStream is = new FileInputStream(photoPath);
				byte[] photoData = new byte[is.available()];
				photoData = is.readAllBytes();
				
				//prepare char[] representing biodata content
				File file = new File(biodataPath);
				Reader reader = new FileReader(file);
				char[] biodataContent = new char[(int) file.length()];
				reader.read(biodataContent);
				
				//prepare Seeker object
				MarriageSeeker seeker = new MarriageSeeker(name, addrs, dob, photoData, biodataContent, isIndian);
				System.out.println(msService.registerMarriageSeeker(seeker));
				System.out.println();*/
		System.out.println("=======================================================================================================");
		try {
			System.out.print("Enter Seeker id :: ");
			MarriageSeeker seeker = msService.searchMarriageSeekerById(sc.nextInt());
			if(seeker!=null) {
				System.out.println(seeker.getMsId()+"\n"+seeker.getMsName()+"\n"+seeker.getMsAddrs()+"\n"+seeker.getDob());
				//read byte[] from seeker object and write into destination file
				OutputStream os = new FileOutputStream("retrieve_msPhoto.jpg");
				os.write(seeker.getMsPhoto());
				os.flush();
				Writer writer = new FileWriter("retrieve_msBioData.txt");
				writer.write(seeker.getMsBiodata());
				writer.flush();
				writer.close();
				os.close();
				System.out.println("LOB's are successfully retrieved");
			}//if
			else {
				System.out.println("LOB's are not retrieved");
			}//else
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//run(-)

}//class
