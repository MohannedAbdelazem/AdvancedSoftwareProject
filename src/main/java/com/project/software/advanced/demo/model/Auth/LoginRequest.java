package com.project.software.advanced.demo.model.Auth;

//import org.springframework.beans.factory.annotation.Autowired;

public class LoginRequest {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
        this.email = email;
    }
	public void setPassword(String password) {
        this.password = password;
    }

}
