package com.glody.glodyAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glody.glodyAPI.exception.ResourceNotFoundException;
import com.glody.glodyAPI.model.User;
import com.glody.glodyAPI.repository.UserRepository;
import com.glody.glodyAPI.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUsersByRole(String roleName) {
		// Implement logic here
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public User updateUser(Long id, User userDetails) {
		User user = getUserById(id);
		// Update user fields here
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		User user = getUserById(id);
		userRepository.delete(user);
	}

	@Override
	public User changeSubscriptionTier(Long userId, String tier) {
		User user = getUserById(userId);
		user.setSubscriptionTier(User.SubscriptionTier.valueOf(tier));
		return userRepository.save(user);
	}

	@Override
	public User updateAccountStatus(Long userId, String status) {
		User user = getUserById(userId);
		user.setAccountStatus(User.AccountStatus.valueOf(status));
		return userRepository.save(user);
	}
}