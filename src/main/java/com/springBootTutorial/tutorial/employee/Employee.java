package com.springBootTutorial.tutorial.employee;

import java.util.Arrays;
import java.util.List;

import com.springBootTutorial.tutorial.person.Person;

public class Employee {

	// EMPLOYEE ATTS
	public Integer employeeId;
	public Person person;
	public String position;

	String[] positions = {"director","loan officer","banker","atm"};
	
	public Employee(Integer employeeId, Person person, String position) throws Exception {
		this.employeeId = employeeId;
		this.person = person;
		List<String> listOfPositions = Arrays.asList(positions);
		if (!listOfPositions.contains(position)) {
			throw new Exception("An exception occurred: Position in Employee Class is incorrect, must be a valid entry");
		}
		this.position = position;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
