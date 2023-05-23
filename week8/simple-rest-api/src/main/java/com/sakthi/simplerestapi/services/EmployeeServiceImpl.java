package com.sakthi.simplerestapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sakthi.simplerestapi.entity.Employee;
import com.sakthi.simplerestapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public Employee updateById(int theId ,Employee theEmployee){

    return employeeRepository.findById(theId)
            .map(employee -> {
                employee.setFirstName(theEmployee.getFirstName());
                employee.setLastName(theEmployee.getLastName());
                employee.setEmail(theEmployee.getEmail());
                return employeeRepository.save(theEmployee);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Did not find employee id - " + theId));
        }
}
