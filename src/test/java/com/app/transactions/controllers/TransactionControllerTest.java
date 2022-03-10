package com.app.transactions.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.app.transactions.entities.OperationTypes;
import com.app.transactions.rest.requests.AddAccount;
import com.app.transactions.rest.requests.AddTransaction;
import com.app.transactions.rest.response.AccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(
		replace = AutoConfigureTestDatabase.Replace.NONE
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class TransactionControllerTest {
	@Autowired private MockMvc mockMvc;
	private static final String URL = "/transactions";
	private ObjectMapper objectMapper = new ObjectMapper();
	@Test
	void shouldCreateTransaction() throws Exception {
		var accountCommand = AddAccount.builder().documentNumber( "00044433322" ).build();
		var account = objectMapper.readValue( mockMvc
				.perform(
						post("/accounts").contentType( MediaType.APPLICATION_JSON ).content( objectMapper.writeValueAsString( accountCommand) )).andReturn().getResponse().getContentAsString(),
				AccountDto.class);


		var command = AddTransaction.builder().accountId( account.getAccountId()).operationTypeId( OperationTypes.COMPRA_A_VISTA.ordinal() ).amount( BigDecimal.TEN ).build();
		mockMvc
				.perform(
						post(URL).contentType( MediaType.APPLICATION_JSON ).content( objectMapper.writeValueAsString( command) ))
				.andExpect(status().isOk())
				.andReturn();

	}

}
