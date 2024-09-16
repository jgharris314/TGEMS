package com.jgharris314.tgems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pit_logs")
public class PitLog {
    @Id
    @Column(name = "pit_log_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pitLogId;

    @Column(name = "employee_id")
    private Integer employeeId;
    
    @Column(name = "pit_id")
    private Integer pitId;

    public PitLog() {
    }

    public PitLog(Integer employeeId, Integer pitId, Boolean isOpen) {
        this.employeeId = employeeId;
        this.pitId = pitId;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public Integer getPitId() {
        return this.pitId;
    }

}
