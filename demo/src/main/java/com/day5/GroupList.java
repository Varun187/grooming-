package com.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given a list of Employee objects, group the list based on employee salary

public class GroupList {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Varun", 50000));
        employees.add(new Employee(2, "Visva", 20000));
        employees.add(new Employee(3, "Sudharshan", 75000));
        employees.add(new Employee(4, "Swathi", 50000));

        // Group the employees by salary
        Map<Integer, List<Employee>> groupBy = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));

        for (Map.Entry<Integer, List<Employee>> entry : groupBy.entrySet()) {
            System.out.println("Employees with salary " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
