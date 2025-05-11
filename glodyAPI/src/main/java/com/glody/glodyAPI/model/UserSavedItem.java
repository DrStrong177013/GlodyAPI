package com.glody.glodyAPI.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "UserSavedItems")
@IdClass(UserSavedItem.UserSavedItemId.class)
public class UserSavedItem {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@Enumerated(EnumType.STRING)
	private ItemType itemType;

	@Id
	private Long itemId;

	private Date savedAt = new Date();
	private String notes;

	public enum ItemType {
		SCHOOL, PROGRAM, SCHOLARSHIP
	}

	@Embeddable
	public static class UserSavedItemId implements Serializable {
		private Long user;
		private ItemType itemType;
		private Long itemId;
	}
}