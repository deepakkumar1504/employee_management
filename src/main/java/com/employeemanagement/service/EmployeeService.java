package com.employeemanagement.service;

import com.employeemanagement.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Integer id);
	
}
