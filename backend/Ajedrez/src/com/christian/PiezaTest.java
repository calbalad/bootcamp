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
		tablero.setEscaque(1, 2, pieza);
		tablero.setEscaque(2, 3, pieza2);
		pieza.Mover(new Movimiento("A2B3"), tablero);
		assertNotNull(tablero.Escaque(2,3));
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
	void testDama() throws JuegoException {
		Tablero tablero = new Tablero();
		var pieza = new Dama(Color.BLANCO);
		var pieza2 = new Peon(Color.BLANCO);
		tablero.setEscaque(2, 1, pieza);
		tablero.setEscaque(2,2, pieza2);
		pieza.Mover(new Movimiento("B1C3"), tablero);
		assertNotNull(tablero.Escaque(3,3));
		pieza.Mover(new Movimiento("C3B1"), tablero);
		assertNotNull(tablero.Escaque(2,1));
	}
	
	

}
