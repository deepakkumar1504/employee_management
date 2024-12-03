package com.employeemanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;
import static com.employeemanagement.constant.ApplicationConstants.ROOT_PATH;


@RestController
@RequestMapping(value = ROOT_PATH)
//@RequestMapping(ApplicationConstants.ROOT_PATH)
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	//@PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		logger.info("saving employee");
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}
	
	
	
}
