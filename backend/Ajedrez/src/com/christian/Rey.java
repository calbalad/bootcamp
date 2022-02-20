package com.christian;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.SaltoVertical() > 1 || movimiento.SaltoHorizontal() > 1) {

			// Do castling logic here
			if (movimiento.posFin.getLaColumna() - movimiento.posIni.getLaColumna() == 2 && movimiento.EsHorizontal()) {
				// Castle kingside
				if (tablero.Escaque(movimiento.posIni.getLaColumna() + 1, movimiento.posFin.getLaFila()) != null
						|| tablero.Escaque(movimiento.posIni.getLaColumna() + 2,
								movimiento.posFin.getLaFila()) != null) {
					return false;
				}

			} else if (movimiento.SaltoVertical() == 3 && movimiento.EsHorizontal()) {
				if (tablero.Escaque(movimiento.posIni.getLaColumna() - 1, movimiento.posFin.getLaFila()) != null
						|| tablero.Escaque(movimiento.posIni.getLaColumna() - 2, movimiento.posFin.getLaFila()) != null
						|| tablero.Escaque(movimiento.posIni.getLaColumna() - 3,
								movimiento.posFin.getLaFila()) != null) {
					return false;
				}

			} else {
				return false;
			}

		}
		return true;
	}
}
