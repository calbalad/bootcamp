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
	void testPeon() throws JuegoException {
		Tablero tablero = new Tablero();
		var pieza = new Peon(Color.BLANCO);
		var pieza2 = new Peon(Color.NEGRO);
		tablero.setEscaque(5, 2, pieza);
		tablero.setEscaque(2, 3, pieza2);
		pieza.Mover(new Movimiento("E2E4"), tablero);
		assertNotNull(tablero.Escaque(5,4));
	}
	
	@Test
	void testaAlfil() throws JuegoException {
		Tablero tablero = new Tablero();
		var pieza = new Alfil(Color.BLANCO);
		var pieza2 = new Peon(Color.BLANCO);
		tablero.setEscaque(3, 1, pieza);
		tablero.setEscaque(3,2, pieza2);
		pieza.Mover(new Movimiento("C1E3"), tablero);
		assertNotNull(tablero.Escaque(5,3));
		pieza.Mover(new Movimiento("E3D2"), tablero);
	}
	
	@Test
	void testCaballo() throws JuegoException {
		Tablero tablero = new Tablero();
		var pieza = new Caballo(Color.BLANCO);
		var pieza2 = new Peon(Color.BLANCO);
		tablero.setEscaque(2, 1, pieza);
		tablero.setEscaque(2,2, pieza2);
		pieza.Mover(new Movimiento("B1C3"), tablero);
		assertNotNull(tablero.Escaque(3,3));
		pieza.Mover(new Movimiento("C3B1"), tablero);
		assertNotNull(tablero.Escaque(2,1));
	}
	
	@Test
	void testRey() throws JuegoException {
		Tablero tablero = new Tablero();
		var pieza = new Rey(Color.BLANCO);
		tablero.setEscaque(5, 8, pieza);
		pieza.Mover(new Movimiento("E8D7"), tablero);
		assertNotNull(tablero.Escaque(4,7));
	}
	
	
	

}
