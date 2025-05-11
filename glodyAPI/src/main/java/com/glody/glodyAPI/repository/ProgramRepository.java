package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
	List<Program> findByFieldOfStudyContainingIgnoreCase(String field);

	@Query("SELECT p FROM Program p WHERE p.degreeLevel = :level AND p.tuitionFee <= :maxFee")
	List<Program> findByDegreeLevelAndMaxFee(Program.DegreeLevel level, double maxFee);

	List<Program> findBySchool_Country(String country);

	// Thêm method mới liên quan đến học bổng
	@Query("SELECT p FROM Program p JOIN ProgramScholarships ps ON p.programId = ps.programId WHERE ps.scholarshipId = :scholarshipId")
	List<Program> findByScholarshipId(Long scholarshipId);
}