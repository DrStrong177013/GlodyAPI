package com.glody.glodyAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glody.glodyAPI.exception.ResourceNotFoundException;
import com.glody.glodyAPI.model.Scholarship;
import com.glody.glodyAPI.repository.ScholarshipRepository;
import com.glody.glodyAPI.service.ScholarshipService;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

	private final ScholarshipRepository scholarshipRepository;

	public ScholarshipServiceImpl(ScholarshipRepository scholarshipRepository) {
		this.scholarshipRepository = scholarshipRepository;
	}

	@Override
	public Scholarship createScholarship(Scholarship scholarship) {
		return scholarshipRepository.save(scholarship);
	}

	@Override
	public Scholarship getScholarshipById(Long id) {
		return scholarshipRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Scholarship not found with id: " + id));
	}

	@Override
	public List<Scholarship> getAllScholarships() {
		return scholarshipRepository.findAll();
	}

	@Override
	public List<Scholarship> getScholarshipsByProgramId(Long programId) {
		return scholarshipRepository.findByPrograms_ProgramId(programId);
	}

	@Override
	public Scholarship updateScholarship(Long id, Scholarship scholarshipDetails) {
		Scholarship scholarship = getScholarshipById(id);
		scholarship.setName(scholarshipDetails.getName());
		scholarship.setAmount(scholarshipDetails.getAmount());
		scholarship.setApplicationDeadline(scholarshipDetails.getApplicationDeadline());
		return scholarshipRepository.save(scholarship);
	}

	@Override
	public void deleteScholarship(Long id) {
		Scholarship scholarship = getScholarshipById(id);
		scholarshipRepository.delete(scholarship);
	}

	@Override
	public List<Scholarship> findEligibleScholarships(Double gpa, String country) {
		return scholarshipRepository.findByAmountGreaterThanAndEligibleCountriesContaining(0.0, country);
	}

	@Override
	public List<Scholarship> findByNameContaining(String name) {
		return scholarshipRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Scholarship> findByProviderContaining(String provider) {
		return scholarshipRepository.findByProviderContainingIgnoreCase(provider);
	}

	@Override
	public List<Scholarship> findByCoverage(Scholarship.CoverageType coverage) {
		return scholarshipRepository.findByCoverage(coverage);
	}
}