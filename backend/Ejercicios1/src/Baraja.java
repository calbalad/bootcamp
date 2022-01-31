import java.util.ArrayList;

public class Baraja {

	private ArrayList<Carta> baraja;

	public Baraja() {
		
	}
	
	/**
	 * Inicia la baraja de cartas creando una lista de cartas.
	 */

	public static ArrayList<Carta> iniciarBaraja() {
		String[] palo = {"Picas","Corazones","Diamantes","Tréboles"};
		String[] carta = {"as","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez","jota","reina","rey"};
		ArrayList<Carta> baraja = new ArrayList<Carta>();
		for (int i = 0; i < palo.length; i++) {
			for (int j = 0; j < carta.length; j++) {
				baraja.add(new Carta(carta[j], palo[i], j + 1));
			}
		}
		return baraja;
	}
}
