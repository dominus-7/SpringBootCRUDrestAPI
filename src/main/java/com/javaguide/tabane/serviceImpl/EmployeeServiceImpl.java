package com.javaguide.tabane.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaguide.tabane.entities.Employee;
import com.javaguide.tabane.exception.RessourceNotFoundException;
import com.javaguide.tabane.repositories.EmployeeRepository;
import com.javaguide.tabane.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	

	



	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeById(long id) {
		
		return employeeRepository.findById(id).orElseThrow(()->
									new RessourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		
	
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}


	@Override
	public void deleteById(long id) {
		
		//check wether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
	}

}
