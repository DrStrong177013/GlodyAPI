package com.glody.glodyAPI.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "scholarships") // Tên bảng nên là lowercase
public class Scholarship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scholarshipId;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100)
	private String provider;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private CoverageType coverage;

	@Column(precision = 12)
	private Double amount;

	@Temporal(TemporalType.DATE)
	private Date applicationDeadline;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String requirements;

	@Column(length = 255)
	private String link;

	@Column(columnDefinition = "JSON", nullable = false)
	private String eligibleCountries = "[]"; // Khởi tạo mặc định

	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean isCompetitive = true;

	@ManyToMany
	@JoinTable(name = "program_scholarships", joinColumns = @JoinColumn(name = "scholarship_id"), inverseJoinColumns = @JoinColumn(name = "program_id"))
	private Set<Program> programs;

	public enum CoverageType {
		FULL, PARTIAL, TUITION, LIVING
	}

	// Phương thức tiện ích để thêm program
	public void addProgram(Program program) {
		this.programs.add(program);
		program.getScholarships().add(this);
	}

	// Phương thức tiện ích để xóa program
	public void removeProgram(Program program) {
		this.programs.remove(program);
		program.getScholarships().remove(this);
	}
}