package com.springBootTutorial.tutorial;

import org.junit.jupiter.api.Test;

import com.springBootTutorial.tutorial.employee.Employee;
import com.springBootTutorial.tutorial.person.Person;

import org.junit.jupiter.api.Assertions;

public class EmployeeClassTest {

	// CLASS ATTS
	Integer employeeId = 9999999;
	String position = "banker";
	Integer testId = 9999999;
	
	@Test 
	void CreateEmployee() throws Exception {
		Person testPerson = new Person(testId);
		testPerson.autoFillForTest();
		Employee testEmployee = new Employee(employeeId,testPerson,position);
		Assertions.assertTrue(testEmployee instanceof Object);
	}
}

