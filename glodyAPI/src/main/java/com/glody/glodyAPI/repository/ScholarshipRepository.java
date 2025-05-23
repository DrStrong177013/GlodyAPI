package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Scholarship;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
	List<Scholarship> findByCoverage(Scholarship.CoverageType coverage);

	List<Scholarship> findByAmountGreaterThanEqual(double minAmount);

	List<Scholarship> findByApplicationDeadlineAfter(java.util.Date date);

	// Bổ sung các method mới để hỗ trợ Service
	List<Scholarship> findByPrograms_ProgramId(Long programId);

	List<Scholarship> findByAmountGreaterThanAndEligibleCountriesContaining(double minAmount, String country);

	// Thêm method tìm kiếm theo tên (nếu cần)
	List<Scholarship> findByNameContainingIgnoreCase(String name);

	// Thêm method tìm kiếm theo provider
	List<Scholarship> findByProviderContainingIgnoreCase(String provider);
}