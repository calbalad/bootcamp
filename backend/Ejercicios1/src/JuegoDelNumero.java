import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JuegoDelNumero {

	int random;
	private int intentos;
	private boolean encontrado;
	private String resultado;

	public JuegoDelNumero() {
		inicializar();
	}

	public void start(String movimiento) {
		try {
			nextTurn(Integer.parseInt(movimiento));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("No es un número.");
		}
	}

	public void nextTurn(int numero) {
		if (getFinalizado()) {
			resultado = "El juego a finalizado";
		}
		intentos += 1;
		if (numero == random) {
			encontrado = true;
			resultado = "¡Ganaste!";
		} else if (intentos >= 10) {
        	resultado = "Se acabaron los intentos, el número era el " + random;
        } else if (numero < random) {
			resultado = "El número es mayor";
		} else if (numero > random) {
			resultado = "El número es menor";
		}
	}

	public boolean getFinalizado() {
		return intentos >= 10 || encontrado;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void inicializar() {
		random = (new Random()).nextInt(100) + 1;
		intentos = 0;
		encontrado = false;
		resultado = "Pendiente de empezar";
	}
	
	public int getJugada() {
		return intentos;
	}

}
