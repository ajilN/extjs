package com.poc.extjs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.extjs.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
