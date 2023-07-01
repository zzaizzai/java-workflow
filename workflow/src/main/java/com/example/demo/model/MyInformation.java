package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope
@Data
public class MyInformation {

	private String name;

	private String loginId;
	
	private boolean isAdmin;
	
	private boolean isLoggedIn;

	public void logout() {
		this.name = null;
		this.loginId = null;
		this.isAdmin = false;
		this.isLoggedIn = false;
	}
	
	public void login(String loginId, String name, Boolean isAdmin) {
		setLoginId(loginId);
		setName(name);
		setAdmin(isAdmin);
		setLoggedIn(true);
	}
	
}
