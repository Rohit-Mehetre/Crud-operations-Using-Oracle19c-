package com.crud.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.Employee;
import com.crud.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee)
	{
		return repository.save(employee);
	}
	 
	public List<Employee> saveEmployee(List<Employee> employee)
	{
		return repository.saveAll(employee);
	}
	
	public List<Employee> getEmployee()
	{
		return repository.findAll();	
	}
	
	public Employee getEmpById (int empId)
   {
	   return repository.findById(empId).orElse(null);
   }

	public Employee getEmployeeByFirstName(String Name)
	{
		System.out.println(" First Name " +Name);
		return repository.findByFirstName(Name);
	}
	
	public String deleteEmployee(int id)
	{
	     	repository.deleteById(id);
	     	return "Employee Removed " +id;
	}
	
	public Employee updateEmployee(Employee employee)
	{
		Employee existingEmployee = repository.findById(employee.getEmpId()).orElse(null);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		return repository.save(existingEmployee);
	}
	
	
}
