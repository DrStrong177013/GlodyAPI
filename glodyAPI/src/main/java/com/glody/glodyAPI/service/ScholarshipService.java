package com.glody.glodyAPI.service;

import java.util.List;

import com.glody.glodyAPI.model.Scholarship;

public interface ScholarshipService {
	Scholarship createScholarship(Scholarship scholarship);

	Scholarship getScholarshipById(Long id);

	List<Scholarship> getAllScholarships();

	List<Scholarship> getScholarshipsByProgramId(Long programId);

	Scholarship updateScholarship(Long id, Scholarship scholarshipDetails);

	void deleteScholarship(Long id);

	List<Scholarship> findEligibleScholarships(Double gpa, String country);

	List<Scholarship> findByNameContaining(String name);

	List<Scholarship> findByProviderContaining(String provider);

	List<Scholarship> findByCoverage(Scholarship.CoverageType coverage);
}