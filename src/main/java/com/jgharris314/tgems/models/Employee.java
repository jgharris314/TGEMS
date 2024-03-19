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
    private Integer employee_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "employee_type")
    private Enum<EmployeeType> employee_type;

    public Employee() {
    }

    @JsonCreator
    public Employee(
            @JsonProperty("account") Account account,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("employee_type") Enum<EmployeeType> employee_type
    ) {
        this.account = account;
        this.username = username;
        this.password = password;
        this.employee_type = employee_type;

    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    public Account getAccount() {
        return this.account;
    }

    public Enum<EmployeeType> getEmployeeType() {
        return this.employee_type;
    }
}




