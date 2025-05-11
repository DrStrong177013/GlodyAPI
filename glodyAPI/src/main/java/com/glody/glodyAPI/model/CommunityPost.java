package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "community_posts")
public class CommunityPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User author;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Enumerated(EnumType.STRING)
	private PostType postType;

	private String countryTag;

	@ManyToOne
	@JoinColumn(name = "school_id")
	private School schoolTag;

	@ManyToOne
	@JoinColumn(name = "program_id")
	private Program programTag;

	private int upvotes = 0;
	private boolean isFeatured = false;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments;

	public enum PostType {
		QUESTION, EXPERIENCE, ADVICE, REVIEW
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}