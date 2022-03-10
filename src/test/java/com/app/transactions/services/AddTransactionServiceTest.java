package com.app.transactions.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.transactions.repositories.AccountRepository;
import com.app.transactions.rest.requests.AddTransaction;
import com.app.transactions.usecase.AddTransactionService;

@ExtendWith(MockitoExtension.class)
public class AddTransactionServiceTest {
	@InjectMocks AddTransactionService addTransactionService;
	@Mock AccountRepository accountRepository;
	@Test
	void shouldThrowException() {
		var command = spy( AddTransaction.class);
		given(command.getOperationTypeId()).willReturn(5);

		assertThrows(RuntimeException.class, () -> addTransactionService.apply( command));

		given(command.getOperationTypeId()).willReturn(3);
		given(command.getAccountId()).willReturn(1L);
		given(accountRepository.findById(any()))
				.willReturn( (Optional.empty()));

		assertThrows(RuntimeException.class, () -> addTransactionService.apply( command));
	}

}
