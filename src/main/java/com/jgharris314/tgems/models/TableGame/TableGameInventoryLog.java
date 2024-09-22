package com.jgharris314.tgems.models.TableGame;

import com.jgharris314.tgems.enums.TableGameInventoryLogType;
import com.jgharris314.tgems.models.Employee;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "previous_table_game_inventory_record_id")
    PreviousTableGameInventoryRecord previousTableGameInventoryRecord;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_table_game_inventory_record_id")
    UpdatedTableGameInventoryRecord updatedTableGameInventoryRecord;

    @Column(name = "table_game_inventory_id")
    Integer tableGameInventoryId;

    @Column(name = "log_type")
    TableGameInventoryLogType logType;

    @Column(name = "total_adjustment_amount")
    Integer totalAdjustmentAmount;

    public TableGameInventoryLog() {
    }

    public TableGameInventoryLog(Employee employee,
                                 Integer tableGameInventoryId,
                                 Integer totalAdjustmentAmount,
                                 TableGameInventoryLogType logType,
                                 PreviousTableGameInventoryRecord previousTableGameInventoryRecord,
                                 UpdatedTableGameInventoryRecord updatedTableGameInventoryRecord
    ) {
        this.employee = employee;
        this.tableGameInventoryId = tableGameInventoryId;
        this.totalAdjustmentAmount = totalAdjustmentAmount;
        this.logType = logType;
        this.previousTableGameInventoryRecord = previousTableGameInventoryRecord;
        this.updatedTableGameInventoryRecord = updatedTableGameInventoryRecord;

    }
}
