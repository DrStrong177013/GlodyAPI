package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.LoginHistory;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
	List<LoginHistory> findByUser_UserId(Long userId);

	List<LoginHistory> findByIsSuccessfulAndLoginTimeAfter(boolean isSuccessful, java.util.Date date);

	List<LoginHistory> findByIpAddress(String ipAddress);
}