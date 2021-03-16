package com.project.stella_boutique.service.management.login;

public class LoginUseCaseInput {
    private String username;
    private String password;

    public void LoginUseCaseInput() {
    }

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
