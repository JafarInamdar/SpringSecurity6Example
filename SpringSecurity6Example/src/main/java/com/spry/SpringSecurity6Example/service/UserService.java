package com.spry.SpringSecurity6Example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spry.SpringSecurity6Example.dao.UserRepository;
import com.spry.SpringSecurity6Example.model.Users;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public Users registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public String verify(Users user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
//			return "Success";
			return jwtService.generateToken(user.getUsername());
		}else {
			return "Fail";
		}
	}

}
