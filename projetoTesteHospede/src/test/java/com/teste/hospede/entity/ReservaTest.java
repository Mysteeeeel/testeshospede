package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservaTest {
	
	private Reserva reserva;
	private Hospede hospede;
	private Quarto quarto;
	
	@BeforeEach
	void setup() {
		//Arrange
		reserva = new Reserva(1l, hospede, quarto, LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 10));
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		reserva.setId(2l);
		//Assert
		assertEquals(2L, reserva.getId(), "O id deve ser igual o valor atribuido");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Hospede")
	void testHospede() {
		//Act
		reserva.setHospede(hospede);
		//Assert
		assertEquals(hospede, reserva.getHospede());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Quarto")
	void testQuarto() {
		//Act
		reserva.setQuarto(quarto);
		//Assert
		assertEquals(quarto, reserva.getQuarto());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo CheckIn")
	void testCheckInData() {
		//Act
		reserva.setCheckInData(LocalDate.of(2024, 9, 1));
		//Assert
		assertEquals(LocalDate.of(2024, 9, 1), reserva.getCheckInData());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo CheckOut")
	void testCheckOutData() {
		//Act
		reserva.setCheckOutData(LocalDate.of(2024, 9, 10));
		//Assert
		assertEquals(LocalDate.of(2024, 9, 10), reserva.getCheckOutData());
	}
	
	@Test
	@DisplayName("Testando o getter e setter de todos os campos")
	void testConstructorALL() {
		//Act
		Reserva novoReserva = new Reserva(3L, hospede, quarto,  LocalDate.of(2024, 9, 22),  LocalDate.of(2024, 9, 25));
		//Assertion
		assertAll("novoReserva", () -> assertEquals(3L, novoReserva.getId()),
				()-> assertEquals(hospede, novoReserva.getHospede()),
				()-> assertEquals(quarto, novoReserva.getQuarto()),
				()-> assertEquals(LocalDate.of(2024, 9, 22), novoReserva.getCheckInData()),
				()-> assertEquals(LocalDate.of(2024, 9, 25), novoReserva.getCheckOutData()));

	
	}
	
	
};
