//DoctorMgmtServiceImpl.java
package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepo docRepo;

	@Override
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
		//prepare Sort obj
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		//invoke the method by using Repo
		Iterable<Doctor> it = docRepo.findAll(sort);
		return it;
	}//method

	@Override
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String... props) {
		// prepare Sort object
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, props);
		//prepare Pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		//use Repo method
		Page<Doctor> page = docRepo.findAll(pageable);
		return page;
	}//method





}//class
