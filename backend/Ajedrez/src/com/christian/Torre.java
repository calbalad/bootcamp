package com.christian;

public class Torre extends Pieza {
	
	
	public Torre(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.EsVertical() | movimiento.EsHorizontal()) {
			if ((tablero.HayPieza(movimiento.getPosFin()) && tablero.Escaque(movimiento.getPosFin()).Color() != tablero.Escaque(movimiento.getPosIni()).Color())) {
				return true;
			}else if(!tablero.HayPieza(movimiento.getPosFin())){
				return true;
			}
		}
		return false;
	}
}
