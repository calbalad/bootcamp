import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardGameTest {
	CardGame cardGame;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cardGame = new CardGame();
		cardGame.createMultiplePlayer(2, 5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testDeleteCardFromHand() {
		var plyr = cardGame.getPlayers().get(0);
		var deletedCard = cardGame.getCardsPlayer(plyr).get(0);
		cardGame.deleteCardFromHand(cardGame.getCardsPlayer(plyr).get(0), plyr);
		boolean exists = cardGame.getCardsPlayer(plyr).stream().anyMatch(x -> x.equals(deletedCard));
		assertFalse(exists);
	}
	
	@Test
	void testCreateMultiplePlayer() {
		cardGame.createMultiplePlayer(3, 10);
		assertEquals(3, cardGame.getPlayers().size());
		assertEquals(10, cardGame.getCardsPlayer(cardGame.getPlayers().get(0)).size());
		assertEquals(10, cardGame.getCardsPlayer(cardGame.getPlayers().get(1)).size());
		assertEquals(10, cardGame.getCardsPlayer(cardGame.getPlayers().get(2)).size());
	}
}
