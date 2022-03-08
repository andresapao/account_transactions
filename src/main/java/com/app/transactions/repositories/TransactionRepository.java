package com.app.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.transactions.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
