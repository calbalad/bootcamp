/**
 * 
 */

/**
 * @author calbalad
 *
 */
public class Carta {
	private String valor;
	private String palo;
	private int puntuacion;

	/**
	 * 
	 */
	public Carta(String valor, String palo, int puntuacion) {
		this.valor = valor;
		this.palo = palo;
		this.puntuacion = puntuacion;
	}

	public Carta() {
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	

}
