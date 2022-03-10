package com.app.transactions.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.app.transactions.entities.Account;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	private Long accountId;

	private String documentNumber;

	public static AccountDto from(Account entity)
	{
		return AccountDto.builder().accountId(entity.getAccountId()).documentNumber(entity.getDocumentNumber()).build();
	}
}
