package com.christian;

public class Juego {
	private Tablero elTablero;
	private Color elTurno;
	private boolean partidaActiva = false;

	public Tablero getElTablero() {
		return (Tablero) elTablero.Clone();
	}

	public Color getElTurno() {
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
		setPartidaActiva(true);
		elTablero = getElTablero();
		elTablero.setEscaque(new Posicion(1, 1), new Torre(Color.BLANCO));
		elTablero.setEscaque(new Posicion(2, 1), new Caballo(Color.BLANCO));
		elTablero.setEscaque(new Posicion(3, 1), new Alfil(Color.BLANCO));
		elTablero.setEscaque(new Posicion(4, 1), new Dama(Color.BLANCO));
		elTablero.setEscaque(new Posicion(5, 1), new Rey(Color.BLANCO));
		elTablero.setEscaque(new Posicion(6, 1), new Alfil(Color.BLANCO));
		elTablero.setEscaque(new Posicion(7, 1), new Caballo(Color.BLANCO));
		elTablero.setEscaque(new Posicion(8, 1), new Torre(Color.BLANCO));
		for (int i = 0; i < 8; i++) {
			elTablero.setEscaque(new Posicion(i, 2), new Peon(Color.BLANCO));
			elTablero.setEscaque(new Posicion(i, 7), new Peon(Color.NEGRO));
		}
		elTablero.setEscaque(new Posicion(1, 8), new Torre(Color.NEGRO));
		elTablero.setEscaque(new Posicion(2, 8), new Caballo(Color.NEGRO));
		elTablero.setEscaque(new Posicion(3, 8), new Alfil(Color.NEGRO));
		elTablero.setEscaque(new Posicion(4, 8), new Dama(Color.NEGRO));
		elTablero.setEscaque(new Posicion(5, 8), new Rey(Color.NEGRO));
		elTablero.setEscaque(new Posicion(6, 8), new Alfil(Color.NEGRO));
		elTablero.setEscaque(new Posicion(7, 8), new Caballo(Color.NEGRO));
		elTablero.setEscaque(new Posicion(8, 8), new Torre(Color.NEGRO));
	}

	public void Jugada(String string) throws JuegoException {
		Movimiento movimiento = new Movimiento(string);
		Mover(movimiento);
	}

	private void Mover(Movimiento movimiento) throws JuegoException {
		this.elTablero.Mover(movimiento);
	}

	private void CambiaTurno() {
		elTurno = (elTurno == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;
	}

	private void PromocionaPeon(Object obj, PromocionEventArgs evt) {

	}
}
