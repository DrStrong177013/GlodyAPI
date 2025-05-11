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
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private CommunityPost post;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User author;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	private boolean isVerifiedAnswer = false;
}