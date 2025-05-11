package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

	// Search by country, case-insensitive
	List<School> findByCountryIgnoreCase(String country);

	// Search by name containing keyword, case-insensitive
	List<School> findByNameContainingIgnoreCase(String name);

	// Search by QS ranking within a range
	List<School> findByQsRankingBetween(Integer minRank, Integer maxRank);
}
