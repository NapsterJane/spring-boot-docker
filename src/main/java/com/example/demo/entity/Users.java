package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;
	
	private String userName;
	
	private String userPassword;
	
	private String userMail;
	
	private Long userPhoneNo;
	
	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private Roles userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Long getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(Long userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}
	
	
}
