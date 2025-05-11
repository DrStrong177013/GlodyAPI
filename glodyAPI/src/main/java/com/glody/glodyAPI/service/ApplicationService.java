package com.glody.glodyAPI.service;

import java.util.List;

import com.glody.glodyAPI.model.Application;

public interface ApplicationService {
	Application createApplication(Application application);

	Application getApplicationById(Long id);

	List<Application> getAllApplications();

	List<Application> getApplicationsByUserId(Long userId);

	Application updateApplicationStatus(Long id, String status);

	void deleteApplication(Long id);

	Application submitApplication(Long userId, Long programId, Application application);
}