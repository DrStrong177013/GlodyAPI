package com.glody.glodyAPI.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(unique = true, nullable = false)
	private String roleName;

	@Column(columnDefinition = "JSON")
	private String permissions;

	private String description;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
}