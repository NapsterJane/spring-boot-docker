package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.repository.RolesRepository;
import com.example.demo.repository.UsersRepostory;

@Service
public class HomeService {
	
	private UsersRepostory usersRepostory;
	private RolesRepository rolesRepository;
	
	public HomeService(UsersRepostory usersRepostory, RolesRepository rolesRepository) {
		this.usersRepostory = usersRepostory;
		this.rolesRepository = rolesRepository;
	}

	public String validateUserDetails(Users user, String role) {
		String status = "";
		Optional<Users> isFound = usersRepostory.findByUserName(user.getUserName());
		if(!isFound.isEmpty()) {
			status = "Username Already exists";
		} else {
			Roles roleObj = new Roles();
			roleObj.setRoleName(role);
			roleObj = rolesRepository.save(roleObj);
			user.setUserRole(roleObj);
			usersRepostory.save(user);
			status = "Saved SuccessFully";
		}
		return status;
	}

}
