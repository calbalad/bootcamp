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


	private static void  ejercicio1() {
		var rnd = new Random();
		int num = rnd.nextInt(10);
		System.out.println(num);
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce número: ");
			String cad = teclado.nextLine();
			int inp = Integer.parseInt(cad);
			System.out.println(inp);
			if (num == inp) {
				System.out.println("Exito");
				break;
			}
		}
		
	}

}
