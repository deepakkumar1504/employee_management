package com.employeemanagement.service;

import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            throw new RuntimeException("throw exception");
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return employeeRepository.save(employee);
    }

}
