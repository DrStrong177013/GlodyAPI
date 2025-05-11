package com.glody.glodyAPI.service;

import java.util.List;

import com.glody.glodyAPI.model.User;

public interface UserService {
	User createUser(User user);

	User getUserById(Long id);

	User getUserByEmail(String email);

	List<User> getAllUsers();

	List<User> getUsersByRole(String roleName);

	User updateUser(Long id, User userDetails);

	void deleteUser(Long id);

	User changeSubscriptionTier(Long userId, String tier);

	User updateAccountStatus(Long userId, String status);
}