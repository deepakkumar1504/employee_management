package com.employee.service;

import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;

public interface EmployeeService {
	EmployeeResponse saveEmployee(Employee employee);
	EmployeeResponse getEmployeeById(int id);
	
}
