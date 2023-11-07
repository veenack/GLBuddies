package com.glearning.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employeemgmt.entity.Employee;
import com.glearning.employeemgmt.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "List Employees", notes = "API to get all available Employees")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@ApiOperation(value = "Get an Employee", notes = "Get an Employee by ID")
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") long employeeId) {
		return employeeService.findEmployeeById(employeeId);
	}

	@ApiOperation(value = "Create Employee", notes = "API to create an Employee")
	@PostMapping("/employees/create")
	public String createEmployee(Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@ApiOperation(value = "Update Employee", notes = "API to update an Employee")
	@PostMapping("/employees/update")
	public String updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@ApiOperation(value = "Delete Employee", notes = "API to delete an Employee by ID")
	@DeleteMapping("/employees/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	@ApiOperation(value = "Get employee by name", notes = "Get an Employee details by his/her firstname")
	@PostMapping("employees/search/{firstName}")
	public List<Employee> getEmployeesByFirstName(@PathVariable("firstName") String firstName) {
		return employeeService.searchEmployeesByName(firstName);
	}

	@ApiOperation(value = "Sort Employees", notes = "Sort the employees by their firstname in either ASC or DESC order.")
	@GetMapping("employees/sort")
	public List<Employee> getEmployeeSortedByName(@RequestParam String order) {
		return employeeService.sortEmployees(order);
	}

}
