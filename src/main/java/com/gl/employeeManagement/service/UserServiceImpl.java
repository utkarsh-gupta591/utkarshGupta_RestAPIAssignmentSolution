package com.gl.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeManagement.DAO.RoleRepository;
import com.gl.employeeManagement.DAO.UserRepository;
import com.gl.employeeManagement.entity.Role;
import com.gl.employeeManagement.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
}