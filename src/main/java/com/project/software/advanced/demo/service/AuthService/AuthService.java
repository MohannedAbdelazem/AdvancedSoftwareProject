package com.project.software.advanced.demo.service.AuthService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.Util.JwtUtil;
import com.project.software.advanced.demo.model.Auth.AuthResponse;
import com.project.software.advanced.demo.model.Auth.LoginRequest;
import com.project.software.advanced.demo.model.Auth.RegisterRequest;
import com.project.software.advanced.demo.model.User.UserRepository;

import com.project.software.advanced.demo.model.User.*;

@Service
public class AuthService implements AuthServiceInt {

	@Autowired
	private UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authManager;
	private final JwtUtil jwtUtil;

	public AuthService(PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManager authManager) {
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authManager = authManager;
	}

	@Override
	public AuthResponse register(RegisterRequest request) {
		User user = new User(request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()),
				request.getRole(), request.getCourseListID());

		User savedUser = userRepository.save(user);
		var token = jwtUtil.generateToken(savedUser.getEmail(), savedUser.getRole());
		AuthResponse response = new AuthResponse();
		response.setToken(token);

		return response;
	}

	@Override
	public AuthResponse login(LoginRequest loginRequest) {

		System.out.println("test before: " + loginRequest.getEmail() + " " + loginRequest.getPassword());
		authManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		System.out.println("test after");

		User xdd = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();

		var token = jwtUtil.generateToken(xdd.getEmail(), xdd.getRole());
		AuthResponse response = new AuthResponse();
		response.setToken(token);

		return response;

	}
}
