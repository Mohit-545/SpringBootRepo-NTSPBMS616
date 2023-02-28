//ICallerTuneInfoMgmtService.java
package com.nt.service;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneInfoMgmtService {
	
	public String saveCallerTuneInfo(CallerTuneInfo info);
	public String updateCallerTuneInfoById(Integer id, String tuneName, String movieName);
	public CallerTuneInfo showCallerTuneInfoById(Integer id);
	
}//interface
