package com.glody.glodyAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glody.glodyAPI.exception.ResourceNotFoundException;
import com.glody.glodyAPI.model.School;
import com.glody.glodyAPI.repository.SchoolRepository;
import com.glody.glodyAPI.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	private final SchoolRepository schoolRepository;

	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@Override
	public School createSchool(School school) {
		return schoolRepository.save(school);
	}

	@Override
	public School getSchoolById(Long id) {
		return schoolRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("School not found with id: " + id));
	}

	@Override
	public List<School> getAllSchools() {
		return schoolRepository.findAll();
	}

	@Override
	public List<School> getSchoolsByCountry(String country) {
		return schoolRepository.findByCountryIgnoreCase(country);
	}

	@Override
	public School updateSchool(Long id, School schoolDetails) {
		School school = getSchoolById(id);
		school.setName(schoolDetails.getName());
		school.setCountry(schoolDetails.getCountry());
		school.setWebsiteUrl(schoolDetails.getWebsiteUrl());
		return schoolRepository.save(school);
	}

	@Override
	public void deleteSchool(Long id) {
		School school = getSchoolById(id);
		schoolRepository.delete(school);
	}

	@Override
	public List<School> getSchoolsByRankingRange(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}
}