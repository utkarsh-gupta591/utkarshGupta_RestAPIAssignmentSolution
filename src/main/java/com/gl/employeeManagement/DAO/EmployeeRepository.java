package com.gl.employeeManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeManagement.entity.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}