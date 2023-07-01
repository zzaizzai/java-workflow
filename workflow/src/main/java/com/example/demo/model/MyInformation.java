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

	public void logout() {
		this.name = null;
		this.loginId = null;
	}
	
	public void login(String loginId, String name) {
		setLoginId(loginId);
		setName(name);
	}
	
}
