package com.glearning.employeemgmt.service;

import java.util.List;

import com.glearning.employeemgmt.entity.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployees();

	String createEmployee(Employee employee);

	Employee findEmployeeById(Long employeeId);

	String updateEmployee(Employee employee);

	String deleteEmployee(Long employeeId);

	List<Employee> searchEmployeesByName(String firstName);

	List<Employee> sortEmployees(String order);

}
