package com.crud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Employee;
import com.crud.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return service.saveEmployee(employee);
	}
	
	@PostMapping("/addEmployees")
	public List<Employee> addEmployee(@RequestBody List<Employee> employee)
	{
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/Employees")
	public List<Employee> findEmployee()
	{
		System.out.println("Get Called");
	   return service.getEmployee();
	}
	
	@GetMapping("/EmployeeById/{id}")
	public Employee findEmployeeByEmpId(@PathVariable int id)
	{
		return service.getEmpById(id);
	}
	
	@GetMapping("/Employee/{firstName}")
	public Employee findEmployeeByFirstName(@RequestBody String Name)
	{
		return service.getEmployeeByFirstName(Name);
	}
	
	@PutMapping("/Update")
	public Employee updateEmployee(@RequestBody Employee employee)
	{	
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{empId}")
	public String DeleteEmployeeById(@PathVariable int empId)
	{
		return service.deleteEmployee(empId);
	}
}
