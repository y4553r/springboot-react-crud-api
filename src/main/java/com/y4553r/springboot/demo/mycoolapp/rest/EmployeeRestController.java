package com.y4553r.springboot.demo.mycoolapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.y4553r.springboot.demo.mycoolapp.entity.Employee;
import com.y4553r.springboot.demo.mycoolapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee finById(@PathVariable long id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("/employees")
	public void save(@RequestBody Employee employee) {
		employeeService.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable long id) {
		employeeService.deleteById(id);
	}

}
