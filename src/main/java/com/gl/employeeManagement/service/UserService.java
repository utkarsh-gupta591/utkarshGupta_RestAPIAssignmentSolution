package com.gl.employeeManagement.service;

import com.gl.employeeManagement.entity.Role;
import com.gl.employeeManagement.entity.User;

public interface UserService {

	public void saveUser(User user);

	public void saveRole(Role role);
}