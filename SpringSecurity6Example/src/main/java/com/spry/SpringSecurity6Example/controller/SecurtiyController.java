package com.spry.SpringSecurity6Example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurtiyController {

	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		return "wecome to my home page"+ request.getSession().getId();
	}
	
}
