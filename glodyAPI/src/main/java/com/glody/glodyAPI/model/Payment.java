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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false)
	private Double amount;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	private Date transactionDate = new Date();

	@Enumerated(EnumType.STRING)
	private ServiceType serviceType;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status = PaymentStatus.PENDING;

	private String invoiceUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_id")
	private Partner partner;

	@Column(unique = true)
	private String transactionId;

	private String currency = "USD";
	private Date expiryTime;

	public enum PaymentMethod {
		CREDIT_CARD, PAYPAL, BANK_TRANSFER, MOMO, ZALOPAY
	}

	public enum ServiceType {
		CONSULTANCY, PREMIUM_SUBSCRIPTION, APPLICATION_FEE, VISA_SERVICE, DOCUMENT_TRANSLATION
	}

	public enum PaymentStatus {
		PENDING, COMPLETED, FAILED, REFUNDED
	}
}