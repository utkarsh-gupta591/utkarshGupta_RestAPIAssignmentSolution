package com.gl.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employeeManagement.entity.*;
import com.gl.employeeManagement.DAO.*;
import com.gl.employeeManagement.security.config.MyUserDetails;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);
	}

}