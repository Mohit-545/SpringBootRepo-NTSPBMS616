//ReportGenerator.java
package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	//@Scheduled(initialDelay = 3000, fixedDelay = 5000)
	//@Scheduled(fixedDelay = 5000)
	//@Scheduled(fixedRate = 3000)
	//@Scheduled(initialDelay = 2000 ,fixedRate = 5000)
	//@Scheduled(initialDelay = 2000 ,fixedRate = 5000)
	//@Scheduled(cron = "15 * * * * *")
	//@Scheduled(cron = "0 0 9 * * *")
	//@Scheduled(cron = "1 2 20 * * *")
	//@Scheduled(cron = "* * * * * *")
	//@Scheduled(cron = "0 2 8,10 * * *")
	//@Scheduled(cron = "10 20 9-14 * * *")
	//@Scheduled(cron = "0 0 16 * * *")
	//@Scheduled(cron = "1 2 5 6 * *")
	//@Scheduled(cron = "* 18 8 * * *")
	//@Scheduled(cron = "10 * 8 * * *")
	//@Scheduled(cron = "0/20 * * * * *")
	//@Scheduled(cron = "10 0/15 * * * *")
	//@Scheduled(cron = "30 10/5 * * * *")
	//@Scheduled(cron = "30 10/10 16 * * *")
	@Scheduled(cron = "0 0 10 * * SUN")
	public void generateSalesReport() {
		/*try {
			Thread.sleep(5000);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		*/		
		/*System.out.println("Thread Name :: "+Thread.currentThread().getName());
		System.out.println("Thread HashCode :: "+Thread.currentThread().hashCode());*/
		System.out.println("Report Generated on :: "+ new Date());
	}//method

	/*@Scheduled(initialDelay = 2000 ,fixedRate = 3000)
	public void generateSalesReport1() {
		System.out.println("Thread-1 Name :: "+Thread.currentThread().getName());
		System.out.println("Thread-1 HashCode :: "+Thread.currentThread().hashCode());
		System.out.println("Report-1 Generated on :: "+ new Date());
	}//method
	*/}//class