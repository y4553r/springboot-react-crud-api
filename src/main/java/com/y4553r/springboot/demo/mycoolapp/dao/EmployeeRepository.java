package com.y4553r.springboot.demo.mycoolapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.y4553r.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
