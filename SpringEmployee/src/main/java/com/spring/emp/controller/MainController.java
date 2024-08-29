package com.spring.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.emp.Service.EmployeeService;
import com.spring.emp.model.Employee;

@RestController
public class MainController<updateEmployee> {

	

	  @Autowired
	  private EmployeeService service;	
		
		@GetMapping("/Employees")

		public ResponseEntity<List<Employee>> getEmployee() {  
			List<Employee> list1 = this.service.getAllEmployees()       ;
		   if(list1.isEmpty())//y tb chalega jb list emty hogi
		   { return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}  //ye build method hi object create krega
		   
		   return ResponseEntity.of(Optional.of(list1));  //optional use kia h list pass krne k liye or yha bydefault ok status code hga
		   
		}
		
		@GetMapping("/Employees/{id}")
		public ResponseEntity<Employee> getBookbyId(@PathVariable("id") int id){
			
			Employee b =  this.service.findById(id);
		if(b == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		  return ResponseEntity.of(Optional.of(b));
		}
		@PostMapping("/Employees")
		public Employee  addEmployee(@RequestBody Employee emp)  //Request body annnotation ki help se jo data hum postman me bhejenge wo data ye
		//book object me daldenge
		{
			Employee b = this.service.Addemployee(emp);
			System.out.println(emp);
			return b;
			
		}
		
		@DeleteMapping("/Employees/{id}")
	public void deleteBook(@PathVariable("id") int id){
			
			this.service.deleteEmployee(id);
			}
		
		@PutMapping("/Employees/{id}")
		public  Employee updateEmployee(@RequestBody Employee emp1,@PathVariable("id") int id)
		{
			 this.service.updatebook(id,emp1);
			return emp1;
		}
}
