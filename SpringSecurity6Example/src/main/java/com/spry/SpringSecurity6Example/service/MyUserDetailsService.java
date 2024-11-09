package com.spry.SpringSecurity6Example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spry.SpringSecurity6Example.dao.UserRepository;
import com.spry.SpringSecurity6Example.model.UserPrinciple;
import com.spry.SpringSecurity6Example.model.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepository.findByUsername(username);
		
		if(user ==null) {
			System.out.println(("USer not found with username ::"+username));
			throw new UsernameNotFoundException("use not fourn :: "+username);
		}
		return new UserPrinciple(user);
	}

}
