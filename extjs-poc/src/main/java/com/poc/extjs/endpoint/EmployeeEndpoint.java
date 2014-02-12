package com.poc.extjs.endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.extjs.dto.EmployeeDTO;


@Controller("employeeController")
public class EmployeeEndpoint {
	
	/*@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<EmployeeDTO>> listEmployees(){
		List<EmployeeDTO>  employees = new ArrayList<EmployeeDTO>();
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmail("ajil@test.com");
		emp.setEmployeeId(9888L);
		emp.setName("ajil");
		emp.setPlace("thrissur");
		emp.setPhone("568974123");
		emp.setState("kerala");
		emp.setStatus("Act");
		employees.add(emp);
		emp = new EmployeeDTO();
		emp.setEmail("jay@test.com");
		emp.setEmployeeId(9888L);
		emp.setName("jay");
		emp.setPlace("thrissur");
		emp.setPhone("568974123");
		emp.setState("kerala");
		emp.setStatus("Act");
		employees.add(emp);
        return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, List<EmployeeDTO>>> listEmployees(){
		List<EmployeeDTO>  employees = new ArrayList<EmployeeDTO>();
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmail("ajil@test.com");
		emp.setEmployeeId(9888L);
		emp.setName("ajil");
		emp.setPlace("thrissur");
		emp.setPhone("568974123");
		emp.setState("kerala");
		emp.setStatus("Act");
		employees.add(emp);
		emp = new EmployeeDTO();
		emp.setEmail("jay@test.com");
		emp.setEmployeeId(9889L);
		emp.setName("jay");
		emp.setPlace("thrissur");
		emp.setPhone("568974123");
		emp.setState("kerala");
		emp.setStatus("Act");
		employees.add(emp);
		Map<String, List<EmployeeDTO>> empMap = new HashMap<String, List<EmployeeDTO>>();
		empMap.put("employees", employees);
        return new ResponseEntity<Map<String,List<EmployeeDTO>>>(empMap, HttpStatus.OK);
	}
			

}
