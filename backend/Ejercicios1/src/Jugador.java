import java.util.ArrayList;

public class Jugador {
	
	private ArrayList<Carta> mano = new ArrayList<Carta>();
	private String nombre;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public Jugador() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public Carta getCarta() {
		return this.mano.get(0);
	}

}
