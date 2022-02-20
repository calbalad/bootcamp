package com.christian;

public class Dama extends Pieza {

	public Dama(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.EsHorizontal() || movimiento.EsVertical() || movimiento.EsDiagonal()) {
			if (!tablero.HayPiezasEntre(movimiento)) {
				return true;
			}	
			
		}
		return false;
	}
}
