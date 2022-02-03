import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {

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
	@Nested
	class Division {
		@Nested 
		class OK{
			@ParameterizedTest(name = "{displayName} => {0} / {1} = {2}")
			@CsvSource(value = {"2,2,1", "3,2,1.5"})
			void Validas (double op1, double op2, double resultado) {
				assertEquals(resultado, Calculadora.division(op1, op2));
			}
		}
	}
	
	
	@Test
	void divide_por_0_enteros() {
		assertThrows(ArithmeticException.class, () -> Calculadora.division(3, 0));
	}
	

}
