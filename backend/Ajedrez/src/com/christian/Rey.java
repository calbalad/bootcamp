package com.christian;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.SaltoVertical() > 1 || movimiento.SaltoHorizontal() > 1) {
			if (movimiento.posIni == movimiento.posFin) {
				return false;
			}
			if (movimiento.SaltoHorizontal() == 2
					&& movimiento.getPosIni().getLaColumna() == movimiento.getPosFin().getLaColumna()) {
				if (tablero.HayPieza(movimiento.getPosFin().getLaFila(), movimiento.getPosIni().getLaColumna() + 1)
						|| tablero.HayPieza(movimiento.getPosFin().getLaFila(),
								movimiento.getPosIni().getLaColumna() + 2)) {
					return false;
				}

			} else if (movimiento.SaltoHorizontal() == 3
					&& movimiento.getPosIni().getLaColumna() == movimiento.getPosFin().getLaColumna()) {
				if (tablero.HayPieza(movimiento.getPosFin().getLaColumna(), movimiento.getPosIni().getLaColumna() - 1)
						|| tablero.HayPieza(movimiento.getPosFin().getLaFila(),
								movimiento.getPosIni().getLaColumna() - 2)) {
					return false;
				}
			} else {
				return false;
			}
		}

		// hasMoved = true;
		return true;
	}
}
