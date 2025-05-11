package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByRecipient_UserId(Long userId);

	List<Notification> findByRecipient_UserIdAndIsReadFalse(Long userId);

	List<Notification> findByTypeAndRelatedEntityType(Notification.NotificationType type, String entityType);
}