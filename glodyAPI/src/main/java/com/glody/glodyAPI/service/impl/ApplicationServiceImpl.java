package com.glody.glodyAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glody.glodyAPI.exception.ResourceNotFoundException;
import com.glody.glodyAPI.model.Application;
import com.glody.glodyAPI.model.Program;
import com.glody.glodyAPI.model.User;
import com.glody.glodyAPI.repository.ApplicationRepository;
import com.glody.glodyAPI.repository.ProgramRepository;
import com.glody.glodyAPI.repository.UserRepository;
import com.glody.glodyAPI.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private final ApplicationRepository applicationRepository;
	private final UserRepository userRepository;
	private final ProgramRepository programRepository;

	public ApplicationServiceImpl(ApplicationRepository applicationRepository, UserRepository userRepository,
			ProgramRepository programRepository) {
		this.applicationRepository = applicationRepository;
		this.userRepository = userRepository;
		this.programRepository = programRepository;
	}

	@Override
	public Application createApplication(Application application) {
		return applicationRepository.save(application);
	}

	@Override
	public Application getApplicationById(Long id) {
		return applicationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
	}

	@Override
	public List<Application> getAllApplications() {
		return applicationRepository.findAll();
	}

	@Override
	public List<Application> getApplicationsByUserId(Long userId) {
		return applicationRepository.findByUser_UserId(userId);
	}

	@Override
	public Application updateApplicationStatus(Long id, String status) {
		Application application = getApplicationById(id);

		try {
			Application.ApplicationStatus parsedStatus = Application.ApplicationStatus.valueOf(status.toUpperCase());
			application.setApplicationStatus(parsedStatus);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid application status: " + status);
		}

		return applicationRepository.save(application);
	}

	@Override
	public void deleteApplication(Long id) {
		Application application = getApplicationById(id);
		applicationRepository.delete(application);
	}

	@Override
	public Application submitApplication(Long userId, Long programId, Application application) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Program program = programRepository.findById(programId)
				.orElseThrow(() -> new ResourceNotFoundException("Program not found"));

		application.setUser(user);
		application.setProgram(program);
		application.setApplicationStatus(Application.ApplicationStatus.SUBMITTED);

		return applicationRepository.save(application);
	}

}