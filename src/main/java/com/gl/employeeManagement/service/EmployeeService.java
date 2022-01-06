package com.gl.employeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.employeeManagement.entity.*;

public interface EmployeeService {

	public List<Employee> findAll();

	public void save(Employee employee);

	public Employee findById(int id);

	public void deleteById(int id);

	public List<Employee> findByFirstName(String employeeName);

	public List<Employee> getEmployeesSortedByFirstName(Direction direction);
}