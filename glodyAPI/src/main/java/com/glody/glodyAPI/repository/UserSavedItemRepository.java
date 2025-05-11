package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.UserSavedItem;

@Repository
public interface UserSavedItemRepository extends JpaRepository<UserSavedItem, UserSavedItem.UserSavedItemId> {
	List<UserSavedItem> findByUser_Id(Long userId);

	List<UserSavedItem> findByUser_IdAndItemType(Long userId, UserSavedItem.ItemType type);

	boolean existsByUser_IdAndItemTypeAndItemId(Long userId, UserSavedItem.ItemType type, Long itemId);
}