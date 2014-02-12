package com.poc.extjs.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.poc.extjs.domain.Employee;

public class EmployeeRepoTest extends RepoTestBase{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCreate(){
		
		Employee employee = new Employee();
		employee.setEmail("test@gmail.com");
		employee.setName("test");
		employee.setPhone("2255");
		employee.setPlace("bgr");
		employee.setState("karnataka");
		employee.setStatus("Active");
		
		employeeRepo.save(employee);
	}

}
