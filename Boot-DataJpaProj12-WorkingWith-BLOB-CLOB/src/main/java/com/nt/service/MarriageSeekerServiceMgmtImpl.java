//MarriageSeekerServiceMgmtImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageSeekerRepository;

@Service("msService")
public class MarriageSeekerServiceMgmtImpl implements IMarriageSeekerServiceMgmt {
	@Autowired
	private IMarriageSeekerRepository msRepo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage Seeker is registered with id :: "+msRepo.save(seeker).getMsId();
	}//method

	@Override
	public MarriageSeeker searchMarriageSeekerById(Integer id) {
		return msRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Marriage Seeker not found"));
	}//method

}//class
