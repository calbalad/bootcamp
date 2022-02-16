package com.christian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTest {

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
	void testJuego() throws JuegoException {
		Juego juego = new Juego();
		juego.Inicializar();
		juego.Jugada("D2D4");
		assertNotNull(juego.getElTablero().Escaque(4, 4));
		assertTrue(juego.getElTablero().Escaque(4, 4).getClass().equals(new Peon(Color.BLANCO).getClass()));
		juego.Jugada("G8F6");
		juego.Jugada("G1F3");
		juego.Jugada("G7G6");
		assertTrue(juego.getElTablero().Escaque(7, 6).getClass().equals(new Peon(Color.NEGRO).getClass()));
		juego.Jugada("C2C4");
		juego.Jugada("F8G7");
		juego.Jugada("B1C3");
		juego.Jugada("D7D5");
		juego.Jugada("C4D5");
		juego.Jugada("F6D5");
		juego.Jugada("E2E4");
		juego.Jugada("D5C3");
		juego.Jugada("B2C3");
		juego.Jugada("C2B5");
		juego.Jugada("C3C5");
		juego.Jugada("A1B1");
		assertTrue(juego.getElTablero().Escaque(4, 4).getClass().equals(new Peon(Color.BLANCO).getClass()));
		assertTrue(juego.getElTablero().Escaque(5, 4).getClass().equals(new Peon(Color.BLANCO).getClass()));
	}

}
