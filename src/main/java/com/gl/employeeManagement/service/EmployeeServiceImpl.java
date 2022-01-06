package com.gl.employeeManagement.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.employeeManagement.DAO.*;
import com.gl.employeeManagement.entity.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("");
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByFirstName(String employeeName) {
		List<Employee> employees = employeeRepository.findAll();
		List<Employee> filteredList = new LinkedList<Employee>();
		for (Employee employee : employees) {
			if (employee.getFirstName().equalsIgnoreCase(employeeName)) {
				filteredList.add(employee);
			}
		}
		return filteredList;
	}

	@Override
	public List<Employee> getEmployeesSortedByFirstName(Direction direction) {
		List<Employee> employees = employeeRepository.findAll(Sort.by(direction, "firstName"));
		return employees;
	}
}