package com.jgharris314.tgems.models.TableGame;

import jakarta.persistence.*;

@Entity
@Table(name = "updated_table_game_inventory_records")
public class UpdatedTableGameInventoryRecord extends TableGameInventoryBase {
    @Id
    @Column(name = "updated_table_game_inventory_record_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer updatedTableGameInventoryRecordId;

    @Column(name = "table_game_inventory_id")
    private Integer tableGameInventoryId;

    public UpdatedTableGameInventoryRecord() {
    }

    public UpdatedTableGameInventoryRecord(TableGameInventory tableGameInventory) {
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

    public Integer getUpdatedTableGameInventoryRecordId() {
        return this.updatedTableGameInventoryRecordId;
    }
}
