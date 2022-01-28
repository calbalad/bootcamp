import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

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
		ejercicio1();

	}

	private static void ejercicio1() {
		var rnd = new Random();
		int num = rnd.nextInt(100);
		System.out.println("Número: " + num);
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce número: ");
			String cad = teclado.nextLine();
			try {
				int inp = Integer.parseInt(cad);
				if (num == inp) {
					System.out.println("¡Ganaste!");
					break;
				} else if (num < inp) {
					System.out.println("El número es mayor");
				} else if (num > inp) {
					System.out.println("El número es menor");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada no váida");
				if (i >= 0) {
					i--;
				}
			}
		}
		System.out.println("Fin del juego");

	}
	
	

}
