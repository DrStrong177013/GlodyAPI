package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Programs")
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long programId;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id", nullable = false)
	private School school;

	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	private DegreeLevel degreeLevel;

	@Column(nullable = false)
	private String fieldOfStudy;

	private Integer durationMonths;
	private Double tuitionFee;
	private Double applicationFee;

	@Column(columnDefinition = "JSON")
	private String languageRequirements;

	@Lob
	private String academicRequirements;

	private Date applicationDeadline;

	@Column(columnDefinition = "JSON")
	private String intakeSeasons;

	private Boolean scholarshipAvailable = false;
	private String programLink;

	@OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
	private Set<Application> applications;

	@ManyToMany
	@JoinTable(name = "ProgramScholarships", joinColumns = @JoinColumn(name = "program_id"), inverseJoinColumns = @JoinColumn(name = "scholarship_id"))
	private Set<Scholarship> scholarships;

	@OneToMany(mappedBy = "programTag")
	private List<CommunityPost> taggedPosts;

	public enum DegreeLevel {
		BACHELOR, MASTER, PHD, DIPLOMA, LANGUAGE
	}
}