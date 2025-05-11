package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByPost_Id(Long postId);

	List<Comment> findByAuthor_Id(Long userId);

	List<Comment> findByIsVerifiedAnswerTrueAndPost_Id(Long postId);
}