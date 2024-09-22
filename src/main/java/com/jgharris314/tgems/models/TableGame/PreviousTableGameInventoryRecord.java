package com.jgharris314.tgems.models.TableGame;

import jakarta.persistence.*;

@Entity
@Table(name = "previous_table_game_inventory_records")
public class PreviousTableGameInventoryRecord extends TableGameInventoryBase {
    @Id
    @Column(name = "previous_table_game_inventory_record_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer previousTableGameInventoryRecordId;

    @Column(name = "table_game_inventory_id")
    private Integer tableGameInventoryId;

    public PreviousTableGameInventoryRecord() {
    }

    public PreviousTableGameInventoryRecord(TableGameInventory tableGameInventory) {
        super(tableGameInventory.getPointFiveDollarChequeCount(),
                tableGameInventory.getOneDollarChequeCount(),
                tableGameInventory.getTwoPointFiveDollarChequeCount(),
                tableGameInventory.getFiveDollarChequeCount(),
                tableGameInventory.getTwentyFiveDollarChequeCount(),
                tableGameInventory.getHundredDollarChequeCount(),
                tableGameInventory.getFiveHundredDollarChequeCount(),
                tableGameInventory.getThousandDollarChequeCount());

        this.tableGameInventoryId = tableGameInventory.getTableGameInventoryId();
    }

    public Integer getPreviousTableGameInventoryRecordId() {
        return this.previousTableGameInventoryRecordId;
    }
}
