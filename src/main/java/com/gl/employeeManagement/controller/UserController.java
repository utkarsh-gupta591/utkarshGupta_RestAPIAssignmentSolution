package com.gl.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeeManagement.entity.*;
import com.gl.employeeManagement.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}

	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		userService.saveRole(role);
		return role;
	}
}