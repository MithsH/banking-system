package com.misty.jdbc;

import com.misty.jdbc.model.bankaccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepo extends JpaRepository<bankaccount,Integer> {

    Optional<bankaccount> findById(int ID);




}
