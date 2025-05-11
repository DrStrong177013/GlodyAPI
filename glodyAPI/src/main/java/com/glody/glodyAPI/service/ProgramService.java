package com.glody.glodyAPI.service;

import java.util.List;

import com.glody.glodyAPI.model.Program;

public interface ProgramService {
	Program createProgram(Program program);

	Program getProgramById(Long id);

	List<Program> getAllPrograms();

	List<Program> getProgramsBySchoolId(Long schoolId);

	List<Program> getProgramsByFieldOfStudy(String field);

	Program updateProgram(Long id, Program programDetails);

	void deleteProgram(Long id);

	List<Program> searchPrograms(String keyword, String country, String degreeLevel);
}