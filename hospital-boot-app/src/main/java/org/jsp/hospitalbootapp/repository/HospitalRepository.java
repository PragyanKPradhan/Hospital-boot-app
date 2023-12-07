package org.jsp.hospitalbootapp.repository;

import org.jsp.hospitalbootapp.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
