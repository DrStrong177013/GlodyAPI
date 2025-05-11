package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(unique = true, nullable = false)
	private String username;

	@JsonIgnore
	@Column(nullable = false, name = "password_hash")
	private String passwordHash;

	@Column(unique = true, nullable = false)
	private String email;

	private String fullName;
	private Date dateOfBirth;
	private String phoneNumber;
	private String countryOfOrigin;
	private String currentEducationLevel;
	private Double gpa;
	private String englishTestType;
	private Double englishTestScore;
	private Double budget;
	private String preferredMajor;

	@Column(columnDefinition = "JSON")
	private String preferredCountries;

	private String targetLanguage;

	@CreationTimestamp
	private Date createdAt;

	private Date lastLogin;

	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus = AccountStatus.ACTIVE;

	@Enumerated(EnumType.STRING)
	private SubscriptionTier subscriptionTier = SubscriptionTier.FREE;

	private Boolean isEmailVerified = false;
	private String profileImageUrl;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "UserRoles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<LoginHistory> loginHistories = new HashSet<>();
	// Thêm các quan hệ mới
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<CommunityPost> posts;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
	private List<Notification> notifications;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserPartnerConnection> partnerConnections;

	public enum AccountStatus {
		ACTIVE, INACTIVE, BANNED
	}

	public enum SubscriptionTier {
		FREE, BASIC, PREMIUM
	}

}
