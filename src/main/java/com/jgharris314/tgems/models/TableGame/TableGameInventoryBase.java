package com.jgharris314.tgems.models.TableGame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class TableGameInventoryBase {
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

    public TableGameInventoryBase() {
    }

    @JsonCreator
    public TableGameInventoryBase(@JsonProperty("pointFiveDollarChequeCount") Integer pointFiveDollarChequeCount,
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

    public Integer getPointFiveDollarChequeCount() {
        return pointFiveDollarChequeCount;
    }

    public Integer getOneDollarChequeCount() {
        return oneDollarChequeCount;
    }

    public Integer getTwoPointFiveDollarChequeCount() {
        return twoPointFiveDollarChequeCount;
    }

    public Integer getFiveDollarChequeCount() {
        return fiveDollarChequeCount;
    }

    public Integer getTwentyFiveDollarChequeCount() {
        return twentyFiveDollarChequeCount;
    }

    public Integer getHundredDollarChequeCount() {
        return hundredDollarChequeCount;
    }

    public Integer getFiveHundredDollarChequeCount() {
        return fiveHundredDollarChequeCount;
    }

    public Integer getThousandDollarChequeCount() {
        return thousandDollarChequeCount;
    }
}
