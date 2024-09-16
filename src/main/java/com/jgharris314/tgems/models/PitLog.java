package com.jgharris314.tgems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pit_logs")
public class PitLog {
    @Id
    @Column(name = "pit_log_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pit_log_id;

    @Column(name = "employee_id")
    private Integer employee_id;


    @Column(name = "pit_id")
    private Integer pit_id;

    public PitLog() {
    }

    public PitLog(Integer employeeId, Integer pitId, Boolean isOpen) {
        this.employee_id = employeeId;
        this.pit_id = pitId;
    }

    public Integer getEmployeeId() {
        return this.employee_id;
    }

    public Integer getPitId() {
        return this.pit_id;
    }

}
