package com.mohit.learning.learning.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mohit.learning.learning.entity.User;
import com.mohit.learning.learning.exceptions.CustomExceptions;
import com.mohit.learning.learning.repository.UserRepository;
import com.mohit.learning.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {

		if (user == null) {
			throw new CustomExceptions();
		} else {

			userRepository.save(user);
		}

	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByName(username);

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				new ArrayList<>());
	}

}
