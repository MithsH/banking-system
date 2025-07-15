package com.misty.jdbc.controller;

import com.misty.jdbc.model.bankaccount;
import com.misty.jdbc.service.bankaccountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class bankaccountcontroller {

    @Autowired
    bankaccountservice service;

    @PostMapping("newaccount")
    public String newaccount(@RequestParam("BankID")int ID,
                             @RequestParam("accountname") String name,
                             @RequestParam("accountbalance") int balance
                             ) {
        service.createnewaccount(ID, name, balance);
        return "new account has been sucessfully created";
    }
    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping("regx")
    public List<bankaccount> registeredaccounts(){
       return service.fetchaccounts();
    }

    @PostMapping("withdraw")
    public String withdraw(@RequestParam int BankID,@RequestParam int amount){
        return service.withdraw(BankID,amount);

    }
    @PostMapping("transfer")
    public String transfer(@RequestParam int fromaccount,@RequestParam int toaccount, @RequestParam int amount){
        return service.transfer(fromaccount,toaccount,amount);
    }
    @PostMapping("deposit")
    public String deposit(@RequestParam int ID,@RequestParam int amount){
        return service.deposit(ID,amount);
    }
}






