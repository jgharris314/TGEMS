package com.jgharris314.tgems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "table_game_logs")
public class TableGameLog {
    @Id
    @Column(name = "table_game_log_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer table_game_log_id;

    @Column(name = "employee_id")
    private Integer employee_id;


    @Column(name = "table_game_id")
    private Integer table_game_id;

    public TableGameLog() {
    }

    public TableGameLog(Integer employeeId, Integer tableGameId, Boolean isOpen) {
        this.employee_id = employeeId;
        this.table_game_id = tableGameId;
    }

    public Integer getEmployeeId() {
        return this.employee_id;
    }

    public Integer getPitId() {
        return this.table_game_id;
    }

}
