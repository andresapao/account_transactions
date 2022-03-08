package com.app.transactions.usecase;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.app.transactions.entities.Account;
import com.app.transactions.repositories.AccountRepository;
import com.app.transactions.rest.requests.AddAccount;

@Service
@AllArgsConstructor
public class AddAccountService {
	private final AccountRepository accountRepository;
	public void apply(AddAccount command) {
		accountRepository.save(Account.builder().documentNumber( command.getDocumentNumber() ).build());
	}
}
