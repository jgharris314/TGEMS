package com.jgharris314.tgems.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name="account_id", columnDefinition = "UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID account_id;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="last_name", nullable = false)
    private String last_name;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    public Account(){}

    @JsonCreator
    public Account(@JsonProperty("first_name") String first_name, @JsonProperty("last_name") String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName(){
        return this.last_name;
    }
}
