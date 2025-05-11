package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.CommunityPost;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
	List<CommunityPost> findByPostType(CommunityPost.PostType type);

	List<CommunityPost> findBySchoolTag_SchoolId(Long schoolId);

	List<CommunityPost> findByAuthor_UserIdOrderByCreatedAtDesc(Long userId);

	List<CommunityPost> findByIsFeaturedTrue();
}