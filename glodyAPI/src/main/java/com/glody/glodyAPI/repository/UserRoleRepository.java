package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Role;
import com.glody.glodyAPI.model.User;

@Repository
public interface UserRoleRepository extends JpaRepository<User, Long> {
	@Query("SELECT r FROM Role r JOIN UserRoles ur ON r.roleId = ur.roleId WHERE ur.userId = :userId")
	List<Role> findRolesByUserId(Long userId);

	@Query("SELECT u FROM User u JOIN UserRoles ur ON u.userId = ur.userId WHERE ur.roleId = :roleId")
	List<User> findUsersByRoleId(Long roleId);
}