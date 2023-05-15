package com.sakthi.simplerestapi.services;

import java.util.List;

import com.sakthi.simplerestapi.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

    Employee updateById(int theId ,Employee theEmployee);

}