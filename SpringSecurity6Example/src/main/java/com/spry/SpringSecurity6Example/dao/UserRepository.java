package com.spry.SpringSecurity6Example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spry.SpringSecurity6Example.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	public Users findByUsername(String username);
	
}
