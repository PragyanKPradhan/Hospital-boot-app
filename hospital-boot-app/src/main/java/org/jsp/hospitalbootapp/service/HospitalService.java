package org.jsp.hospitalbootapp.service;

import java.util.Optional;

import org.jsp.hospitalbootapp.dao.HospitalDao;
import org.jsp.hospitalbootapp.dto.Hospital;
import org.jsp.hospitalbootapp.dto.ResponseStructure;
import org.jsp.hospitalbootapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		hospital = dao.saveHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("Hospital saved with id "+hospital.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		hospital = dao.updateHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("Hospital successfully updated!");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findById(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		Optional<Hospital> recHospital = dao.findById(id);
		if(recHospital.isPresent()) {
			structure.setData(recHospital.get());
			structure.setMessage("Hospital Found!");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		boolean deleted = dao.deleteHospital(id);
		if(deleted) {
			structure.setData("Hospital Deleted!");
			structure.setMessage("Hospital found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
}
