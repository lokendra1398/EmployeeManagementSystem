package com.spring.emp.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.emp.model.Employee;

public interface EmpRepository extends CrudRepository<Employee,Integer> {

	
	public Employee findById(int id);
}
