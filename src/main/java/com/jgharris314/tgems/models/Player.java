package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jgharris314.tgems.player.enums.RewardTier;
import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer playerId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "reward_tier")
    @Enumerated(EnumType.STRING)
    private RewardTier rewardTier;

    @Column(name = "reward_tier_points")
    private Integer rewardTierPoints;

    @Column(name = "lifetime_buy_in")
    private Integer lifetimeBuyIn;

    @Column(name = "lifetime_cash_out")
    private Integer lifetimeCashOut;

    public Player() {
    }

    @JsonCreator
    public Player(
            @JsonProperty("account") Account account,
            @JsonProperty("rewardTier") RewardTier rewardTier,
            @JsonProperty("rewardTierPoints") Integer rewardTierPoints,
            @JsonProperty("lifetimeBuyIn") Integer lifetimeBuyIn,
            @JsonProperty("lifetimeCashOut") Integer lifetimeCashOut
    ) {
        this.account = account;
        this.rewardTier = rewardTier;
        this.rewardTierPoints = rewardTierPoints;
        this.lifetimeBuyIn = lifetimeBuyIn;
        this.lifetimeCashOut = lifetimeCashOut;

    }

    public Integer getPlayerId() {
        return this.playerId;
    }

    public Account getAccount() {
        return this.account;
    }

    public Integer getLifetimeBuyIn() {
        return this.lifetimeBuyIn;
    }

    public Integer getLifetimeCashOut() {
        return this.lifetimeCashOut;
    }

    public RewardTier getRewardTier() {
        return this.rewardTier;
    }

    public Integer getRewardTierPoints() {
        return this.rewardTierPoints;
    }
}




