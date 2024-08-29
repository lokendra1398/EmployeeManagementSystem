package com.spring.emp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.dao.EmpRepository;
import com.spring.emp.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepository  repo; 
	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> l=   (List<Employee>)this.repo.findAll();
return l;}
	

	

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Employee e1=null;
		try {
			e1=this.repo.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return e1;
	}



	public Employee Addemployee(Employee emp) {
		Employee res = this.repo.save(emp);
	     return res;
	}




	public void deleteEmployee(int id) {
	
		this.repo.deleteById(id);
	}




	public void updatebook(int id, Employee emp1) {
		// TODO Auto-generated method stub
		
		emp1.setId(id);
		this.repo.save(emp1);
	}




	
}
