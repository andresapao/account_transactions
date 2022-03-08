package com.app.transactions.rest.requests;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddTransaction {
	private Long accountId;
	private int operationTypeId;
	private BigDecimal amount;
}
