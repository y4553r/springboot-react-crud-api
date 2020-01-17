package com.y4553r.springboot.demo.mycoolapp.dao;

import java.util.List;

import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
}
