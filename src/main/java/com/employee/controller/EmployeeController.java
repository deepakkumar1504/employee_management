package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody Employee employee) {
		EmployeeResponse employeeResponse = employeeService.saveEmployee(employee);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.CREATED);
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("employeeId") int id) {
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
	}

}
