package com.qa.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.account.entities.CreateAccount;

public interface AccountRepository extends JpaRepository<CreateAccount, Long> {

}
