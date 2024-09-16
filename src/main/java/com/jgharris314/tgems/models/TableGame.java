package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "table_games")
public class TableGame {
    @Id
    @Column(name = "table_game_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer tableGameId;

    @Column(name = "table_game_name")
    private String tableGameName;

    @Column(name = "is_open")
    private Boolean isOpen;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_game_inventory_id")
    private TableGameInventory tableGameInventory;

    @Column(name = "opened_at")
    private Date openedAt;
    @Column(name = "closed_at")
    private Date closedAt;

    public TableGame() {

    }

    @JsonCreator
    public TableGame(@JsonProperty("tableGameName") String tableGameName, @JsonProperty("tableGameInventory") TableGameInventory tableGameInventory) {
        this.tableGameName = tableGameName;
        this.tableGameInventory = tableGameInventory;
        this.isOpen = false;
        this.employee = null;
        this.openedAt = null;
        this.closedAt = null;
    }

    public Integer getTableGameId() {
        return this.tableGameId;
    }

    public String getTableGameName() {
        return this.tableGameName;
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

    public TableGameInventory getTableGameInventory() {
        return this.tableGameInventory;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
