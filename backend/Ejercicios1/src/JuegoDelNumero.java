import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JuegoDelNumero {

	private int random;
    private int intentos;
    private boolean encontrado;
    private String resultado;

	public JuegoDelNumero() {
	}

	public void start() {
		String command;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("commands: salir, jugar");
			System.out.print(">> ");

			command = input.next();

			if (command.equals("salir")) {
				return;
			}

			if (command.equals("jugar")) {
				inicializar();
			} else {
				System.out.println("comando desconocido");
			}
		}
	}

	private void nextTurn(int numero) {
		System.out.println("N�mero: " + random);
		try {
			if (numero == random) {
				encontrado = true;
				resultado = "�Ganaste!";
			} else if (numero < random) {
				resultado = "El n�mero es mayor";
			} else if (numero > random) {
				resultado = "El n�mero es menor";
			}
		} catch (NumberFormatException e) {
			resultado = "Entrada no v�ida";
		}
	}
	
	public void inicializar() {
	     random = (new Random()).nextInt(100) + 1;
	     intentos = 0;
	     encontrado = false;
	     resultado = "Pendiente de empezar";
		}

}
