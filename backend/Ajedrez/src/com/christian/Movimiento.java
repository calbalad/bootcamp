package com.christian;

public class Movimiento {
	public Posicion posIni;
	public Posicion posFin;

	public Movimiento(String movimiento) {
		super();
		this.posIni = new Posicion(movimiento.charAt(0), movimiento.charAt(1));
		this.posFin = new Posicion(movimiento.charAt(2), movimiento.charAt(3));
	}

	public Posicion getPosIni() {
		return posIni;
	}

	public void setPosIni(Posicion posIni) {
		this.posIni = posIni;
	}

	public Posicion getPosFin() {
		return posFin;
	}

	public void setPosFin(Posicion posFin) {
		this.posFin = posFin;
	}
	
	public boolean EsVertical() {
		return true;
	}
	
	public boolean EsHorizontal() {
		return true;
	}
	
	public boolean EsDiagonal() {
		return true;
	}
	
	public int SaltoVertical() {
		return 0;
	}
	
	public int SaltoHorizontal() {
		return 0;
	}
	
	public int deltaFila() {
		return 0;
	}
	
	public int SaltodeltaColumna() {
		return 0;
	}
	
	
	
}
