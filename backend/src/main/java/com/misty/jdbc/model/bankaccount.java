package com.misty.jdbc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class bankaccount {

    @Id
    private int BankID;

    private String accountname;
    private int accountbalance;

    public bankaccount() {

    }
}
