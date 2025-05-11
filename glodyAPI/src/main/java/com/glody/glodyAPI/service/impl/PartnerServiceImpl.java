package com.glody.glodyAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glody.glodyAPI.exception.ResourceNotFoundException;
import com.glody.glodyAPI.model.Partner;
import com.glody.glodyAPI.repository.PartnerRepository;
import com.glody.glodyAPI.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {

	private final PartnerRepository partnerRepository;

	public PartnerServiceImpl(PartnerRepository partnerRepository) {
		this.partnerRepository = partnerRepository;
	}

	@Override
	public Partner createPartner(Partner partner) {
		return partnerRepository.save(partner);
	}

	@Override
	public Partner getPartnerById(Long id) {
		return partnerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Partner not found with id: " + id));
	}

	@Override
	public List<Partner> getAllPartners() {
		return partnerRepository.findAll();
	}

	@Override
	public List<Partner> getVerifiedPartners() {
		return partnerRepository.findByCountryAndIsVerified(null, true); // hoặc thêm phương thức riêng nếu cần
	}

	@Override
	public Partner updatePartner(Long id, Partner partnerDetails) {
		Partner partner = partnerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Partner not found with id: " + id));

		partner.setName(partnerDetails.getName());
		partner.setType(partnerDetails.getType());
		partner.setCountry(partnerDetails.getCountry());
		partner.setDescription(partnerDetails.getDescription());
		partner.setContactEmail(partnerDetails.getContactEmail());
		partner.setContactPhone(partnerDetails.getContactPhone());
		partner.setWebsiteUrl(partnerDetails.getWebsiteUrl());
		partner.setCommissionRate(partnerDetails.getCommissionRate());
		partner.setRating(partnerDetails.getRating());
		partner.setIsVerified(partnerDetails.getIsVerified());

		return partnerRepository.save(partner);
	}

	@Override
	public void deletePartner(Long id) {
		Partner partner = partnerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Partner not found with id: " + id));
		partnerRepository.delete(partner);
	}

	@Override
	public Partner verifyPartner(Long id) {
		Partner partner = partnerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Partner not found"));
		partner.setIsVerified(true);
		return partnerRepository.save(partner);
	}
}
