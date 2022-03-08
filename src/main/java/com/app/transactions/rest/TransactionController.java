package com.app.transactions.rest;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.transactions.repositories.TransactionRepository;
import com.app.transactions.rest.requests.AddTransaction;
import com.app.transactions.usecase.AddTransactionService;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
	private final AddTransactionService addTransactionService;
	private final TransactionRepository transactionRepository;
	@RequestMapping(method = RequestMethod.POST)
	public void addTransaction(@RequestBody AddTransaction command) {
		addTransactionService.apply(command);

	}

}
