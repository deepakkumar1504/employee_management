package com.employeemanagement.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employee = new Employee();
		Optional<Employee> recordFetchFromDb = employeeRepository.findById(id);
		if (recordFetchFromDb.isPresent()) {
			employee = recordFetchFromDb.get();
		} else {
			logger.info("Not found");
		}
		return employee;
	}

}
