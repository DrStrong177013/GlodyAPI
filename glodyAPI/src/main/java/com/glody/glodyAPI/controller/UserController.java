package com.glody.glodyAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glody.glodyAPI.model.User;
import com.glody.glodyAPI.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return ResponseEntity.ok(createdUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		User user = userService.getUserByEmail(email);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/role/{roleName}")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable String roleName) {
		List<User> users = userService.getUsersByRole(roleName);
		return ResponseEntity.ok(users);
	}

	@GetMapping("/premium")
	public ResponseEntity<List<User>> getPremiumUsers() {
		List<User> users = userService.getAllUsers(); // Sửa lại sau khi thêm method riêng
		return ResponseEntity.ok(users);
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<List<User>> getUsersByStatus(@PathVariable String status) {
		List<User> users = userService.getAllUsers(); // Sửa lại sau khi thêm method riêng
		return ResponseEntity.ok(users);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		User updatedUser = userService.updateUser(id, userDetails);
		return ResponseEntity.ok(updatedUser);
	}

	@PatchMapping("/{id}/subscription")
	public ResponseEntity<User> changeSubscriptionTier(@PathVariable Long id, @RequestParam String tier) {
		User updatedUser = userService.changeSubscriptionTier(id, tier);
		return ResponseEntity.ok(updatedUser);
	}

	@PatchMapping("/{id}/status")
	public ResponseEntity<User> updateAccountStatus(@PathVariable Long id, @RequestParam String status) {
		User updatedUser = userService.updateAccountStatus(id, status);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}