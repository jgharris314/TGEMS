package com.jgharris314.tgems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "table_game_logs")
public class TableGameLog {
    @Id
    @Column(name = "table_game_log_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tableGameLogId;

    @Column(name = "employee_id")
    private Integer employeeId;


    @Column(name = "table_game_id")
    private Integer tableGameId;

    public TableGameLog() {
    }

    public TableGameLog(Integer employeeId, Integer tableGameId, Boolean isOpen) {
        this.employeeId = employeeId;
        this.tableGameId = tableGameId;
    }

//    public Integer getEmployeeId() {
//        return this.employeeId;
//    }
//
//    public Integer getPitId() {
//        return this.tableGameId;
//    }

}
