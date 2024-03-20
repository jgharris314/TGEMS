package com.jgharris314.tgems.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.jgharris314.tgems.employee.enums.EmployeeType;
import com.jgharris314.tgems.models.Account;
import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.services.AccountService;
import com.jgharris314.tgems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    AccountService accountService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee createdEmployee = employeeService.createEmployee(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
