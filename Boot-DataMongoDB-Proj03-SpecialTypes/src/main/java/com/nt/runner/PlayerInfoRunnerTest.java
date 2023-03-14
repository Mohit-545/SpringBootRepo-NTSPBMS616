//PlayerInfoRunnerTest.java
package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PlayerInfo;
import com.nt.service.IPlayerInfoMgmtService;

@Component
public class PlayerInfoRunnerTest implements CommandLineRunner {
	@Autowired
	private IPlayerInfoMgmtService playerService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		/*PlayerInfo pInfo = new PlayerInfo();
		pInfo.setPid(new Random().nextInt(10000));
		pInfo.setPname("Ajay");
		pInfo.setNickNames(new String[]{"Ajju","Golu"});
		pInfo.setFriends(List.of("Manu", "Sankar"));
		pInfo.setPhoneNumbers(Set.of(9988556699L, 7788656654L));
		pInfo.setIdDetails(Map.of("Pan Card", 484648L, "Adhaar Card", 4589658445877854L));
		Properties props = new Properties();
		props.put("Cricket Bat", "Kookaburra"); props.put("Cricket Ball", "English Willow");
		pInfo.setKitInfo(props);
		//invoke the method
		System.out.println(playerService.registerPlayer(pInfo));*/
		
		playerService.showAllPlayers().forEach(System.out::println);
	}//run(-)

}//class
