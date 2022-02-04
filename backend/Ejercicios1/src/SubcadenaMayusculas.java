import java.util.Arrays;

public class SubcadenaMayusculas {
	String cadena;
	String subCadena;
	
	
	public SubcadenaMayusculas(String cadena, String subCadena) {
		super();
		this.cadena = cadena;
		this.subCadena = subCadena;
	}
	
	public String convertir () {
		String[] parts = cadena.split(" ");
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals(subCadena)) {
				parts[i] = parts[i].toUpperCase();
			}
		}
		
		return String.join(" ",parts);
	}
	
	
	
	
	
}
