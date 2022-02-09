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
	}

	@Test
	void testSetPosIni() {
		
	}

	@Test
	void testGetPosFin() {
		
	}

	@Test
	void testSetPosFin() {
		
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
		assertTrue(new Movimiento("D1C3").EsDiagonal());
	}

	@Test
	void testSaltoVertical() {
		
	}

	@Test
	void testSaltoHorizontal() {
		
	}

	@Test
	void testDeltaFila() {
		
	}

	@Test
	void testSaltodeltaColumna() {
		
	}

}
