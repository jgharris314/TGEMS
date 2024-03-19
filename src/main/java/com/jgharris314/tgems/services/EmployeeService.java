package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(
                new Employee(
                        employee.getAccount(),
                        employee.getUsername(),
                        employee.getPassword(),
                        employee.getEmployeeType()
                )
        );
    }
}
