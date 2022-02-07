import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author calbalad
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// adivinaNumero();
		// decodificarCadena();
		// JuegoDelNumero game = new JuegoDelNumero();
		// game.start();
		//Calculadora calc = new Calculadora();
		//System.out.println(calc.calcularCadena("3+4+3,4-7*1="));
//		System.out.println(calc.calcula("3", "+"));
//		System.out.println(calc.calcula("4", "+"));
//		System.out.println(calc.calcula("3,4", "-"));
//		System.out.println(calc.calcula("7", "*"));
//		System.out.println(calc.calcula("1", "="));
	}
	private static void adivinaNumero() {
		var rnd = new Random();
		int numeroAleatorio = rnd.nextInt(100);
		System.out.println("Número: " + numeroAleatorio);
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce número: ");
			String cadena = teclado.nextLine();
			try {
				int numeroIntroducido = Integer.parseInt(cadena);
				if (numeroAleatorio == numeroIntroducido) {
					System.out.println("¡Ganaste!");
					break;
				} else if (numeroAleatorio < numeroIntroducido) {
					System.out.println("El número es mayor");
				} else if (numeroAleatorio > numeroIntroducido) {
					System.out.println("El número es menor");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada no váida");
				if (i >= 0) {
					//Descontar si falla
					i--;
				}
			}
		}
		System.out.println("Fin del juego");

	}

	private static void decodificarCadena() {
		System.out.println("Introduce cadena: ");
		Scanner teclado = new Scanner(System.in);
		String cad = teclado.nextLine();
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(cad, "-+*=", true);
		while (st.hasMoreTokens()) {
			String id = st.nextToken();
			String desc = st.nextToken();
			list.add(id + " " + desc);
		}
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());

	}

}
