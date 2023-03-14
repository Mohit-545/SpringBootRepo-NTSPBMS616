//PlayerInfoMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.document.PlayerInfo;
import com.nt.repository.IPlayerInfoRepository;

@Component("playerService")
public class PlayerInfoMgmtServiceImpl implements IPlayerInfoMgmtService {
	@Autowired
	private IPlayerInfoRepository playerRepo;

	@Override
	public String registerPlayer(PlayerInfo info) {
		 
		 return "Player is Saved with player id :: "+playerRepo.save(info).getPid();
	}//method

	@Override
	public List<PlayerInfo> showAllPlayers() {
		return playerRepo.findAll();
	}//method

}//class
