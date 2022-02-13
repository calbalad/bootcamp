package com.christian;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.posIni == movimiento.posFin)
			return false;

		if (movimiento.SaltoVertical() != movimiento.SaltoHorizontal())
			return false;

		int rowOffset, colOffset;

		if (movimiento.posIni.getLaFila() < movimiento.posFin.getLaFila()) {
			rowOffset = 1;
		} else {
			rowOffset = -1;
		}

		if (movimiento.posIni.getLaColumna() < movimiento.posFin.getLaColumna()) {
			colOffset = 1;
		} else {
			colOffset = -1;
		}

		int y = movimiento.posIni.getLaColumna() + colOffset;
		for (int x = movimiento.posIni.getLaFila() + rowOffset; x != movimiento.posFin.getLaFila(); x += rowOffset) {
			if (tablero.Escaque(x, y) != null) {
				return false;
			}
			y += colOffset;
		}

		return true;
	}
}
