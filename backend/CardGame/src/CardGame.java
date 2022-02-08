import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CardGame {
	private List<Card> cards;
	private List<Player> players = new ArrayList<Player>();
	private Map<Player, List<Card>> cardsPlayerMap = new HashMap<Player, List<Card>>();
	private int numberOfPlayers = 2;
	private int numberOfCards = 5;
	
	public CardGame() {
		cards = Card.getCards();
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public List<Card> getCardsPlayer(Player player) {
		return cardsPlayerMap.get(player);
	}
	
	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}
	
	public void deleteCardFromHand(Card card, Player player) {
		for (int i = 0; i < getCardsPlayer(player).size(); i++) {
			if (getCardsPlayer(player).get(i).equals(card)) {
				getCardsPlayer(player).remove(i);
				break;
			}
		}
	}

	private void distributeCardsForPlayers(List<Player> listPlayers) {
		this.players = listPlayers;
		Card.shuffleCards(cards);
		if (cardsPlayerMap.size() == 0)
			cardsPlayerMap.clear();

		for (Player player : players) {
			List<Card> listCards = new ArrayList<Card>();
			for (int i = 0; i < numberOfCards; i++) {
				listCards.add(cards.get(i));
				cards.remove(i);
			}
			cardsPlayerMap.put(player, listCards);
		}
	}

	public void createMultiplePlayer(int numOfPlayers, int numberOfCards) {
		setNumberOfCards(numberOfCards);
		if (players.size() != 0) {
			players.clear();
		}

		for (int i = 0; i < numOfPlayers; i++) {
			Player player = new Player();
			players.add(player);
		}
		distributeCardsForPlayers(players);
	}

}
