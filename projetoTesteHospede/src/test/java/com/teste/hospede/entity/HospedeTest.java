package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	
	private Hospede hospede;
	
	@BeforeEach
	void setup() {
		//Arrange
		hospede = new Hospede(1l, "Abner","abner@gmail.com","(15)9945-8796");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		hospede.setId(2l);
		//Assert
		assertEquals(2L, hospede.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		hospede.setNome("Marcelo Rogerio");
		//Assert
		assertEquals("Marcelo Rogerio", hospede.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
		//Act
		hospede.setEmail("marcelorogerio@gmail.com");
		//Assert
		assertEquals("marcelorogerio@gmail.com", hospede.getEmail());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		//Act
		hospede.setTelefone("(15)9945-0689");
		//Assert
		assertEquals("(15)9945-0689", hospede.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testConstructorALL() {
		//Act
		Hospede novoHospede = new Hospede(3L, "Matheus", "matheus@gmail.com", "(15)9910-5712");
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals(3L, novoHospede.getId()),
				()-> assertEquals("Matheus", novoHospede.getNome()),
				()-> assertEquals("matheus@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("(15)9910-5712", novoHospede.getTelefone())
	);
	
	}
	
	
};
