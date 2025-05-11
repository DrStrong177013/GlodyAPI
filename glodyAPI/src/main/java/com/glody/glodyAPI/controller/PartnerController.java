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
import org.springframework.web.bind.annotation.RestController;

import com.glody.glodyAPI.model.Partner;
import com.glody.glodyAPI.service.PartnerService;

@RestController
@RequestMapping("/api/partners")
@CrossOrigin(origins = "*") // nếu bạn dùng frontend gọi từ domain khác
public class PartnerController {

	private final PartnerService partnerService;

	public PartnerController(PartnerService partnerService) {
		this.partnerService = partnerService;
	}

	// Tạo mới partner
	@PostMapping
	public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
		Partner savedPartner = partnerService.createPartner(partner);
		return ResponseEntity.ok(savedPartner);
	}

	// Lấy tất cả partners
	@GetMapping
	public ResponseEntity<List<Partner>> getAllPartners() {
		return ResponseEntity.ok(partnerService.getAllPartners());
	}

	// Lấy partner theo ID
	@GetMapping("/{id}")
	public ResponseEntity<Partner> getPartnerById(@PathVariable Long id) {
		return ResponseEntity.ok(partnerService.getPartnerById(id));
	}

	// Lấy danh sách partner đã được xác minh
	@GetMapping("/verified")
	public ResponseEntity<List<Partner>> getVerifiedPartners() {
		return ResponseEntity.ok(partnerService.getVerifiedPartners());
	}

	// Cập nhật partner
	@PutMapping("/{id}")
	public ResponseEntity<Partner> updatePartner(@PathVariable Long id, @RequestBody Partner partnerDetails) {
		return ResponseEntity.ok(partnerService.updatePartner(id, partnerDetails));
	}

	// Xóa partner
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
		partnerService.deletePartner(id);
		return ResponseEntity.noContent().build();
	}

	// Xác minh partner
	@PostMapping("/{id}/verify")
	public ResponseEntity<Partner> verifyPartner(@PathVariable Long id) {
		return ResponseEntity.ok(partnerService.verifyPartner(id));
	}
}
