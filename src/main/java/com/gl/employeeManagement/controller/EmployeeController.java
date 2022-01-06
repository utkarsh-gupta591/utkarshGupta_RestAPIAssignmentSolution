package com.gl.employeeManagement.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;

import com.gl.employeeManagement.entity.*;
import com.gl.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee id is not found - " + employeeId);
		}
		return employee;
	}

	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		tempEmployee.setFirstName(employee.getFirstName());
		tempEmployee.setLastName(employee.getLastName());
		tempEmployee.setEmail(employee.getEmail());

		employeeService.save(tempEmployee);

		employee.setId(employeeId);
		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);

		if (tempEmployee == null)
			throw new RuntimeException("Exception id not found - " + employeeId);

		employeeService.deleteById(employeeId);
		return "Deleted employee id - " + employeeId;
	}

	@GetMapping("/employees/search/{employeeName}")
	public List<Employee> searchEmployee(@PathVariable String employeeName) {
		List<Employee> employees = employeeService.findByFirstName(employeeName);

		return employees;
	}

	@GetMapping("/employees/sort")
	public List<Employee> getEmployeesSortedByFirstName(String order) {
		Direction direction = Direction.ASC;
		if (order.equals("desc"))
			direction = Direction.DESC;
		List<Employee> employees = employeeService.getEmployeesSortedByFirstName(direction);

		return employees;
	}
}