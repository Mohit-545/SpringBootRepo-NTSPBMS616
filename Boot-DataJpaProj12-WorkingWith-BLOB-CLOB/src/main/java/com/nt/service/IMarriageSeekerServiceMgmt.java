//IMarriageSeekerServiceMgmt.java
package com.nt.service;

import com.nt.entity.MarriageSeeker;

public interface IMarriageSeekerServiceMgmt {
	
	public String registerMarriageSeeker(MarriageSeeker seeker);
	
	public MarriageSeeker searchMarriageSeekerById(Integer id);

}//interface
