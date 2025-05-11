package com.glody.glodyAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glody.glodyAPI.model.Scholarship;
import com.glody.glodyAPI.service.ScholarshipService;

@RestController
@RequestMapping("/api/scholarships")
public class ScholarshipController {

	private final ScholarshipService scholarshipService;

	@Autowired
	public ScholarshipController(ScholarshipService scholarshipService) {
		this.scholarshipService = scholarshipService;
	}

	@PostMapping
	public ResponseEntity<Scholarship> createScholarship(@RequestBody Scholarship scholarship) {
		Scholarship createdScholarship = scholarshipService.createScholarship(scholarship);
		return ResponseEntity.ok(createdScholarship);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Scholarship> getScholarshipById(@PathVariable Long id) {
		Scholarship scholarship = scholarshipService.getScholarshipById(id);
		return ResponseEntity.ok(scholarship);
	}

	@GetMapping
	public ResponseEntity<List<Scholarship>> getAllScholarships() {
		List<Scholarship> scholarships = scholarshipService.getAllScholarships();
		return ResponseEntity.ok(scholarships);
	}

	@GetMapping("/program/{programId}")
	public ResponseEntity<List<Scholarship>> getScholarshipsByProgram(@PathVariable Long programId) {
		List<Scholarship> scholarships = scholarshipService.getScholarshipsByProgramId(programId);
		return ResponseEntity.ok(scholarships);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Scholarship> updateScholarship(@PathVariable Long id,
			@RequestBody Scholarship scholarshipDetails) {
		Scholarship updatedScholarship = scholarshipService.updateScholarship(id, scholarshipDetails);
		return ResponseEntity.ok(updatedScholarship);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteScholarship(@PathVariable Long id) {
		scholarshipService.deleteScholarship(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/eligible")
	public ResponseEntity<List<Scholarship>> findEligibleScholarships(@RequestParam(required = false) Double gpa,
			@RequestParam String country) {
		List<Scholarship> scholarships = scholarshipService.findEligibleScholarships(gpa, country);
		return ResponseEntity.ok(scholarships);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Scholarship>> searchScholarships(@RequestParam(required = false) String name,
			@RequestParam(required = false) String provider, @RequestParam(required = false) String coverage) {
		// Có thể triển khai thêm service method cho search phức tạp
		List<Scholarship> scholarships = scholarshipService.getAllScholarships(); // Tạm thời
		return ResponseEntity.ok(scholarships);
	}
}