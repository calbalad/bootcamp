package com.christian;

import java.util.Iterator;
import java.util.function.Consumer;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.AbstractRowProcessor;

public class Juego {
	private Tablero elTablero;
	private Color elTurno;
	private boolean partidaActiva = false;
	private Consumer<Pieza> notifica;

	/**
	 * Constructor para la serie de n?meros aleatorios
	 * 
	 * @return Tablero: Devuelve el tablero de la partida ya clonado
	 * @throws JuegoException
	 */
	public Tablero getElTablero() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException();
		return (Tablero) elTablero.clone();
	}

	public Color getElTurno() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException();
		return elTurno;
	}

	public boolean isPartidaActiva() {
		return partidaActiva;
	}

	public void setPartidaActiva(boolean partidaActiva) {
		this.partidaActiva = partidaActiva;
	}

	public void Inicializar() throws JuegoException {
		elTurno = Color.BLANCO;
		elTablero = new Tablero();
		setPartidaActiva(true);
		elTablero.setEscaque(1, 1, new Torre(Color.BLANCO));
		elTablero.setEscaque(2, 1, new Caballo(Color.BLANCO));
		elTablero.setEscaque(3, 1, new Alfil(Color.BLANCO));
		elTablero.setEscaque(4, 1, new Dama(Color.BLANCO));
		elTablero.setEscaque(5, 1, new Rey(Color.BLANCO));
		elTablero.setEscaque(6, 1, new Alfil(Color.BLANCO));
		elTablero.setEscaque(7, 1, new Caballo(Color.BLANCO));
		elTablero.setEscaque(8, 1, new Torre(Color.BLANCO));
		for (int i = 1; i <= 8; i++) {
			elTablero.setEscaque(i, 2, new Peon(Color.BLANCO));
			elTablero.setEscaque(i, 7, new Peon(Color.NEGRO));
		}
		elTablero.setEscaque(1, 8, new Torre(Color.NEGRO));
		elTablero.setEscaque(2, 8, new Caballo(Color.NEGRO));
		elTablero.setEscaque(3, 8, new Alfil(Color.NEGRO));
		elTablero.setEscaque(4, 8, new Dama(Color.NEGRO));
		elTablero.setEscaque(5, 8, new Rey(Color.NEGRO));
		elTablero.setEscaque(6, 8, new Alfil(Color.NEGRO));
		elTablero.setEscaque(7, 8, new Caballo(Color.NEGRO));
		elTablero.setEscaque(8, 8, new Torre(Color.NEGRO));
	}

	/**
	 * Jugar nuevo movimiento
	 * 
	 * @param Movimiento: Movimieto en notaci?n internacional
	 */
	public void Jugada(String jugada) throws JuegoException {

		if (!partidaActiva)
			throw new JuegoException("No hay partida");

		Movimiento movimiento = new Movimiento(jugada);
		if (!elTablero.HayPieza(movimiento.getPosIni())) {
			throw new JuegoException("No hay pieza que mover");
		}

		if (elTablero.Escaque(movimiento.getPosIni()).Color().toString() != elTurno.toString()) {
			throw new JuegoException("La pieza no es tuya, turno de: " + elTurno.toString());
		}

		if (elTablero.HayPieza(movimiento.getPosFin())
				&& elTablero.Escaque(movimiento.getPosFin()).Color().toString() == elTurno.toString()) {
			throw new JuegoException("No te puedes comer a ti mismo");
		}
		Mover(movimiento);
		this.CambiaTurno();
	}

	private void Mover(Movimiento movimiento) throws JuegoException {
		elTablero.Escaque(movimiento.getPosIni()).Mover(movimiento, elTablero);
		
	}

	private void CambiaTurno() {
		if(elTurno == Color.BLANCO) {
			elTurno = Color.NEGRO;
		}else {
			elTurno = Color.BLANCO;
		}
	}
	
	public void Promociona(Object obj, PromocionEventArgs promocion) {
		
	}

	private void PromocionaPeon(Object obj, PromocionEventArgs evt) {
		evt.setP((Pieza) obj);
	}
}
