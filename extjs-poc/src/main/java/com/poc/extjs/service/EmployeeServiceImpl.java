package com.poc.extjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.extjs.domain.Employee;
import com.poc.extjs.proxy.EmployeeService;
import com.poc.extjs.repository.EmployeeRepo;

@Service("EmployeeServiceImpl")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee save(Employee entity) {
		return employeeRepo.save(entity);
	}

	public void delete(long employeeID) {
		employeeRepo.delete(employeeID);
	}

	public void deleteAll() {
		employeeRepo.deleteAll();
	}

	public Employee findOne(long employeeID) {
		return employeeRepo.findOne(employeeID);
	}

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

}
