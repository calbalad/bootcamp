package com.christian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PiezaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws JuegoException {
		Tablero tablero = new Tablero();
		var pieza = new Peon(Color.BLANCO);
		tablero.setEscaque(4, 2, pieza);
		pieza.Mover(new Movimiento("D2D4"), tablero);
		assertNotNull(tablero.Escaque(4,4));
		
	}

}
