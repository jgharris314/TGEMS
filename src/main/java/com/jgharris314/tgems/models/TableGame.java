package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "table_games")
public class TableGame {
    @Id
    @Column(name = "table_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer table_game_id;

    @Column(name = "table_name")
    private String table_game_name;

    @Column(name = "is_open")
    private Boolean is_open;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "closed_at")
    private Date closed_at;

    public TableGame() {
    }

    @JsonCreator
    public TableGame(@JsonProperty("table_game_name") String table_game_name) {
        this.table_game_name = table_game_name;
        this.is_open = false;
        this.employee = null;
        this.closed_at = null;
    }

    public Integer getTableGameId() {
        return this.table_game_id;
    }

    public String getTableGameName() {
        return this.table_game_name;
    }

    public Boolean getIsOpen() {
        return this.is_open;
    }

    public Employee getEmployee() {
        return this.employee;
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
