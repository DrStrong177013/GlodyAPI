package com.glody.glodyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glody.glodyAPI.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
}
