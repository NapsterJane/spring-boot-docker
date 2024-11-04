package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.HomeService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class HomeController {
	
	private HomeService homeService;
	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@PostMapping(value = "/register/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody Users user, @PathVariable String role){
		String status = homeService.validateUserDetails(user, role);
		log.info("uer details {}", user.getUserPhoneNo());
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> login(){
		return null;
	}
}
