package com.app.transactions.rest;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.transactions.repositories.AccountRepository;
import com.app.transactions.rest.requests.AddAccount;
import com.app.transactions.rest.response.AccountDto;
import com.app.transactions.usecase.AddAccountService;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
	private final AddAccountService addAccountService;
	private final AccountRepository accountRepository;
	@RequestMapping(method = RequestMethod.GET)
	public AccountDto getAccount(@PathVariable("id") Long id) {
		return AccountDto.from( accountRepository.getById( id ));
	}

	@RequestMapping(method = RequestMethod.POST)
	public AccountDto addAccount(@RequestBody AddAccount command) {
		return AccountDto.from( addAccountService.apply( command ));

	}

}
