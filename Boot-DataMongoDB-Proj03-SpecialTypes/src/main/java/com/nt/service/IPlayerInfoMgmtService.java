//IPlayerInfoMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.document.PlayerInfo;

public interface IPlayerInfoMgmtService {
	
	public String registerPlayer(PlayerInfo info);
	public List<PlayerInfo> showAllPlayers();

}//interface
