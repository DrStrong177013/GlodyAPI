package com.glody.glodyAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glody.glodyAPI.exception.ResourceNotFoundException;
import com.glody.glodyAPI.model.Program;
import com.glody.glodyAPI.model.Program.DegreeLevel;
import com.glody.glodyAPI.model.School;
import com.glody.glodyAPI.repository.ProgramRepository;
import com.glody.glodyAPI.repository.SchoolRepository;
import com.glody.glodyAPI.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {

	private final ProgramRepository programRepository;
	private final SchoolRepository schoolRepository;

	public ProgramServiceImpl(ProgramRepository programRepository, SchoolRepository schoolRepository) {
		this.programRepository = programRepository;
		this.schoolRepository = schoolRepository;
	}

	@Override
	public Program createProgram(Program program) {
		School school = schoolRepository.findById(program.getSchool().getSchoolId())
				.orElseThrow(() -> new ResourceNotFoundException("School not found"));
		program.setSchool(school);
		return programRepository.save(program);
	}

	@Override
	public Program getProgramById(Long id) {
		return programRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Program not found with id: " + id));
	}

	@Override
	public List<Program> getAllPrograms() {
		return programRepository.findAll();
	}

	@Override
	public List<Program> getProgramsBySchoolId(Long schoolId) {
		return programRepository.findBySchool_SchoolId(schoolId);
	}

	@Override
	public List<Program> getProgramsByFieldOfStudy(String field) {
		return programRepository.findByFieldOfStudyContainingIgnoreCase(field);
	}

	@Override
	public Program updateProgram(Long id, Program programDetails) {
		Program program = getProgramById(id);
		program.setName(programDetails.getName());
		program.setFieldOfStudy(programDetails.getFieldOfStudy());
		program.setTuitionFee(programDetails.getTuitionFee());
		return programRepository.save(program);
	}

	@Override
	public void deleteProgram(Long id) {
		Program program = getProgramById(id);
		programRepository.delete(program);
	}

	@Override
	public List<Program> searchPrograms(String keyword, String country, String degreeLevel) {
		DegreeLevel level = DegreeLevel.fromString(degreeLevel);
		if (level == null) {
			throw new IllegalArgumentException("Invalid degree level: " + degreeLevel);
		}
		return programRepository.findByNameContainingOrFieldOfStudyContainingOrSchool_CountryOrDegreeLevel(keyword,
				keyword, country, level);
	}

}