package com.christian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosicionTest {
	Posicion posicion;

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
	void testCreaPosicion() throws JuegoException {
		assertThrows(JuegoException.class, () -> new Posicion(1, 9));
		assertThrows(JuegoException.class, () -> new Posicion('A', -1));
		assertThrows(JuegoException.class, () -> new Posicion('J', 2));
		assertThrows(JuegoException.class, () -> new Posicion('X', 25));
		assertThrows(JuegoException.class, () -> new Posicion('2', 3));
		assertThrows(JuegoException.class, () -> new Posicion('Q', '3'));
		assertThrows(JuegoException.class, () -> new Posicion('A', '9'));
		assertThrows(JuegoException.class, () -> new Posicion(3, '9'));
		assertDoesNotThrow(() -> new Posicion(1, 2));
		assertDoesNotThrow(() -> new Posicion('A', '1'));
		assertDoesNotThrow(() -> new Posicion('D', '4'));
		assertDoesNotThrow(() -> new Posicion('H', '8'));
		assertEquals(1, new Posicion('A', '1').getLaColumna());
		assertEquals(8, new Posicion('C','8').getLaFila());
	}
	
	@Test
	void testEquals() throws JuegoException {
		assertTrue(new Posicion(1,2).Equals(new Posicion('A', '2')));
		assertTrue(new Posicion('C','8').Equals(new Posicion(3, 8)));
		assertTrue(new Posicion('E','5').Equals(new Posicion('E', '5')));
	}

}
