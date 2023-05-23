package com.sakthi.simplerestapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import com.sakthi.simplerestapi.entity.Employee;
import com.sakthi.simplerestapi.repository.EmployeeRepository;

class EmployeeServiceImplTest {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void testFindAll() {
        List<Employee> expectedEmployees = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> actualEmployees = employeeService.findAll();

        assertEquals(expectedEmployees, actualEmployees);
        verify(employeeRepository).findAll();
    }

    @Test
    void testFindByIdExistingIdReturnsEmployee() {
        int id = 1;
        Employee expectedEmployee = new Employee();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(expectedEmployee));
        Employee actualEmployee = employeeService.findById(id);
        assertEquals(expectedEmployee, actualEmployee);
        verify(employeeRepository).findById(id);
    }

    @Test
    void testFindByIdNonExistingIdThrowsException() {
        int id = 1;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> employeeService.findById(id));
        verify(employeeRepository).findById(id);
    }

    @Test
    void testSave() {
        Employee employee = new Employee();
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.save(employee);

        assertEquals(employee, savedEmployee);
        verify(employeeRepository).save(employee);
    }

    @Test
    void testDeleteById() {
        int id = 1;
        employeeService.deleteById(id);
        verify(employeeRepository).deleteById(id);
    }

    @Test
    void testUpdateByIdExistingIdReturnsUpdatedEmployee() {
        int id = 1;
        Employee existingEmployee = new Employee();
        Employee updatedEmployee = new Employee();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(existingEmployee));
        when(employeeRepository.save(existingEmployee)).thenReturn(updatedEmployee);

        Employee actualEmployee = employeeService.updateById(id, existingEmployee);

        assertEquals(updatedEmployee, actualEmployee);
        verify(employeeRepository).findById(id);
        verify(employeeRepository).save(existingEmployee);
    }

    @Test
    void testUpdateByIdNonExistingIdThrowsException() {
        int id = 1;
        Employee employee = new Employee();
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> employeeService.updateById(id, employee));
        verify(employeeRepository).findById(id);
    }
    
}
