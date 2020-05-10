package com.example.jwtdemo.model;

public class AuthenticateResponse {
    private String jwtToken;

    public AuthenticateResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
