package org.jsp.hospitalbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalbootapp.dao.BranchDao;
import org.jsp.hospitalbootapp.dao.HospitalDao;
import org.jsp.hospitalbootapp.dto.Branch;
import org.jsp.hospitalbootapp.dto.Hospital;
import org.jsp.hospitalbootapp.dto.ResponseStructure;
import org.jsp.hospitalbootapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hospital_id) {
		Optional<Hospital> recHospital = hospitalDao.findById(hospital_id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (recHospital.isPresent()) {
			Hospital h = recHospital.get();
			h.getBranch().add(branch);
			branch.setHospital(h);
			hospitalDao.updateHospital(h);
			dao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch added with id : " + branch.getId());
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int hospital_id) {
		Optional<Hospital> recHospital = hospitalDao.findById(hospital_id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (recHospital.isPresent()) {
			Hospital h = recHospital.get();
			branch.setHospital(h);
			dao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch Updated!");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(int id) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		structure.setData(dao.findBranchByHospitalId(id));
		structure.setMessage("List of Hospitals");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalName(String name) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		structure.setData(dao.findBranchByHospitalName(name));
		structure.setMessage("List of Hospitals");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalGst(String gst) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		structure.setData(dao.findBranchByHospitalGst(gst));
		structure.setMessage("List of Hospitals");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
	}
}
