package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Role;
import com.glody.glodyAPI.model.User;

@Repository
public interface UserRoleRepository extends JpaRepository<User, Long> {
	List<Role> findRolesByUserId(Long userId);

	List<User> findUsersByRoles_RoleId(Long roleId);
}