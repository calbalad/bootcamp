import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Iterator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JuegoDelNumeroTest {
	JuegoDelNumero juego;

	@BeforeEach
	void setUp() throws Exception {
		juego = new JuegoDelNumero();
		juego.numeroAdivinar = 50;
	}

	@Test
	void test_Constructor() {
		assertNotNull(new JuegoDelNumero());
	}

	@Test
	void test_Inicializar() {
		juego.numeroAdivinar = 0;
		juego.inicializar();
		assertAll("Inicializar", 
				() -> assertEquals("Pendiente de empezar", juego.getResultado()),
				() -> assertEquals(0, juego.getJugada()),
				() -> assertTrue(0 < juego.numeroAdivinar && juego.numeroAdivinar <= 100, "rango entre 1 y 100"));
	}

	@Nested
	class jugadas {
		@Test
		void test_es_mayor() throws JuegoException {
			juego.nextTurn(51);
			assertAll("Jugada", 
					() -> assertEquals("El número es menor", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}

		@Test
		void test_es_menor() throws JuegoException {
			juego.nextTurn(49);
			assertAll("Jugada", 
					() -> assertEquals("El número es mayor", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}

		@Test
		void test_es_igual() throws JuegoException {
			juego.nextTurn(50);
			assertAll("Jugada", 
					() -> assertEquals("¡Ganaste!", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}
		
		@Test
		void test_limite_jugada() throws JuegoException {
			for (int i = 0; i < 10; i++) {
				juego.nextTurn(30);
			}
			assertAll("Jugada", 
					() -> assertEquals("Se acabaron los intentos, el número era el " + juego.numeroAdivinar, juego.getResultado()));
		}
	}
}
