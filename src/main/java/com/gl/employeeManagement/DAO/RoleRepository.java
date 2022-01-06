package com.gl.employeeManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeManagement.entity.*;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}