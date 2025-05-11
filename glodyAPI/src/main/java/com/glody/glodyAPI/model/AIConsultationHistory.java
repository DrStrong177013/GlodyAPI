package com.glody.glodyAPI.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "ai_consultation_history")
public class AIConsultationHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long consultationId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(columnDefinition = "JSON", nullable = false)
	private String inputData;

	@Column(columnDefinition = "JSON", nullable = false)
	private String recommendationResult;

	@Temporal(TemporalType.TIMESTAMP)
	private Date consultationDate = new Date();

	private Integer feedbackScore;

	@Column(length = 500)
	private String feedbackComment;

	private Integer sessionDurationSeconds;
}