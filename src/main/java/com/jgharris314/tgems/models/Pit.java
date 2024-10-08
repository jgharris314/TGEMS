package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pits")
public class Pit {
    @Id
    @Column(name = "pit_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer pit_id;

    @Column(name = "pit_name")
    private String pit_name;

    @Column(name = "is_open")
    private Boolean is_open;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "opened_at")
    private Date opened_at;

    @Column(name = "closed_at")
    private Date closed_at;

    public Pit() {
    }

    @JsonCreator
    public Pit(@JsonProperty("pit_name") String pit_name) {
        this.pit_name = pit_name;
        this.is_open = false;
        this.employee = null;
        this.closed_at = null;
    }

    public Integer getPitId() {
        return this.pit_id;
    }

    public String getPitName() {
        return this.pit_name;
    }

    public Boolean getIsOpen() {
        return this.is_open;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Date getOpenedAt() {
        return this.opened_at;
    }

    public Date getClosedAt() {
        return this.closed_at;
    }

    public void setIsOpen(Boolean is_open) {
        this.is_open = is_open;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
