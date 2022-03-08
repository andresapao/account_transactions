package com.app.transactions.rest.response;

import lombok.Builder;

import com.app.transactions.entities.Account;

@Builder
public class AccountDto {
	private Long accountId;

	private String documentNumber;

	public static AccountDto from(Account entity)
	{
		return AccountDto.builder().accountId(entity.getAccountId()).documentNumber(entity.getDocumentNumber()).build();
	}
}
