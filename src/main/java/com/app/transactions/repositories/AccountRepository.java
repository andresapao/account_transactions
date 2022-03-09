package com.app.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.transactions.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
