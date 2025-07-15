package com.misty.jdbc.service;

import com.misty.jdbc.AccountsRepo;
import com.misty.jdbc.model.bankaccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bankaccountservice {
    @Autowired
    AccountsRepo repo;





    public void createnewaccount(int ID, String name, int balance) {
        bankaccount newaccount=new bankaccount(ID,name,balance);
        repo.save(newaccount);



    }

    public List<bankaccount> fetchaccounts() {
        return repo.findAll();


    }

    public String withdraw(int ID, int amount) {
        Optional<bankaccount> acc=repo.findById(ID);
        if(amount<=0){
            return "invalid amount";
        }
        if(acc.isPresent()){
            bankaccount account=acc.get();
            account.setAccountbalance(account.getAccountbalance()-amount);
            repo.save(account);
            return amount+"has been withdrawn";


        }
        else{
            return "there is no account with this id";
        }



    }

    public String transfer(int fromaccountID, int toaccountID, int amount) {
       Optional<bankaccount> fromacc=repo.findById(fromaccountID);
       Optional<bankaccount> toacc=repo.findById(toaccountID);


       if(fromacc.isPresent()) {

           bankaccount fromaccount=fromacc.get();
           bankaccount toaccount=toacc.get();

           if (fromaccount.getAccountbalance() <= amount) {
               return "insufficient balance";
           }

           fromaccount.setAccountbalance(fromaccount.getAccountbalance() - amount);
           toaccount.setAccountbalance(fromaccount.getAccountbalance() + amount);

           repo.save(fromaccount);
           repo.save(toaccount);

           return amount + " amount has been transferred ";
       }
       return "account was not found";


    }

    public String deposit(int id, int amount) {
        Optional<bankaccount> acc=repo.findById(id);
        if(amount<=0){
            return "invalid amount";
        }
        if(acc.isPresent()){
            bankaccount account=acc.get();
            account.setAccountbalance(account.getAccountbalance()+amount);
            repo.save(account);
            return amount + " has been deposited ";


        }
        else{
            return " there is no account with this id ";
        }
    }
}
