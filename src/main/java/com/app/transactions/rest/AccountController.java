package com.app.transactions.rest;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.transactions.rest.requests.AddAccount;
import com.app.transactions.usecase.AddAccountService;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
	private final AddAccountService addAccountService;
	@RequestMapping(method = RequestMethod.GET)
	public List<String> getShops() {

		return Arrays.asList("Shop1", "Shop2");
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addAccount(@RequestBody AddAccount command) {
		addAccountService.apply( command );

	}

}
