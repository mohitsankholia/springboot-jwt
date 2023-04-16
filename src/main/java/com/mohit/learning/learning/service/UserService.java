package com.mohit.learning.learning.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mohit.learning.learning.entity.User;

public interface UserService extends UserDetailsService{

	void saveUser(User user);

}
