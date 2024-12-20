package com.project.software.advanced.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.software.advanced.demo.model.Auth.AuthResponse;
import com.project.software.advanced.demo.model.Auth.LoginRequest;
import com.project.software.advanced.demo.model.Auth.RegisterRequest;
import com.project.software.advanced.demo.service.AuthService.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService service;

	@Autowired
	public AuthController(AuthService service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(service.login(request));
	}
}
