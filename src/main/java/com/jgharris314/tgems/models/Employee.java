package com.jgharris314.tgems.models;

import com.jgharris314.tgems.employee.enums.EmployeeType;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Employee {

    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID account_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "account_id")
    private Account account;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private  String password;

    @Column(name="start_date")
    private Date start_date;

    @Column(name="end_date")
    private  Date end_date;

    @Column(name="employee_type")
    private  Enum<EmployeeType> employee_type;
}
