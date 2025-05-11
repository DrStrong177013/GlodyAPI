package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
	List<Partner> findByType(Partner.PartnerType type);

	List<Partner> findByCountryAndIsVerified(String country, boolean isVerified);

	List<Partner> findByRatingGreaterThanEqual(double minRating);
}