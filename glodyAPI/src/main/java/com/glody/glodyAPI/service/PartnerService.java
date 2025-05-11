package com.glody.glodyAPI.service;

import java.util.List;

import com.glody.glodyAPI.model.Partner;

public interface PartnerService {
	Partner createPartner(Partner partner);

	Partner getPartnerById(Long id);

	List<Partner> getAllPartners();

	List<Partner> getVerifiedPartners();

	Partner updatePartner(Long id, Partner partnerDetails);

	void deletePartner(Long id);

	Partner verifyPartner(Long id);
}