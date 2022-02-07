import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
	List<Card> cards;

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
	void testGetCards() {
		cards = Card.getCards();
		assertTrue(cards.size() == 52);
		assert new HashSet<Card>(cards).size() == cards.size();
	}

	@Test
	void testCompareTo() {
		cards = Card.getCards();
		assertAll("Comparate", () -> assertEquals(1, cards.get(1).compareTo(cards.get(0))), // Card >
				() -> assertEquals(-1, cards.get(0).compareTo(cards.get(4))), // Card <
				() -> assertEquals(0, cards.get(0).compareTo(cards.get(0))) // Card ==
		);
	}
	
	@Test
	void testshuffleCards() {
		cards = Card.getCards();
		Card.shuffleCards(cards);
		assert new HashSet<Card>(cards).size() == cards.size();
	}

}
