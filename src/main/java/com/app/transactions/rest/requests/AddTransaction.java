package com.app.transactions.rest.requests;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTransaction {
	private Long accountId;
	private int operationTypeId;
	private BigDecimal amount;
}
