package com.christian;

public class Posicion {
	private int laFila;
	private int laColumna;
	
	/**
	 * Crear posición con enteros
	 * @param Columna: 1, Fila: 1
	 */
	public Posicion(int laColumna, int laFila) throws JuegoException {
		super();
		if (laFila >= 1 && laFila <= 8 && laColumna >= 1 &&  laColumna <= 8) {
			this.laFila = laFila;
			this.laColumna = laColumna;
		} else {
			throw new JuegoException();
		}
	}
	
	/**
	 * Crear posición con chars
	 * @param Columna: 'A', Fila: '1'
	 */
	public Posicion(char laColumna, char laFila) throws JuegoException {
		super();
		if (Character.isDigit(laFila)) 
			laFila = (char) Character.getNumericValue(laFila);
		int columna = Math.abs(((65 - laColumna))) + 1;
		if (columna >= 1 && columna <= 8 && laFila >= 1 &&  laFila <= 8) {
			this.laFila = laFila;
			this.laColumna = columna;
		}else {
			throw new JuegoException();
		}
	}

	public int getLaFila() {
		return laFila;
	}


	public int getLaColumna() {
		return laColumna;
	}


	public boolean Equals(Posicion posicion) {
		if (posicion.laColumna == this.laColumna && posicion.laFila == this.laFila) 
			return true;
		return false;
	}
}
