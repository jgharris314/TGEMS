package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jgharris314.tgems.employee.enums.EmployeeType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employeeId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    public Employee() {
    }

    @JsonCreator
    public Employee(
            @JsonProperty("account") Account account,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("employee_type") EmployeeType employeeType
    ) {
        this.account = account;
        this.username = username;
        this.password = password;
        this.employeeType = employeeType;

    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public Account getAccount() {
        return this.account;
    }

    public EmployeeType getEmployeeType() {
        return this.employeeType;
    }

}




