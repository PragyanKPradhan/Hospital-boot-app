package org.jsp.hospitalbootapp.controller;

import org.jsp.hospitalbootapp.dto.Hospital;
import org.jsp.hospitalbootapp.dto.ResponseStructure;
import org.jsp.hospitalbootapp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	@PostMapping("/hospitals")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}
	
	@PutMapping("/hospitals")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital){
		return service.updateHospital(hospital);
	}
	@GetMapping("/hospitals/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findById(@PathVariable int id){
		return service.findById(id);
	}
	@DeleteMapping("/hospitals/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(@PathVariable int id){
		return service.deleteHospitalById(id);
	}

}
