package com.glody.glodyAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glody.glodyAPI.model.Application;
import com.glody.glodyAPI.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

	private final ApplicationService applicationService;

	public ApplicationController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	// Tạo application mới
	@PostMapping
	public ResponseEntity<Application> createApplication(@RequestBody Application application) {
		return ResponseEntity.ok(applicationService.createApplication(application));
	}

	// Lấy tất cả application
	@GetMapping
	public ResponseEntity<List<Application>> getAllApplications() {
		return ResponseEntity.ok(applicationService.getAllApplications());
	}

	// Lấy application theo ID
	@GetMapping("/{id}")
	public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
		return ResponseEntity.ok(applicationService.getApplicationById(id));
	}

	// Lấy danh sách application theo user ID
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Application>> getApplicationsByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(applicationService.getApplicationsByUserId(userId));
	}

	// Cập nhật trạng thái application
	@PutMapping("/{id}/status")
	public ResponseEntity<Application> updateApplicationStatus(@PathVariable Long id, @RequestParam String status) {
		return ResponseEntity.ok(applicationService.updateApplicationStatus(id, status));
	}

	// Xoá application
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
		applicationService.deleteApplication(id);
		return ResponseEntity.noContent().build();
	}

	// Gửi application (userId và programId là path variable)
	@PostMapping("/submit/{userId}/{programId}")
	public ResponseEntity<Application> submitApplication(@PathVariable Long userId, @PathVariable Long programId,
			@RequestBody Application application) {

		return ResponseEntity.ok(applicationService.submitApplication(userId, programId, application));
	}
}
