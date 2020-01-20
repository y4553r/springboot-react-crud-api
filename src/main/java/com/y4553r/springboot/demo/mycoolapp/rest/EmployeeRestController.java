package com.y4553r.springboot.demo.mycoolapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable long employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee == null)
			throw new RuntimeException("No employee with the provided id was found!");
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable long id) {
		Employee employee = employeeService.findById(id);
		if(employee == null)
			throw new RuntimeException("No employee with the provided id was found!");
		employeeService.deleteById(id);
		return "Deleted employee " + employee.getFirstName() + " " + employee.getLastName() + " with id " + id + ".";
	}

}
