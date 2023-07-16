package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private  String name;
	
	@Column(name = "login_id")
	private String loginId;
	
	@Column(name = "login_pw")
	private String loginPw;
	
	@Column(name = "is_admin")
	private Boolean isAdmin = false;
	
}
