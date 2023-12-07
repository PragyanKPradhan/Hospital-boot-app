package org.jsp.hospitalbootapp.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int year_of_establishment;
	@Column(nullable = false)
	private String founder;
	@Column(nullable = false)
	private String gst;
	@Column(nullable = false)
	private String password;
	@OneToMany(mappedBy = "hospital")
	private List<Branch> branch;

}
