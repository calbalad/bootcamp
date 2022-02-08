
public class Juego {

	public static void main(String[] args) {
		CardGame cardGame = new CardGame();
		cardGame.createMultiplePlayer(2, 5);
		var plyrs = cardGame.getPlayers();
		for (Player player : plyrs) {
			System.out.println(cardGame.getCardsPlayer(player));
		}
		cardGame.deleteCardFromHand(cardGame.getCardsPlayer(cardGame.getPlayers().get(0)).get(0), cardGame.getPlayers().get(0));
		for (Player player : plyrs) {
			System.out.println(cardGame.getCardsPlayer(player));
		}
	}
}
