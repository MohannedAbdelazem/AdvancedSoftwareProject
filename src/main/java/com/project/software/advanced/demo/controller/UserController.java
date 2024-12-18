package com.project.software.advanced.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.software.advanced.demo.model.User.User;
import com.project.software.advanced.demo.service.UserService.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = service.fetchUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<String> getUserById(@PathVariable("id") int userID) {
		User user = service.getUserById(userID);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: User not found");
		}
		return ResponseEntity.ok("User: " + user.toString());
	}

	@PostMapping("/user")
	public ResponseEntity<String> postUser(@RequestBody User user) {
		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: User data is null");
		}
		User savedUser = service.saveUser(user);
		if (savedUser == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		// TODO: create and return jwt token
		return ResponseEntity.status(HttpStatus.CREATED).body("User created: " + savedUser.toString());
	}
}
