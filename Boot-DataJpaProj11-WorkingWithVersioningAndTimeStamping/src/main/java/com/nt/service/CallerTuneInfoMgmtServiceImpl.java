//CallerTuneInfoMgmtServiceImpl.java
package com.nt.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICallerTuneInfoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("callerTuneService")
public class CallerTuneInfoMgmtServiceImpl implements ICallerTuneInfoMgmtService {
	@Autowired
	private ICallerTuneInfoRepository tuneRepo;

	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		Integer id = tuneRepo.save(info).getTuneId();
		return "Caller Tune is saved with tune Id :: "+id;
	}//method

	@Override
	public String updateCallerTuneInfoById(Integer id, String tuneName, String movieName) {
		//get tune object from optional object
		Optional<CallerTuneInfo> opt = tuneRepo.findById(id);
		if(opt.isPresent()) {
			CallerTuneInfo info = opt.get();
			info.setTuneName(tuneName);
			info.setMovieName(movieName);
			CallerTuneInfo updatedInfo = tuneRepo.save(info);
			return "================Caller Tune Update Details =================\n"
					+ "New Caller Tune Name :: "+updatedInfo.getTuneName()+"\n"
					+"New Caller Tune Movie Name :: "+updatedInfo.getMovieName()+"\n"
					+"Caller Tune service opted on :: "+updatedInfo.getServiceOptedOn()+"\n"
					+"Caller Tune Last updated on :: "+updatedInfo.getLastlyUpdatedOn()+"\n"
					+"Total no. of times tune updated for :: "+updatedInfo.getUpdatedCount();
		}//if
		else {
			return "No Caller Tune found";
		}//else
	}//method

	@Override
	public CallerTuneInfo showCallerTuneInfoById(Integer id) {
		return tuneRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Caller Tune Service not found"));
	}//method

	

}//class
