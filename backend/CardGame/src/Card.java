import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

	private Card(CardNumber cn, CardSuit cs) {
		this.cardNumber = cn;
		this.cardSuit = cs;
	}

	private final CardNumber cardNumber;
	private final CardSuit cardSuit;

	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public CardSuit getSuit() {
		return cardSuit;
	}

	public static List<Card> getCards() {
		List<Card> cardList = new ArrayList<Card>();
		for (CardSuit suits : CardSuit.values()) {
			for (CardNumber cardNums : CardNumber.values()) {
				Card card = new Card(cardNums, suits);
				cardList.add(card);
			}
		}
		return cardList;
	}

	public static void shuffleCards(List<Card> cards) {
		Collections.shuffle(cards);
	}

	public int compareTo(Card card) {
		if (this.getCardNumber() == card.getCardNumber()) {
			return 0;
		} else if (this.getCardNumber().getOrder() > card.getCardNumber().getOrder()) {
			return 1;
		} else
			return -1;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cardType=" + cardSuit + "]";
	}
}