//SportsRunnerTest.java
package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.Player;
import com.nt.document.Sports;
import com.nt.service.ISportsMgmtService;
@Component
public class SportsRunnerTest implements CommandLineRunner {
	@Autowired
	private ISportsMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		/*try{
			// saving parent object with childs details
			Sports sp1 = new Sports(new Random().nextInt(1000), "Cricket", new String[] {"Bat","Ball","Helmet","Pads"});
			Sports sp2 = new Sports(new Random().nextInt(500), "Tennis", new String[] {"Tennis Bat","Tennis Ball","Racket"});
			
			Medal md1 = new Medal(new Random().nextInt(100), "Man of the Series", "Cricket World Cup", "India");
			Medal md2 = new Medal(new Random().nextInt(50), "Man Of the Match", "Cricket T20 World Cup", "England");
			
			Player player = new Player(new Random().nextInt(10000), "Subhash", "Hyd", 
																																			Set.of(sp1, sp2),
																																			Map.of("Medal-1", md1, "Medal-2", md2));
			//register the player
			System.out.println(service.registerPlayerWithSportsAndMedals(player));
			System.out.println();
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		*/		
		
		
		//fetch all players info
		try {
			//invoke the method
			service.fetchAllPlayersInfo().forEach(player->{
				System.out.println("Parent Details :: "+player);
				//get child1 details 
				Set<Sports> child1 = player.getSports();
				child1.forEach(ch->{
					System.out.println("Child 1 :: "+ch);					
				});
				Map<String, Medal> child2 = player.getMedals();
				child2.forEach((type,medal)->{
					System.out.println("Child2 :: "+type+"......"+medal);
				});
			});
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
	}//run(-)

}//class
