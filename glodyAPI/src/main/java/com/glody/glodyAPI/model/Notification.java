package com.glody.glodyAPI.model;

import java.util.Date;

import jakarta.persistence.Column;
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
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User recipient;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Enumerated(EnumType.STRING)
	private NotificationType type;

	private boolean isRead = false;

	private String relatedEntityType;
	private Long relatedEntityId;

	@Enumerated(EnumType.ORDINAL)
	private Priority priority = Priority.MEDIUM;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	public enum NotificationType {
		SYSTEM, APPLICATION_UPDATE, COMMUNITY, PAYMENT, PARTNER_CONNECTION
	}

	public enum Priority {
		LOW, MEDIUM, HIGH
	}
}