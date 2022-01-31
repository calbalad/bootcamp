import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

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
		comparar();

	}

	public static void barajar(ArrayList<Carta> baraja) {
		Collections.shuffle(baraja);
	}

	public static void iniciarJugadores() {
		for (int i = 0; i < numJugadores; i++) {
			System.out.println("Nombre del jugador " + (i + 1));
			Scanner sc = new Scanner(System.in);
	        String name = sc.nextLine();
			Jugador jugador = new Jugador(name);
			jugadores.add(jugador);
		}
	}

	public static void repartir(ArrayList<Jugador> jugadores, int numCartas) {
		for (int i = 0; i < numCartas; i++) {
			for (Jugador jugador : jugadores) {
				jugador.addCarta(baraja.get(baraja.size() - 1));
				baraja.remove(baraja.size() - 1);
			}
		}
	}

	public static void comparar() {
		Carta carta = jugadores.get(0).getCarta();
		Jugador jugadorGanador = jugadores.get(0);
		int max = jugadores.get(0).getCarta().getPuntuacion();
		for (Jugador jugador : jugadores) {
			if(max < jugador.getCarta().getPuntuacion()) {
				max = jugador.getCarta().getPuntuacion();
				carta = jugador.getCarta();
				jugadorGanador = jugador;
			}
		}
		System.out.println("La carta mas alta es del jugador: " + jugadorGanador.getNombre() + " , con la carta: " + carta.getValor() + " " + carta.getPalo());
	}

}
