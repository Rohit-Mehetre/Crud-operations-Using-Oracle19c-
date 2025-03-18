package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByFirstName(String name);

}

