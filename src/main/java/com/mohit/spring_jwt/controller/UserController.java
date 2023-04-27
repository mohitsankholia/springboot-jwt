package com.mohit.spring_jwt.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.spring_jwt.dto.AuthRequest;
import com.mohit.spring_jwt.entity.User;
import com.mohit.spring_jwt.service.UserService;
import com.mohit.spring_jwt.utils.ApplicationUtils;
import com.mohit.spring_jwt.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/save")
	public ResponseEntity<Object> saveDepartment(@RequestBody User user) {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, " + ApplicationUtils.REQUESTPARAMETERS + user.toString());

		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		return jwtTokenUtil.generateToken(authRequest.getUsername());

	}

}
