package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of Employee objects, sort the list based on employee salary? Assume Employee class having id, name, salary fields.
public class SortBySalary {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "vikas", 300_000);
        Employee emp2 = new Employee(2, "druv", 700_000);
        Employee emp3 = new Employee(3, "ram", 1_000_000);
        Employee emp4 = new Employee(4, "priya", 500_000);

        List<Employee> empList = List.of(emp1, emp2, emp3, emp4);

        empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}