package com.sakthi.simplerestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sakthi.simplerestapi.entity.Employee;
import com.sakthi.simplerestapi.entity.EmployeeResourceModel;
import com.sakthi.simplerestapi.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping(value = "/employees", produces = { "application/hal+json" })
    public ResponseEntity<EmployeeResourceModel> findAll() {
        EmployeeResourceModel employeeList = new EmployeeResourceModel();
        List<Employee> employeeListDB = employeeService.findAll();

        for (Employee employee : employeeListDB) {
            Link link = linkTo(methodOn(EmployeeController.class).getEmployee(employee.getId()))
                    .withSelfRel();
            employee.add(link);
            employeeList.getEmployees().add(employee);
        }

        Link selfLink = linkTo(methodOn(EmployeeController.class).findAll())
                .withSelfRel();
        employeeList.add(selfLink);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee id not found - " + employeeId);
        }

        Link selfLink = linkTo(methodOn(EmployeeController.class).getEmployee(employeeId))
                .withSelfRel();
        theEmployee.add(selfLink);
        return ResponseEntity.status(HttpStatus.OK).body(theEmployee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        Link selfLink = linkTo(methodOn(EmployeeController.class).addEmployee(theEmployee))
                .withSelfRel();
        dbEmployee.add(selfLink);
        return ResponseEntity.status(HttpStatus.OK).body(dbEmployee);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);
        Link selfLink = linkTo(methodOn(EmployeeController.class).updateEmployee(theEmployee))
                .withSelfRel();
        dbEmployee.add(selfLink);
        return ResponseEntity.status(HttpStatus.OK).body(dbEmployee);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int employeeId, @RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.updateById(employeeId, theEmployee);
        Link selfLink = linkTo(methodOn(EmployeeController.class).updateEmployeeById(employeeId, theEmployee))
                .withSelfRel();
        dbEmployee.add(selfLink);
        return ResponseEntity.status(HttpStatus.OK).body(dbEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted employee id - " + employeeId);
    }

}