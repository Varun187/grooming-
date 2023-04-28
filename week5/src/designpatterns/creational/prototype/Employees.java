package designpatterns.creational.prototype;

import java.util.ArrayList;

public class Employees implements Cloneable {
    private ArrayList<String> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void loadData() {
        // Loads employees data from 3-4 sources which are super heavy operations
        this.employees.add("Ram");
        this.employees.add("Shiva");
        this.employees.add("ajay");
        this.employees.add("vignesh");
    }

    // Cloneable overridden method

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ArrayList<String> clonedEmployeeList = new ArrayList<>();
        for (int i = 0; i < this.employees.size(); i++) {
            clonedEmployeeList.add(this.employees.get(i));
        }
        Employees clonedEmployees = new Employees();
        clonedEmployees.employees = clonedEmployeeList;
        return clonedEmployees;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}
