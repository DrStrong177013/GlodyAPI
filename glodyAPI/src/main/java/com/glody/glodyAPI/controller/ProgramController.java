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

import com.glody.glodyAPI.model.Program;
import com.glody.glodyAPI.service.ProgramService;

@RestController
@RequestMapping("/api/programs")
@CrossOrigin(origins = "*") // Cho phép gọi API từ frontend khác domain nếu cần
public class ProgramController {

	private final ProgramService programService;

	public ProgramController(ProgramService programService) {
		this.programService = programService;
	}

	// Create
	@PostMapping
	public ResponseEntity<Program> createProgram(@RequestBody Program program) {
		Program created = programService.createProgram(program);
		return ResponseEntity.ok(created);
	}

	// Get by ID
	@GetMapping("/{id}")
	public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
		Program program = programService.getProgramById(id);
		return ResponseEntity.ok(program);
	}

	// Get all
	@GetMapping
	public ResponseEntity<List<Program>> getAllPrograms() {
		return ResponseEntity.ok(programService.getAllPrograms());
	}

	// Get by school ID
	@GetMapping("/school/{schoolId}")
	public ResponseEntity<List<Program>> getProgramsBySchoolId(@PathVariable Long schoolId) {
		return ResponseEntity.ok(programService.getProgramsBySchoolId(schoolId));
	}

	// Get by field of study
	@GetMapping("/search/field")
	public ResponseEntity<List<Program>> getProgramsByField(@RequestParam String field) {
		return ResponseEntity.ok(programService.getProgramsByFieldOfStudy(field));
	}

	// Search by keyword, country, degree level
	@GetMapping("/search")
	public ResponseEntity<List<Program>> searchPrograms(@RequestParam String keyword, @RequestParam String country,
			@RequestParam String degreeLevel) {
		return ResponseEntity.ok(programService.searchPrograms(keyword, country, degreeLevel));
	}

	// Update
	@PutMapping("/{id}")
	public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program program) {
		return ResponseEntity.ok(programService.updateProgram(id, program));
	}

	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
		programService.deleteProgram(id);
		return ResponseEntity.noContent().build();
	}
}
