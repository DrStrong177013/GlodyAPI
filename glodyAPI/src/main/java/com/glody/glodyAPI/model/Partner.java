package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Partners")
public class Partner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long partnerId;

	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	private PartnerType type;

	private String country;
	private String description;
	private String contactEmail;
	private String contactPhone;
	private String websiteUrl;
	private Double commissionRate;
	private Double rating = 0.0;
	private Boolean isVerified = false;
	private Date partnerSince = new Date();

	@OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
	private Set<UserPartnerConnection> connections;

	public enum PartnerType {
		CONSULTANCY, LANGUAGE_CENTER, FINANCIAL, INSURANCE, ACCOMMODATION, VISA
	}
}