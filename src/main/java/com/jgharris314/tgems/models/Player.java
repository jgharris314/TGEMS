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
    private Integer player_id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "reward_tier")
    @Enumerated(EnumType.STRING)
    private RewardTier reward_tier;

    @Column(name = "reward_tier_points")
    private Integer reward_tier_points;

    @Column(name = "lifetime_buy_in")
    private Integer lifetime_buy_in;

    @Column(name = "lifetime_cash_out")
    private Integer lifetime_cash_out;

    public Player() {
    }

    @JsonCreator
    public Player(
            @JsonProperty("account") Account account,
            @JsonProperty("reward_tier") RewardTier reward_tier,
            @JsonProperty("reward_tier_points") Integer reward_tier_points,
            @JsonProperty("lifetime_buy_in") Integer lifetime_buy_in,
            @JsonProperty("lifetime_cash_out") Integer lifetime_cash_out
    ) {
        this.account = account;
        this.reward_tier = reward_tier;
        this.reward_tier_points = reward_tier_points;
        this.lifetime_buy_in = lifetime_buy_in;
        this.lifetime_cash_out = lifetime_cash_out;

    }

    public Integer getPlayerId() {
        return this.player_id;
    }

    public Account getAccount() {
        return this.account;
    }

    public Integer getLifetimeBuyIn() {
        return this.lifetime_buy_in;
    }

    public Integer getLifetimeCashOut() {
        return this.lifetime_cash_out;
    }

    public RewardTier getRewardTier() {
        return this.reward_tier;
    }

    public Integer getRewardTierPoints() {
        return this.reward_tier_points;
    }
}




