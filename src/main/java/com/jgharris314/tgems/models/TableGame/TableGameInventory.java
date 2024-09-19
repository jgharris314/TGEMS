package com.jgharris314.tgems.models.TableGame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;


//Create a file with constants for value of a barrel (stack of 20 cheques)
@Entity
@Table(name = "table_game_inventories")
public class TableGameInventory extends TableGameInventoryBase {
    @Id
    @Column(name = "table_game_inventory_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer tableGameInventoryId;


    public TableGameInventory() {
    }

    @JsonCreator
    public TableGameInventory(@JsonProperty("pointFiveDollarChequeCount") Integer pointFiveDollarChequeCount,
                              @JsonProperty("oneDollarChequeCount") Integer oneDollarChequeCount,
                              @JsonProperty("twoPointFiveDollarChequeCount") Integer twoPointFiveDollarChequeCount,
                              @JsonProperty("fiveDollarChequeCount") Integer fiveDollarChequeCount,
                              @JsonProperty("twentyFiveDollarChequeCount") Integer twentyFiveDollarChequeCount,
                              @JsonProperty("hundredDollarChequeCount") Integer hundredDollarChequeCount,
                              @JsonProperty("fiveHundredDollarChequeCount") Integer fiveHundredDollarChequeCount,
                              @JsonProperty("thousandDollarChequeCount") Integer thousandDollarChequeCount) {
        super(pointFiveDollarChequeCount,
                oneDollarChequeCount,
                twoPointFiveDollarChequeCount,
                fiveDollarChequeCount,
                twentyFiveDollarChequeCount,
                hundredDollarChequeCount,
                fiveHundredDollarChequeCount,
                thousandDollarChequeCount);
    }

    public Integer getTableGameInventoryId() {
        return tableGameInventoryId;
    }
}
