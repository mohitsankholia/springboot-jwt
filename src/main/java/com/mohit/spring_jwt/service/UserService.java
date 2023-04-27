package com.mohit.spring_jwt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mohit.spring_jwt.entity.User;

public interface UserService extends UserDetailsService{

	void saveUser(User user);

}
