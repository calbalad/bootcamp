package com.christian;

public class Caballo extends Pieza {
	
	
	public Caballo(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if(movimiento.SaltoVertical() == 2 && movimiento.SaltoHorizontal() == 1)
			return true;
		
		if(movimiento.SaltoVertical() == 1 && movimiento.SaltoHorizontal() == 2)
			return true;
		
		return false;
	}
}
