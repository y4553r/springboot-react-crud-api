package com.y4553r.springboot.demo.mycoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(long id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(long id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
