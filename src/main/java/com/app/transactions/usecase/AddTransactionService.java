package com.app.transactions.usecase;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.app.transactions.entities.OperationTypes;
import com.app.transactions.entities.Transaction;
import com.app.transactions.repositories.AccountRepository;
import com.app.transactions.repositories.TransactionRepository;
import com.app.transactions.rest.requests.AddTransaction;

@Service
@AllArgsConstructor
public class AddTransactionService {
	private final TransactionRepository transactionRepository;
	private final AccountRepository accountRepository;

	public void apply(AddTransaction command) {

		if(command.getOperationTypeId() > OperationTypes.values().length) {
			throw new RuntimeException("Tipo de operação inexistente");
		}
		var entity = Transaction.builder()
					.account( accountRepository.findById( command.getAccountId()).orElseThrow(() -> new RuntimeException("Conta inexistente")) )
					.eventDate( LocalDate.now())
					.eventValue(command.getAmount())
					.operationTypeId(command.getOperationTypeId())
					 .build();
		transactionRepository.save( entity );

	}


}
