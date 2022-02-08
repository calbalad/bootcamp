package com.christian;

public class Posicion {
	private int laFila;
	private int laColumna;

	public Posicion(int laFila, int laColumna) {
		super();
		this.laFila = laFila;
		this.laColumna = laColumna;
	}
	
	public Posicion(char laFila, char laColumna) {
		super();
		this.laFila = laFila;
		this.laColumna = laColumna;
	}

	public int getLaFila() {
		return laFila;
	}

	public void setLaFila(int laFila) {
		this.laFila = laFila;
	}

	public int getLaColumna() {
		return laColumna;
	}

	public void setLaColumna(int laColumna) {
		this.laColumna = laColumna;
	}

	public boolean Equals(Posicion posicion) {
		 if (posicion.equals(this)) {
				return true;
			} else {
			 return false;
		 }
	}

}
