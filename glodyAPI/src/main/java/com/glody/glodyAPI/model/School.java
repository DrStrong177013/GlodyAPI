package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schoolId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String country;

	private String city;
	private Integer qsRanking;
	private String description;
	private String websiteUrl;
	private String logoUrl;

	@Column(columnDefinition = "JSON")
	private String accreditation;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
	private Set<Program> programs;
	// Thêm quan hệ với CommunityPost
	@OneToMany(mappedBy = "schoolTag")
	private List<CommunityPost> taggedPosts;
}