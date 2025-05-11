package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
	List<School> findByCountry(String country);

	@Query("SELECT s FROM School s WHERE s.qsRanking BETWEEN :minRank AND :maxRank")
	List<School> findByRankingRange(int minRank, int maxRank);

	List<School> findByNameContainingIgnoreCase(String name);
}