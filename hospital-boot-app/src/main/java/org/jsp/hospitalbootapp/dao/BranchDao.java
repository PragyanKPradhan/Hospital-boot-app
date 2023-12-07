package org.jsp.hospitalbootapp.dao;

import java.util.List;

import org.jsp.hospitalbootapp.dto.Branch;
import org.jsp.hospitalbootapp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository repository;
	
	public Branch saveBranch(Branch branch) {
		return repository.save(branch);
	}
	
	public Branch updateBranch(Branch branch) {
		return repository.save(branch);
	}
	
	public List<Branch> findBranchByHospitalId(int id){
		return repository.findBranchByHospitalId(id);
	}
	
	public List<Branch> findBranchByHospitalName(String name){
		return repository.findBranchByHospitalName(name);
	}
	
	public List<Branch> findBranchByHospitalGst(String gst){
		return repository.findBranchByHospitalGst(gst);
	}

}
