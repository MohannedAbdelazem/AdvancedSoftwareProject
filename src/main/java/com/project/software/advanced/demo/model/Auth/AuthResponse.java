package com.project.software.advanced.demo.model.Auth;

//import org.springframework.beans.factory.annotation.Autowired;
public class AuthResponse {

    public AuthResponse(String invalid_email_or_password) {
    }
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
