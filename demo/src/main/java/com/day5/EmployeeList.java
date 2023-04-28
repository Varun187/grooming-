package com.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Given a list of Employee objects, sort the list based on employee salary.

public class EmployeeList {
    public static void main(String[] args) {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee(1, "Varun", 56000));
        employee.add(new Employee(2, "Visva", 70000));
        employee.add(new Employee(3, "Dhanusha", 20000));
        employee.add(new Employee(4, "Sudharshan", 14000));

        // Sort the list based on employee salary using a lambda expression
        // Collections.sort(employee, (e1, e2) -> e1.getSalary() - e2.getSalary());

        List<Employee> sortedEmployees = employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        // Print the sorted list
        sortedEmployees.forEach(System.out::println);

    }

}
