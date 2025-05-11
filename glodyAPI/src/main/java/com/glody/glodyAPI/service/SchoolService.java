package com.glody.glodyAPI.service;

import java.util.List;

import com.glody.glodyAPI.model.School;

public interface SchoolService {
	School createSchool(School school);

	School getSchoolById(Long id);

	List<School> getAllSchools();

	List<School> getSchoolsByCountry(String country);

	List<School> getSchoolsByRankingRange(int min, int max);

	School updateSchool(Long id, School schoolDetails);

	void deleteSchool(Long id);
}