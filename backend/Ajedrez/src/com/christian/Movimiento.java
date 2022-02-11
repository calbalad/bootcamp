package com.christian;

public class Movimiento {
	public Posicion posIni;
	public Posicion posFin;

	public Movimiento(String movimiento) throws JuegoException {
		super();
		if (movimiento != null && movimiento.length() == 4) {
			this.posIni = new Posicion(movimiento.charAt(0), movimiento.charAt(1));
			this.posFin = new Posicion(movimiento.charAt(2), movimiento.charAt(3));
		} else {
			throw new JuegoException();
		}
	}

	public Posicion getPosIni() {
		return posIni;
	}

	public Posicion getPosFin() {
		return posFin;
	}

	public boolean EsVertical() {
		return posIni.getLaColumna() == posFin.getLaColumna() && posIni.getLaFila() != posFin.getLaFila();
	}

	public boolean EsHorizontal() {
		return posIni.getLaColumna() != posFin.getLaColumna() && posIni.getLaFila() == posFin.getLaFila();
	}

	public boolean EsDiagonal() throws JuegoException {
		return SaltoHorizontal() == SaltoVertical();
	}

	public int SaltoVertical() throws JuegoException {
		return Math.abs(posFin.getLaFila() - posIni.getLaFila());
	}

	public int SaltoHorizontal() throws JuegoException {
		return Math.abs(posFin.getLaColumna() - posIni.getLaColumna());
	}

	public int deltaFila() throws JuegoException {
		if (posFin.getLaFila() < posIni.getLaFila())
			return -1;
		else if (posFin.getLaFila() > posIni.getLaFila()) 
			return 1;
		else
			return 0;
	}

	public int deltaColumna() throws JuegoException {
		if (posFin.getLaColumna() < posIni.getLaColumna())
			return -1;
		else if (posFin.getLaColumna() > posIni.getLaColumna())
			return 1;
		else
			return 0;
	}

}
