package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {
	
	private Quarto quarto;
	
	@BeforeEach
	void setup() {
		//Arrange
		quarto = new Quarto(1l, "137", "suite");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		quarto.setId(2l);
		//Assert
		assertEquals(2L, quarto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Num")
	void testNum() {
		//Act
		quarto.setNum("200");
		//Assert
		assertEquals("200", quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Tipo")
	void testTipo() {
		//Act
		quarto.setTipo("quarto casal");
		//Assert
		assertEquals("quarto casal", quarto.getTipo());
	}
	
	@Test
	@DisplayName("Testando o getter e setter de todos os campos")
	void testConstructorALL() {
		//Act
		Quarto novoQuarto = new Quarto(3L, "123", "quarto de solteiro");
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals(3L, novoQuarto.getId()),
				()-> assertEquals("123", novoQuarto.getNum()),
				()-> assertEquals("quarto de solteiro", novoQuarto.getTipo())

	);
	
	}
	
	
};
