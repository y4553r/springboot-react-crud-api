package com.y4553r.springboot.demo.mycoolapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y4553r.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(long id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		employeeDAO.deleteById(id);
	}

}
