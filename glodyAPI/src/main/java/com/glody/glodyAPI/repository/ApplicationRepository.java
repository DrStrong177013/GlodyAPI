package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	List<Application> findByUser_UserId(Long userId);

	List<Application> findByProgram_School_SchoolId(Long schoolId);

	List<Application> findByApplicationStatus(Application.ApplicationStatus status);
}