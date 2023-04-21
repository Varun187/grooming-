package com.example.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

public class GroupList {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "A", 50000));
        employees.add(new Employee(2, "B", 20000));
        employees.add(new Employee(3, "C", 75000));
        employees.add(new Employee(4, "D", 50000));

        // Group the employees by salary
        Map<Integer, List<Employee>> groupBy = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));

        for (Map.Entry<Integer, List<Employee>> entry : groupBy.entrySet()) {
            System.out.println("Salary " + entry.getKey() + ": " + entry.getValue());
        }

        Collections.sort(employees, Comparator.comparing(Employee::getSalary));

        // Sort the list based on employee salary using a lambda expression
        Collections.sort(employees, (e1, e2) -> e1.getSalary() - e2.getSalary());

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
