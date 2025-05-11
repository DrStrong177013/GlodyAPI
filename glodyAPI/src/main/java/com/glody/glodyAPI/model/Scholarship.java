package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Scholarships")
public class Scholarship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scholarshipId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String provider;

	@Lob
	private String description;

	@Enumerated(EnumType.STRING)
	private CoverageType coverage;

	private Double amount;
	private Date applicationDeadline;
	private String requirements;
	private String link;

	@Column(columnDefinition = "JSON")
	private String eligibleCountries;

	private Boolean isCompetitive = true;

	@ManyToMany(mappedBy = "scholarships")
	private Set<Program> programs;

	public enum CoverageType {
		FULL, PARTIAL, TUITION, LIVING
	}
}