//JobSeekerInfoServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerInfoRepository;

@Service
public class JobSeekerInfoServiceImpl implements IJobSeekerInfoService {
	@Autowired
	private IJobSeekerInfoRepository jsRepo;

	@Override
	public String registerJobSeekerInfo(JobSeekerInfo info) {
		
		return "Job Seeker Info is saved with ID no :: "+jsRepo.save(info).getJsId();
	}//method

	@Override
	public List<JobSeekerInfo> getAllJobSeekerData() {
		
		return jsRepo.findAll();
	}//method
	
	@Override
	public String getResumePathById(Integer id) {
		return jsRepo.getResumePathById(id);
	}//method

	@Override
	public String getPhotoPathById(Integer id) {
		return jsRepo.getPhotoPathById(id);
	}//method
	
	
}//class
