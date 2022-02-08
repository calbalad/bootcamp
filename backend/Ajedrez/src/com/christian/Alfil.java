package com.christian;

public class Alfil extends Pieza {
	
	
	public Alfil(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}
}
