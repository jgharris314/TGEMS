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
    private Integer pitId;

    @Column(name = "pit_name")
    private String pitName;

    @Column(name = "is_open")
    private Boolean isOpen;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "opened_at")
    private Date openedAt;

    @Column(name = "closed_at")
    private Date closedAt;

    public Pit() {
    }

    @JsonCreator
    public Pit(@JsonProperty("pitName") String pitName) {
        this.pitName = pitName;
        this.isOpen = false;
        this.employee = null;
        this.closedAt = null;
        this.openedAt = null;
    }

    public Integer getPitId() {
        return this.pitId;
    }

    public String getPitName() {
        return this.pitName;
    }

    public Boolean getIsOpen() {
        return this.isOpen;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Date getOpenedAt() {
        return this.openedAt;
    }

    public Date getClosedAt() {
        return this.closedAt;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
