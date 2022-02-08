package com.christian;

public class Rey extends Pieza {
	
	
	public Rey(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}
}
