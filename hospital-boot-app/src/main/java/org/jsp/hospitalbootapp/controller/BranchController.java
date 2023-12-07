package org.jsp.hospitalbootapp.controller;

import java.util.List;

import org.jsp.hospitalbootapp.dto.Branch;
import org.jsp.hospitalbootapp.dto.ResponseStructure;
import org.jsp.hospitalbootapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	@Autowired
	private BranchService service;

	@PostMapping("/branch/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch,
			@PathVariable int hospital_id) {
		return service.saveBranch(branch, hospital_id);
	}

	@PutMapping("/branch/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> upadateBranch(@RequestBody Branch branch,
			@PathVariable int hospital_id) {
		return service.updateBranch(branch, hospital_id);
	}

	@GetMapping("/branch/by-id/{id}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(@PathVariable int id) {
		return service.findBranchByHospitalId(id);
	}

	@GetMapping("/branch/by-name/{name}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalName(@PathVariable String name) {
		return service.findBranchByHospitalName(name);
	}

	@GetMapping("/branch/by-gst/{gst}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(@PathVariable String gst) {
		return service.findBranchByHospitalGst(gst);
	}

}
