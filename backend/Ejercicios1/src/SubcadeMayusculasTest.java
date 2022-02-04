import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubcadeMayusculasTest {
	SubcadenaMayusculas cad;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cad = new SubcadenaMayusculas("cadena test tdd", "tdd");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertir() {
		assertAll("Inicializar", 
				() -> assertEquals("cadena test TDD", cad.convertir()));
	}
}
