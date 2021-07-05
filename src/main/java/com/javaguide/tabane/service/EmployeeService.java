package com.javaguide.tabane.service;

import java.util.List;

import com.javaguide.tabane.entities.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteById(long id);

}
