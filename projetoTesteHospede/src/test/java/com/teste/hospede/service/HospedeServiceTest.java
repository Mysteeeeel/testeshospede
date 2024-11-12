package com.teste.hospede.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.hospede.entity.Hospede;
import com.teste.hospede.repository.HospedeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional

class HospedeServiceTest {

	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@BeforeEach
	void setup() {
		hospedeRepository.deleteAll();
	}
	
	@DisplayName("testando salvar hóspede")
	@Test
	void testSalvarHospede() {
		Hospede hospede = new Hospede(null, "Julia Maria", "Julia@gmail.com", "(00)0000-0000");
		
		Hospede resultado = hospedeService.salvarHospede(hospede);
		
		assertNotNull(resultado);
		assertEquals("Julia Maria", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}
	
	@DisplayName("testando listar todos os hóspedes")
	@Test
	void testListarTodos() {
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		Hospede hospede2 = new Hospede(null, "Julio Fernando", "julio@gmail.com", "(00)0000-0000");
		
		hospedeService.salvarHospede(hospede1);
		hospedeService.salvarHospede(hospede2);
	
	
	List<Hospede> resultado = hospedeService.listarTodos();
	
	assertNotNull(resultado);
	assertEquals(2, resultado.size());
	}
}
