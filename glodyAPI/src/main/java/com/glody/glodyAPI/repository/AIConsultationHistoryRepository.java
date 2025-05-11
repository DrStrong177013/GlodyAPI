package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.AIConsultationHistory;

@Repository
public interface AIConsultationHistoryRepository extends JpaRepository<AIConsultationHistory, Long> {
	List<AIConsultationHistory> findByUser_UserId(Long userId);

	List<AIConsultationHistory> findByFeedbackScoreGreaterThanEqual(int minScore);
}