//DoctorMgmtServiceImpl.java
package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		// get all the records
		List<Doctor> list = docRepo.findAllById(ids);
		//delete the records
		docRepo.deleteAllByIdInBatch(ids);
		return list.size()+" records are deleted";
	}//method

	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... props) {
		// prepare Sort object
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, props);
		// prepare Example object
		Example<Doctor> example = Example.of(exDoctor);
		//get all the records
		List<Doctor> list = docRepo.findAll(example, sort);
		return list;
		}//method

	@Override
	public Doctor findDoctorById(Integer id) {
		Doctor doctor = docRepo.getReferenceById(id);
		return doctor;
	}//method

}//class
