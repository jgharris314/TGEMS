package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;


//Create a file with constants for value of a barrel (stack of 20 cheques)
@Entity
@Table(name = "table_game_inventories")
public class TableGameInventory {
    @Id
    @Column(name = "table_game_inventory_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer tableGameInventoryId;

    @Column(name = "point_five_dollar_cheque_count")
    private Integer pointFiveDollarChequeCount;

    @Column(name = "one_dollar_cheque_count")
    private Integer oneDollarChequeCount;

    @Column(name = "two_point_five_dollar_cheque_count")
    private Integer twoPointFiveDollarChequeCount;


    @Column(name = "five_dollar_cheque_count")
    private Integer fiveDollarChequeCount;

    @Column(name = "twenty_five_dollar_cheque_count")
    private Integer twentyFiveDollarChequeCount;

    @Column(name = "hundred_dollar_cheque_count")
    private Integer hundredDollarChequeCount;

    @Column(name = "fiveHundred_dollar_cheque_count")
    private Integer fiveHundredDollarChequeCount;

    @Column(name = "thousand_dollar_cheque_count")
    private Integer thousandDollarChequeCount;


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
        this.pointFiveDollarChequeCount = pointFiveDollarChequeCount;
        this.oneDollarChequeCount = oneDollarChequeCount;
        this.twoPointFiveDollarChequeCount = twoPointFiveDollarChequeCount;
        this.fiveDollarChequeCount = fiveDollarChequeCount;
        this.twentyFiveDollarChequeCount = twentyFiveDollarChequeCount;
        this.hundredDollarChequeCount = hundredDollarChequeCount;
        this.fiveHundredDollarChequeCount = fiveHundredDollarChequeCount;
        this.thousandDollarChequeCount = thousandDollarChequeCount;
    }

    public Map<String, Number> getInventoryChequeCounts() {
        Map<String, Number> chequeCounts = new HashMap<>();

        chequeCounts.put("pointFiveDollarChequeCount", this.pointFiveDollarChequeCount);
        chequeCounts.put("oneDollarChequeCount", this.oneDollarChequeCount);
        chequeCounts.put("twoPointFiveDollarChequeCount", this.twoPointFiveDollarChequeCount);
        chequeCounts.put("fiveDollarChequeCount", this.fiveDollarChequeCount);
        chequeCounts.put("twentyFiveDollarChequeCount", this.twentyFiveDollarChequeCount);
        chequeCounts.put("hundredDollarChequeCount", this.hundredDollarChequeCount);
        chequeCounts.put("fiveHundredDollarChequeCount", this.fiveHundredDollarChequeCount);
        chequeCounts.put("thousandDollarChequeCount", this.thousandDollarChequeCount);

        return chequeCounts;
    }
}
