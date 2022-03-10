package com.app.transactions.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.app.transactions.rest.requests.AddAccount;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(
		replace = AutoConfigureTestDatabase.Replace.NONE
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired private MockMvc mockMvc;
	private static final String URL = "/accounts";
	private ObjectMapper objectMapper = new ObjectMapper();
	@Test
	void shouldCreateAccount() throws Exception {
		var command = AddAccount.builder().documentNumber( "55544433322" ).build();
		mockMvc
				.perform(
						post(URL).contentType( MediaType.APPLICATION_JSON ).content( objectMapper.writeValueAsString( command) ))
				.andExpect(status().isOk())
				.andReturn();

	}
}
