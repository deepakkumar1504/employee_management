package com.employeemanagement.controller;

import com.employeemanagement.exception.ApiError;
import com.employeemanagement.exception.ApiRuntimeException;
import com.employeemanagement.exception.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("employee/v1")
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/loggerTest")
	public String getLogger() {
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		// trace->debug->info->warn->error
		return "Getting response from getLogger";
	}

	@GetMapping(path = "/get-employee")
	public String getEmployee() {
		System.out.println("In get employee method");
		throw  ApiRuntimeException.badRequest(new ApiError(ErrorMessages.HTTP_MESSAGE_NOT_READABLE));
	}

	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		logger.info("saving employee");
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}

}
