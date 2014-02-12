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
		employee.setEmail("test1@gmail.com");
		employee.setName("test1");
		employee.setPhone("22551");
		employee.setPlace("bgr1");
		employee.setState("karnataka1");
		employee.setStatus("Active1");
		
		employeeRepo.save(employee);
	}

}
