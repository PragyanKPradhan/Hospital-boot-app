package org.jsp.hospitalbootapp.dao;

import java.util.Optional;

import org.jsp.hospitalbootapp.dto.Hospital;
import org.jsp.hospitalbootapp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	
	public Optional<Hospital> findById(int id){
		return repository.findById(id);
	}
	
	public boolean deleteHospital(int id) {
		 Optional<Hospital> recHospital=repository.findById(id);
		 if(recHospital.isPresent()) {
			 repository.deleteById(id);
			 return true;
		 }
		 return false;
	}
	
	
}
