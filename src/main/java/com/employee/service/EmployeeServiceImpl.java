package com.employee.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeResponse saveEmployee(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		Employee response = employeeRepository.save(employee);
		modelMapper.map(response, employeeResponse);
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployeeById(int id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		Optional<Employee> recordFetchFromDb = employeeRepository.findById(id);
		if (recordFetchFromDb.isPresent()) {
			Employee employee = recordFetchFromDb.get();
			modelMapper.map(employee, employeeResponse);
		} else {
			System.out.println("Not found");
		}
		return employeeResponse;
	}

}
