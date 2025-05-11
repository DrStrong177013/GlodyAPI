package com.glody.glodyAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.subscriptionTier = 'PREMIUM'")
	List<User> findAllPremiumUsers();

	List<User> findByAccountStatus(User.AccountStatus status);

	// Thêm method mới
	@Query("SELECT u FROM User u JOIN UserRoles ur ON u.userId = ur.userId WHERE ur.roleId = :roleId")
	List<User> findByRoleId(Long roleId);
}