package com.glody.glodyAPI.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Applications")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id", nullable = false)
	private Program program;

	@Enumerated(EnumType.STRING)
	private ApplicationStatus applicationStatus = ApplicationStatus.DRAFT;

	private Date submissionDate;

	@Column(columnDefinition = "JSON")
	private String requiredDocuments;

	@Lob
	private String notes;

	private Boolean applicationFeePaid = false;

	public enum ApplicationStatus {
		DRAFT, SUBMITTED, UNDER_REVIEW, INTERVIEW, ACCEPTED, REJECTED, WAITLISTED
	}
}