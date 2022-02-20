package com.christian;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];

	/**
	 * Devuelve la pieza del escaque solicitado
	 * 
	 * @param Columna: 1, Fila: 1
	 * @return devuelce la Pieza
	 */
	public Pieza Escaque(int posicion1, int posicion2) {
		return piezas[posicion1 - 1][posicion2 - 1];
	}

	/**
	 * Devuelve la pieza del escaque solicitado
	 * 
	 * @param Columna: 'A', Fila: '1'
	 * @return devuelce la Pieza
	 */
	public Pieza Escaque(Posicion posicion) {
		return piezas[posicion.getLaColumna() - 1][posicion.getLaFila() - 1];
	}

	public void setEscaque(int posicion1, int posicion2, Pieza pieza) {
		piezas[posicion1 - 1][posicion2 - 1] = pieza;
	}

	public void setEscaque(Posicion posicion, Pieza pieza) {
		piezas[posicion.getLaColumna() - 1][posicion.getLaFila() - 1] = pieza;
	}

	private boolean esValido(int pos) {
		if (pos >= 1 && pos <= 8)
			return true;
		return false;
	}

	public boolean HayPieza(int posicion1, int posicion2) {
		if (esValido(posicion1) && esValido(posicion2))
			if (piezas[posicion1 - 1][posicion2 - 1] == null) {
				return false;
			}
		return true;
	}

	public boolean HayPieza(Posicion posicion) {
		if (piezas[posicion.getLaColumna() - 1][posicion.getLaFila() - 1] == null)
			return false;
		return true;
	}

	public void QuitaPieza(int posicion1, int posicion2) {
		if (esValido(posicion1) && esValido(posicion2))
			piezas[posicion1 - 1][posicion2 - 1] = null;
	}

	public void QuitaPieza(Posicion posicion) {
		piezas[posicion.getLaColumna() - 1][posicion.getLaFila() - 1] = null;
	}

	/**
	 * Mueve la pieza pasando la posición en notación internacional
	 * 
	 * @param A2A3
	 */
	public void Mover(Movimiento movimiento) throws JuegoException {
		setEscaque(movimiento.getPosFin().getLaColumna(), movimiento.getPosFin().getLaFila(),
				Escaque(movimiento.getPosIni().getLaColumna(), movimiento.getPosIni().getLaFila()));
		QuitaPieza(movimiento.getPosIni().getLaColumna(), movimiento.getPosIni().getLaFila());
	}

	@Override
	public Object clone() {
		Tablero tablero = new Tablero();
		tablero.piezas = piezas.clone();
		return tablero;
		}

	public Color ColorEscaque(int posicion1, int posicion2) {
		if ((posicion1 + posicion2) % 2 != 0)
			return Color.NEGRO;
		return Color.BLANCO;
	}

	public boolean HayPiezasEntre(Movimiento movimiento) throws JuegoException {
		var flag = false;
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
			if (this.Escaque(x, y) != null) {
				if (this.Escaque(x, y).Color() ==  Escaque(movimiento.posFin.getLaColumna(), movimiento.posFin.getLaFila()).Color()) 
					return true;
			}
			y += colOffset;
		}
		return flag;
	}

}
