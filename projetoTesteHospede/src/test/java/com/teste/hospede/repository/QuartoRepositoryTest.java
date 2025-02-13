package com.teste.hospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.hospede.entity.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

    @Autowired
    private QuartoRepository quartoRepository;

    @DisplayName("Testando o Save")
    @Test
    void testSalvarRepository() {

        // Given / Arrange
        Quarto quarto1 =new Quarto(null, "42",
                                        "luxo");

        // When / Act
        Quarto saveQuarto = quartoRepository.save(quarto1);

        // Then / Act
        assertNotNull(saveQuarto);
        assertTrue(saveQuarto.getId() > 0);
        }

    @DisplayName("Testando Get para todos os Quartos")
    @Test
    void testGetAllRepository() {

        // Given / Arrange
        Quarto quarto1 = new Quarto(null, "42",
        		"luxo");
        
        // Given / Arrange
        Quarto quarto2 = new Quarto(null, "70",
        		"suite");
        		
        quartoRepository.save(quarto1);
        quartoRepository.save(quarto2);
        
        //When / Act
        List<Quarto> quartoList = quartoRepository.findAll();
        		
        //Then / Assert
        assertNotNull(quartoList);
        assertEquals(2, quartoList.size());
    	 
     }
    
    @DisplayName("Testando GET by ID")
    @Test
    void testGetById() {

        // Given / Arrange
        Quarto quarto1 =new Quarto(null, "70",
                "suite");

        quartoRepository.save(quarto1);

        // When / Act
        Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();


        // Then / Assert
        assertNotNull(saveQuarto);
        assertEquals(quarto1.getId(), saveQuarto.getId());
    }

    
    @DisplayName("Testando o update")
    @Test
    void testUpdateQuarto() {
   	 
   	 	// Given / Arrange
        Quarto quarto1 = new Quarto(null, "70",
        		"suite");
        
        quartoRepository.save(quarto1);
        
        //When / Act
        Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
        quarto1.setNum("420");
        quarto1.setTipo("cobertura");
        
        Quarto updateQuarto = quartoRepository.save(saveQuarto);
        
        //Then / Assert
        assertNotNull(updateQuarto);
        assertEquals("420", updateQuarto.getNum());
        assertEquals("cobertura", updateQuarto.getTipo());
    
}
    
    @DisplayName("Testando o Delete")
    @Test
    void testDeleteQuarto() {
   	 
   	 	// Given / Arrange
        Quarto quarto1 = new Quarto(null, "70",
        		"suite");
        
        quartoRepository.save(quarto1);
    
        //When / Act
        quartoRepository.deleteById(quarto1.getId());
        
        Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());
        
        //Then / Assert
        assertTrue(quartoOptional.isEmpty());
        	
    }
    
}