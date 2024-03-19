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
    public ResponseEntity<Employee> createEmployee(@RequestBody JsonNode objectNode) {
        JsonNode accountNode = objectNode.get("account");
        JsonNode employeeNode = objectNode.get("employee");

        try {
            Account account = accountService.createAccount(new Account(accountNode.get("first_name").asText(), accountNode.get("last_name").asText()));
            Employee employee = employeeService.createEmployee(new Employee(account, employeeNode.get("username").asText(), employeeNode.get("password").asText(), EmployeeType.supervisor));

            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }
}
