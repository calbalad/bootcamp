import java.util.ArrayList;

public class Jugador {
	
	private ArrayList<Carta> mano = new ArrayList<Carta>();

	public Jugador() {
		
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public void addCarta(Carta carta) {
		this.mano.add(carta);
	}

}
