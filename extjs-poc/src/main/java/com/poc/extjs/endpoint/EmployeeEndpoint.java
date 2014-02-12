package com.poc.extjs.endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.extjs.domain.Employee;
import com.poc.extjs.dto.EmployeeDTO;
import com.poc.extjs.proxy.EmployeeService;


@Controller("employeeController")
public class EmployeeEndpoint {
	
	@Autowired
	private EmployeeService employeeService;
	
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
	/*	EmployeeDTO emp = new EmployeeDTO();
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
		employees.add(emp);*/
		
		employees = this.getEmployeeDtos(employeeService.findAll());
		Map<String, List<EmployeeDTO>> empMap = new HashMap<String, List<EmployeeDTO>>();
		empMap.put("employees", employees);
        return new ResponseEntity<Map<String,List<EmployeeDTO>>>(empMap, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/employee/save", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Mapper mapper = new DozerBeanMapper();
        Employee employee = mapper.map(employeeDTO, Employee.class);
        Employee savedEmp = null;
        savedEmp = employeeService.save(employee);
        if ( savedEmp != null)
            {
        	 mapper = new DozerBeanMapper();
        	 employeeDTO = mapper.map(savedEmp, EmployeeDTO.class);
            return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
            }
        else
            return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.BAD_REQUEST);

    }
	
	private List<EmployeeDTO> getEmployeeDtos(List<Employee> employees){
		List<EmployeeDTO> employeeDTOs  = new ArrayList<EmployeeDTO>();
		EmployeeDTO empDTO = null;
		for(Employee employee : employees){
			empDTO = new EmployeeDTO();
			empDTO.setEmail(employee.getEmail());
			empDTO.setName(employee.getName());
			empDTO.setEmployeeId(employee.getEmployeeId());
			empDTO.setPhone(employee.getPhone());
			empDTO.setPlace(employee.getPhone());
			empDTO.setState(employee.getState());
			empDTO.setStatus(employee.getStatus());
			employeeDTOs.add(empDTO);
		}
		return employeeDTOs;
	}

}
