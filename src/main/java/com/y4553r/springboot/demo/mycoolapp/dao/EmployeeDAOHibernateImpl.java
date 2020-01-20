package com.y4553r.springboot.demo.mycoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.y4553r.springboot.demo.mycoolapp.Exceptions.NoEmployeeWithProvidedIdFound;
import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		try {
//			Query<Employee> query = currentSession.createQuery("from Employee E where E.id = " + id, Employee.class);
//			Employee employee = query.getSingleResult();
			Employee employee = currentSession.get(Employee.class, id);
		return employee;
		} catch(NoResultException e) {
			throw new NoEmployeeWithProvidedIdFound("No employee with the provided id was found!");
		}
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
