package com.christian;

public abstract class Pieza {
	private Color elColor;

	public Color Color() {
		return elColor;
	}

	public Pieza(Color elColor) {
		super();
		this.elColor = elColor;
	}

	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException;

	public void Mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (esValido(movimiento, tablero)) {
			tablero.Mover(movimiento);
		} else {
			throw new JuegoException("Movimiento no valido");
		}
	}
}
