package com.sakthi.simplerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakthi.simplerestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
