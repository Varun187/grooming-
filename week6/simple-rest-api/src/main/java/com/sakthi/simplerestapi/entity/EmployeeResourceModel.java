package com.sakthi.simplerestapi.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmployeeResourceModel extends RepresentationModel<EmployeeResourceModel> {

    private List<Employee> employees = new ArrayList<Employee>();

    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
