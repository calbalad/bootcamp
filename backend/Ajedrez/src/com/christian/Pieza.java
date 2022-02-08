package com.christian;

public class Pieza {
	private Color elColor;
	
	public Color Color() {
		return elColor;
	}

	
	public Pieza(com.christian.Color elColor) {
		super();
		this.elColor = elColor;
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}
	
	public void Mover(Movimiento movimiento, Tablero tablero) {
		
	}
}
