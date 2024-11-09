package com.spry.SpringSecurity6Example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spry.SpringSecurity6Example.model.Users;
import com.spry.SpringSecurity6Example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public Users registerUsers(@RequestBody Users user) {
	 return	userService.registerUser(user);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Users user) {
		System.out.println("Login"+ user);
	  return userService.verify(user);	
	}
}
