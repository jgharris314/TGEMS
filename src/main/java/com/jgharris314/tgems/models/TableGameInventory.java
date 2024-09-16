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

    @Column(name = "num_cheques_value_half")
    private Integer numChequesValueHalf;

    @Column(name = "num_cheques_value_two_and_a_half")
    private Integer numChequesValueTwoAndAHalf;

    @Column(name = "num_cheques_value_one")
    private Integer numChequesValueOne;

    @Column(name = "num_cheques_value_five")
    private Integer numChequesValueFive;

    @Column(name = "num_cheques_value_twenty_five")
    private Integer numChequesValueTwentyFive;

    @Column(name = "num_cheques_value_hundred")
    private Integer numChequesValueHundred;

    @Column(name = "num_cheques_value_five_hundred")
    private Integer numChequesValueFiveHundred;

    @Column(name = "num_cheques_value_thousand")
    private Integer numChequesValueThousand;

    public TableGameInventory() {
    }

    @JsonCreator
    public TableGameInventory(@JsonProperty("numChequesValueHalf") Integer half,
                              @JsonProperty("numChequesValueOne") Integer one,
                              @JsonProperty("numChequesValueTwoAndAHalf") Integer twoAndAHalf,
                              @JsonProperty("numChequesValueFive") Integer five,
                              @JsonProperty("numChequesValueTwentyFive") Integer twentyFive,
                              @JsonProperty("numChequesValueHundred") Integer hundred,
                              @JsonProperty("numChequesValueFiveHundred") Integer fiveHundred,
                              @JsonProperty("numChequesValueThousand") Integer thousand) {
        this.numChequesValueHalf = half;
        this.numChequesValueOne = one;
        this.numChequesValueTwoAndAHalf = twoAndAHalf;
        this.numChequesValueFive = five;
        this.numChequesValueTwentyFive = twentyFive;
        this.numChequesValueHundred = hundred;
        this.numChequesValueFiveHundred = fiveHundred;
        this.numChequesValueThousand = thousand;
    }

    public Map<String, Number> getInventoryChequeCounts() {
        Map<String, Number> chequeCounts = new HashMap<>();

        chequeCounts.put("numChequesValueHalf", this.numChequesValueHalf);
        chequeCounts.put("numChequesValueOne", this.numChequesValueOne);
        chequeCounts.put("numChequesValueTwoAndAHalf", this.numChequesValueTwoAndAHalf);
        chequeCounts.put("numChequesValueFive", this.numChequesValueFive);
        chequeCounts.put("numChequesValueTwentyFive", this.numChequesValueTwentyFive);
        chequeCounts.put("numChequesValueHundred", this.numChequesValueHundred);
        chequeCounts.put("numChequesValueFiveHundred", this.numChequesValueFiveHundred);
        chequeCounts.put("numChequesValueThousand", this.numChequesValueThousand);

        return chequeCounts;
    }
}
