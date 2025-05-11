package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Program;
import com.glody.glodyAPI.model.Scholarship;

@Repository
public interface ProgramScholarshipRepository extends JpaRepository<Program, Long> {
	// Custom query để lấy danh sách học bổng của một chương trình
	List<Scholarship> findScholarshipsByProgramId(Long programId);

	// Kiểm tra xem học bổng có áp dụng cho chương trình không
	boolean existsByProgramIdAndScholarships_ScholarshipId(Long programId, Long scholarshipId);
}