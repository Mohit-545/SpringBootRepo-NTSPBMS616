//IJobSeekerInfoService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerInfoService {
	
	public String registerJobSeekerInfo(JobSeekerInfo info);
	public List<JobSeekerInfo> getAllJobSeekerData();
	public String getResumePathById(Integer id);
	public String getPhotoPathById(Integer id);

}//interface
