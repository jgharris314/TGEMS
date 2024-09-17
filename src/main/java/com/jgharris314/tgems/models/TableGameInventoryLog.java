package com.jgharris314.tgems.models;

import com.jgharris314.tgems.enums.TableGameInventoryLogType;
import jakarta.persistence.*;

@Entity
@Table(name = "table_game_inventory_logs")
public class TableGameInventoryLog {
    @Id
    @Column(name = "table_game_inventory_log_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer tableGameInventoryLogId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_game_inventory_id")
    TableGameInventory tableGameInventory;

    @Column(name = "log_type")
    TableGameInventoryLogType tableGameInventoryLogType;

    @Column(name = "total_adjustment_amount")
    Integer totalAdjustmentAmount;

    public TableGameInventoryLog() {
    }

    public TableGameInventoryLog(Integer employeeId, Integer tableGameInventoryId, Integer totalAdjustmentAmount, String logType) {

    }
}
