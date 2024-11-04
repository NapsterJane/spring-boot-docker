package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Roles{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private Integer roleId;
	
	private String roleName;
	
	@OneToOne(mappedBy = "userRole", cascade = CascadeType.ALL)
	private Users user;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
