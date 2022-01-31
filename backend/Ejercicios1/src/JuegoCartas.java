import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author calbalad
 *
 */
public class JuegoCartas {

	static ArrayList<Carta> baraja = new ArrayList<Carta>();
	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	static int numJugadores = 2;

	/**
	 * 
	 */
	public JuegoCartas() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		iniciarJugadores();
		baraja = Baraja.iniciarBaraja();
		barajar(baraja);
		System.out.println(baraja.size());
		repartir(jugadores, 5);
		System.out.println(baraja.size());
	}

	public static void barajar(ArrayList<Carta> baraja) {
		Collections.shuffle(baraja);
	}

	public static void iniciarJugadores() {
		for (int i = 0; i < numJugadores; i++) {
			Jugador jugador = new Jugador();
			jugadores.add(jugador);
		}
	}
	
	public static void repartir(ArrayList<Jugador> jugadores, int numCartas) {
		for (int i = 0; i < numCartas; i++) {
			for (Jugador jugador : jugadores) {
				jugador.addCarta(baraja.get(baraja.size()-1));
				baraja.remove(baraja.size()-1);
			}
		}
	}
	
	
	public static void comparar(Carta carta1, Carta  carta2) {
		// TODO: añadir comparaciones con puntuaciones
		if (carta1.getPalo() == carta2.getPalo() && carta1.getValor() == carta2.getValor()) {
			System.out.println("Son iguales");
		}
	}

}
