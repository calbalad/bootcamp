package com.christian;

public class Peon extends Pieza {

	public Peon(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (this.Avanza(movimiento) && !tablero.HayPieza(movimiento.getPosFin())) {
			return true;
		} else if (PuedeComer(movimiento, tablero)) {
			return true;
		}
		return false;
	}

	private boolean Avanza(Movimiento movimiento) throws JuegoException {
		if (NecesitaPromocion(movimiento.getPosIni())) {
			
		}
		
		if (movimiento.SaltoVertical() == 1 && movimiento.SaltoHorizontal() == 0)
			return true;
		
		if (movimiento.getPosIni().getLaFila() == 2 && this.Color().toString() == Color.BLANCO.toString()
				&& (movimiento.SaltoVertical() == 1 || movimiento.SaltoVertical() == 2))
			return true;

		if (movimiento.getPosIni().getLaFila() == 7 && this.Color().toString() == Color.NEGRO.toString()
				&& (movimiento.SaltoVertical() == 1 || movimiento.SaltoVertical() == 2))
			return true;


		return false;
	}

	private boolean Inicia(Movimiento movimiento) {
		return true;
	}

	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.EsDiagonal() && movimiento.SaltoHorizontal() == 1 && tablero.HayPieza(movimiento.getPosFin())
				&& (tablero.Escaque(movimiento.getPosFin()).Color() != this.Color()))
			return true;

		return false;
	}

	private boolean NecesitaPromocion(Posicion posicion) {
		if (this.Color() == Color.NEGRO) {
			if (posicion.getLaColumna() == 1)
				return true;
		} else {
			if (posicion.getLaColumna() == 8)
				return true;
		}
		return false;
	}

	@Override
	public void Mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (esValido(movimiento, tablero)) {
			tablero.Mover(movimiento);
		} else {
			throw new JuegoException("Movimiento no valido");
		}
	}

	protected void onPromocion(PromocionEventArgs promo) {
		
	}
	
	public void Promocion(Object obj, PromocionEventArgs promocion) {
		
	}

}
