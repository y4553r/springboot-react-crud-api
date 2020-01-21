package com.y4553r.springboot.demo.mycoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.y4553r.springboot.demo.mycoolapp.dao.EmployeeRepository;
import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/list")
	public String renderEmployeesList(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeslist";
	}
	
	@GetMapping("/formForAdd") 
	public String renderFormForAdd(Model model) {
		// create a model attribute to bid form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employeeForm";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/formForEdit/{id}")
	public String renderFormForEdit(Model model, @PathVariable("id") long id) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		return "employees/employeeForm";
	}
	
	@PostMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable long id) {
		employeeRepository.deleteById(id);
		return "redirect:/employees/list";
	}
	
}
