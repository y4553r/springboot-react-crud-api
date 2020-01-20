package com.y4553r.springboot.demo.mycoolapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.y4553r.springboot.demo.mycoolapp.dao.EmployeeRepository;
import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		if(result.isPresent())
			employee = result.get();
		else
			throw new RuntimeException("Did not find employee with the given id!");
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}

}
