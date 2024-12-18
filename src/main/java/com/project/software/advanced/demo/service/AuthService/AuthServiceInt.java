package com.project.software.advanced.demo.service.AuthService;

import com.project.software.advanced.demo.model.Auth.LoginRequest;
import com.project.software.advanced.demo.model.Auth.RegisterRequest;
import com.project.software.advanced.demo.model.Auth.AuthResponse;

public interface AuthServiceInt {
	public AuthResponse register(RegisterRequest loginRequest);

	public AuthResponse login(LoginRequest loginRequest);
}
