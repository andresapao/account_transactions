package com.app.transactions.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;

import com.app.transactions.rest.requests.AddTransaction;

@Getter
@Entity
@Builder
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Account account;
	private int operationTypeId;
	private LocalDate eventDate;
	private BigDecimal eventValue;

}
