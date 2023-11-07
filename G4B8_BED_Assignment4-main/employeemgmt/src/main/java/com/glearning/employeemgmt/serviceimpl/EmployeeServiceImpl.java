package com.glearning.employeemgmt.serviceimpl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.glearning.employeemgmt.entity.Employee;
import com.glearning.employeemgmt.repository.EmployeeRepository;
import com.glearning.employeemgmt.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee created";
	}

	@Override
	public Employee findEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		return employee;
	}

	@Override
	public String updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee with id " + employee.getId() + " updated";
	}

	@Override
	public String deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee with id " + employeeId + " deleted";
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstName) {
		List<Employee> employees = employeeRepository.findByFirstName(firstName);
		return employees;
	}

	@Override
	public List<Employee> sortEmployees(String order) {
		if (order.equals("asc")) {
			return employeeRepository.findAll(Sort.by(Direction.ASC, "firstName"));
		} else if (order.equals("desc")) {
			return employeeRepository.findAll(Sort.by(Direction.DESC, "firstName"));
		} else {
			return null;
		}
	}

}
