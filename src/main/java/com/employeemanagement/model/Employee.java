package com.employeemanagement.model;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String employee_name;
	private String email;
	private int age;
	private String gender;
	private double salary;
	private long mobile_number;
	private String address;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private Date dateOfJoining;

	public Employee() {
		super();
	}

	public Employee(Integer id, String employee_name, String email, int age, String gender, double salary,
			long mobile_number, String address, Date dateOfJoining) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.mobile_number = mobile_number;
		this.address = address;
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employee_name=" + employee_name + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", salary=" + salary + ", mobile_number=" + mobile_number + ", address="
				+ address + ", dateOfJoining=" + dateOfJoining + "]";
	}

}
