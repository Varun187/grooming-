package com.sakthi.simplerestapi.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import com.sakthi.simplerestapi.entity.Employee;
import com.sakthi.simplerestapi.services.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
// @WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testFindAll() throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("sakthi", "kumar", "sakthi@gmail.com"));
        employees.add(new Employee("abarna", "sri", "abarna@gmail.com"));

        when(employeeService.findAll()).thenReturn(employees);
        
        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employees.length()").value(2));
    }

    @Test
    void testGetEmployee() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(1);
        when(employeeService.findById(1)).thenReturn(employee);

        // Perform the GET request
        mockMvc.perform(get("/api/employees/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("sakthi"));
    }


    @Test
    void testGetEmployeeNotFound() throws Exception {
        when(employeeService.findById(1)).thenReturn(null);

        mockMvc.perform(get("/api/employees/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteEmployee() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(1);
       
        when(employeeService.findById(1)).thenReturn(employee);
        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted employee id - 1"));
    }

    @Test
    void testDeleteEmployeeNotFound() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(1);

        when(employeeService.findById(2)).thenReturn(null);
        mockMvc.perform(delete("/api/employees/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testAddEmployee() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(1);

        when(employeeService.save(employee)).thenReturn(employee);

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"sakthi\", \"lastName\":\"kumar\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("sakthi"));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(1);

        when(employeeService.save(employee)).thenReturn(employee);

        mockMvc.perform(put("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"sakthi\", \"lastName\":\"kumar\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("sakthi"));
    }

   
    @Test
    void testUpdateEmployeeById() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(1);

        when(employeeService.updateById(1, employee)).thenReturn(employee);

        mockMvc.perform(put("/api/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"sakthi\", \"lastName\":\"kumar\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("sakthi"));
    }

    @Test
    void testUpdateEmployeeByIdNotFound() throws Exception {
        Employee employee = new Employee("sakthi", "kumar", "sakthi@gmail.com");
        employee.setId(2);

        when(employeeService.updateById(1, employee)).thenReturn(null);

        mockMvc.perform(put("/api/employees/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"sakthi\", \"lastName\":\"kumar\"}"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResponseStatusException));

    }

}
