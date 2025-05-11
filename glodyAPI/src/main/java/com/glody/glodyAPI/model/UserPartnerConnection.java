package com.glody.glodyAPI.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "user_partner_connections")
public class UserPartnerConnection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long connectionId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "partner_id", nullable = false)
	private Partner partner;

	@Enumerated(EnumType.STRING)
	private ServiceType serviceType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date connectionDate = new Date();

	@Enumerated(EnumType.STRING)
	private ConnectionStatus status = ConnectionStatus.PENDING;

	private Double commissionEarned;
	private String notes;
	private Double serviceFee;

	public enum ServiceType {
		VISA, ACCOMMODATION, INSURANCE, LANGUAGE_TEST, DOCUMENT_PREP
	}

	public enum ConnectionStatus {
		PENDING, IN_PROGRESS, COMPLETED, CANCELLED, REJECTED
	}
}