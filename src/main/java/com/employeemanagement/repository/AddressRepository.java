package com.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeemanagement.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
