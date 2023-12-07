package org.jsp.hospitalbootapp.repository;

import java.util.List;

import org.jsp.hospitalbootapp.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
	@Query("select b from Branch b where b.hospital.id=?1")
	public List<Branch> findBranchByHospitalId(int id);

	@Query("select b from Branch b where b.hospital.name=?1")
	public List<Branch> findBranchByHospitalName(String name);
	
	@Query("select b from Branch b where b.hospital.gst=?1")
	public List<Branch> findBranchByHospitalGst(String name);

}
