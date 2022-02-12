package com.christian;

public class Tablero {
	private Pieza[][] tablero = new Pieza[8][8];

	public Pieza Escaque(int posicion1, int posicion2) {
		return tablero[posicion1 - 1][posicion2 - 1];
	}

	public Pieza Escaque(Posicion posicion) {
		return tablero[posicion.getLaColumna() - 1][posicion.getLaFila() - 1];
	}

	public void setEscaque(int posicion1, int posicion2, Pieza pieza) {
		tablero[posicion1 - 1][posicion2 - 1] = pieza;
	}

	public void setEscaque(Posicion posicion, Pieza pieza) {
		tablero[posicion.getLaColumna() - 1][posicion.getLaFila() - 1] = pieza;
	}

	private boolean esValido(int pos) {
		if (pos >= 1 && pos <= 8)
			return true;
		return false;
	}

	public boolean HayPieza(int posicion1, int posicion2) {
		if (esValido(posicion1) && esValido(posicion2))
			if (tablero[posicion1 - 1][posicion2 - 1] == null)
				return false;
		return true;
	}

	public boolean HayPieza(Posicion posicion) {
		if (tablero[posicion.getLaColumna() - 1][posicion.getLaFila() - 1] == null)
			return false;
		return true;
	}

	public void QuitaPieza(int posicion1, int posicion2) {
		if (esValido(posicion1) && esValido(posicion2))
			tablero[posicion1 - 1][posicion2 - 1] = null;
	}

	public void QuitaPieza(Posicion posicion) {
		tablero[posicion.getLaColumna() - 1][posicion.getLaFila() - 1] = null;
	}

	public void Mover(Movimiento movimiento) throws JuegoException {
		if (HayPieza(movimiento.getPosIni()) && !HayPiezasEntre(movimiento)) {
			setEscaque(movimiento.getPosIni().getLaColumna()-1,movimiento.getPosIni().getLaFila()-1, Escaque(movimiento.getPosIni().getLaColumna()-1, movimiento.getPosIni().getLaFila()-1));
			QuitaPieza(movimiento.getPosIni().getLaColumna()-1, movimiento.getPosIni().getLaFila()-1);
		}
	}

	public Object Clone() {
		return tablero.clone();
	}

	public Color ColorEscaque(int posicion1, int posicion2) {
		if ((posicion1 + posicion2) % 2 != 0)
			return Color.NEGRO;
		return Color.BLANCO;
	}

	public boolean HayPiezasEntre(Movimiento movimiento) throws JuegoException {
		if (movimiento.EsVertical()) {
			for (int i = 1; i < movimiento.SaltoVertical(); i++) {
				if (HayPieza(movimiento.getPosIni().getLaColumna(),
						movimiento.getPosIni().getLaFila() + (i * movimiento.deltaFila()))) 
					return true;
			}
		} else if (movimiento.EsHorizontal()) {
			for (int i = 1; i < Math.abs(movimiento.SaltoHorizontal()); i++) {
				if (HayPieza(movimiento.getPosIni().getLaColumna() + (i * movimiento.deltaColumna()),
						movimiento.getPosIni().getLaFila()))
					return true;
			}

		} else if (movimiento.EsHorizontal()) {
			for(int i = 1; i < Math.abs(movimiento.SaltoHorizontal()) ; i++ ) {
				if (HayPieza(movimiento.getPosIni()
						.getLaColumna()+(i * movimiento.deltaColumna()), movimiento.getPosIni().getLaFila()+(i * movimiento.deltaFila()))) {
					return true;
				}
			}
		}
		return false;
	}

}
