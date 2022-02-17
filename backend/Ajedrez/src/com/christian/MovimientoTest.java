package com.christian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {
	Movimiento movimiento;

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
	void testMovimiento() {
		assertDoesNotThrow(() -> new Movimiento("H8H3"));
		// assertThrows(JuegoException.class, () -> new
		// Movimiento("A1A1").SaltoVertical());
		assertThrows(JuegoException.class, () -> new Movimiento("A11").SaltoVertical());
		assertThrows(JuegoException.class, () -> new Movimiento("A1A2A3").SaltoVertical());
	}

	@Test
	void testEsVertical() throws JuegoException {
		assertTrue(new Movimiento("H3H4").EsVertical());
		assertTrue(new Movimiento("C3C8").EsVertical());
		assertFalse(new Movimiento("H3C6").EsVertical());
	}

	@Test
	void testEsHorizontal() throws JuegoException {
		assertTrue(new Movimiento("H3C3").EsHorizontal());
		assertTrue(new Movimiento("C8A8").EsHorizontal());
		assertFalse(new Movimiento("H3C6").EsHorizontal());
	}

	@Test
	void testEsDiagonal() throws JuegoException {
		assertTrue(new Movimiento("B1A2").EsDiagonal());
		assertTrue(new Movimiento("A1H8").EsDiagonal());
		assertTrue(new Movimiento("B1D3").EsDiagonal());
		assertTrue(new Movimiento("H8A1").EsDiagonal());
		assertTrue(new Movimiento("D2F4").EsDiagonal());
		assertFalse(new Movimiento("D1C4").EsDiagonal());
	}

	@Test
	void testSaltoVertical() throws JuegoException {
		assertEquals(1, new Movimiento("A1A2").SaltoVertical());
		assertEquals(2, new Movimiento("A2A4").SaltoVertical());
		assertEquals(3, new Movimiento("A1A4").SaltoVertical());
		assertNotEquals(2, new Movimiento("A1A2").SaltoVertical());
		// assertThrows(JuegoException.class, () -> new
		// Movimiento("A1A1").SaltoVertical());
		// assertThrows(JuegoException.class, () -> new
		// Movimiento("A1B2").SaltoVertical());
	}

	@Test
	void testSaltoHorizontal() throws JuegoException {
		assertEquals(1, new Movimiento("A1B1").SaltoHorizontal());
		assertEquals(2, new Movimiento("A1C1").SaltoHorizontal());
		assertEquals(3, new Movimiento("A1D1").SaltoHorizontal());
		assertEquals(2, new Movimiento("C1A1").SaltoHorizontal());
		assertNotEquals(2, new Movimiento("A1H1").SaltoHorizontal());
		// assertThrows(JuegoException.class, () -> new
		// Movimiento("A1A1").SaltoHorizontal());
		// assertThrows(JuegoException.class, () -> new
		// Movimiento("A1B2").SaltoHorizontal());

	}

	@Test
	void testDeltaFila() throws JuegoException {
		assertEquals(1, new Movimiento("A1A2").deltaFila());
		assertEquals(1, new Movimiento("A1A8").deltaFila());
		assertEquals(-1, new Movimiento("A2A1").deltaFila());
		assertEquals(0, new Movimiento("A1B1").deltaFila());
	}

	@Test
	void testSaltodeltaColumna() throws JuegoException {
		assertEquals(1, new Movimiento("A1B1").deltaColumna());
		assertEquals(1, new Movimiento("A2H2").deltaColumna());
		assertEquals(-1, new Movimiento("H3F3").deltaColumna());
	}

}
