package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Scholarship;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
	List<Scholarship> findByCoverage(Scholarship.CoverageType coverage);

	List<Scholarship> findByAmountGreaterThanEqual(double minAmount);

	List<Scholarship> findByApplicationDeadlineAfter(java.util.Date date);
}