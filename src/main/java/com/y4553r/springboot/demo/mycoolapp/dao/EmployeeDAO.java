package com.y4553r.springboot.demo.mycoolapp.dao;

import java.util.List;

import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(long id);
	
	public void save(Employee employee);
	
	public void deleteById(long id);
	
}
