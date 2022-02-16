package com.christian;

public class Peon extends Pieza {

	public Peon(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (Avanza(movimiento) && !tablero.HayPieza(movimiento.getPosFin())) {
			return true;
		} else if (PuedeComer(movimiento, tablero)) {
			return true;
		}
		return false;
		
	}

	private boolean Avanza(Movimiento movimiento) throws JuegoException {
		if ((movimiento.SaltoVertical() == movimiento.deltaColumna()) && movimiento.SaltoHorizontal() == 0)
			return true;
		return false;
	}

	private boolean Inicia(Movimiento movimiento) {
		return true;
	}

	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.EsDiagonal() && (movimiento.SaltoHorizontal() == movimiento.deltaFila())
				&& tablero.HayPieza(movimiento.getPosFin()))
			if (tablero.Escaque(movimiento.getPosFin()).Color() != tablero.Escaque(movimiento.getPosIni()).Color())
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
			tablero.QuitaPieza(movimiento.getPosFin());
			if (tablero.Escaque(movimiento.getPosIni().getLaColumna() - 1, movimiento.getPosIni().getLaFila() - 1)
					.esValido(movimiento, tablero)) {
				tablero.setEscaque(movimiento.getPosFin(), tablero.Escaque(movimiento.getPosIni().getLaColumna() - 1,
						movimiento.getPosIni().getLaFila() - 1));
			}
		} else {
			throw new JuegoException("Movimiento no valido");
		}
	}

	protected void onPromocion(PromocionEventArgs promo) {

	}

}
