package com.glearning.employeemgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeemgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByFirstName(String firstName);
}
