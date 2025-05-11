package com.glody.glodyAPI.model;

import java.util.Date;

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
@Table(name = "login_history")
public class LoginHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date loginTime = new Date();

	private String ipAddress;
	private String deviceInfo;
	private boolean isSuccessful;
	private String locationCountry;
}