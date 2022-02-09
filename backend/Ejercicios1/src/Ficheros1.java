import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros1 {
	public static void main(String[] args) {
		leeFichero();
		creaFichero();
	}


	public static void leeFichero() {
		try {
			File fichero = new File("C:\\Eclipse\\curso\\backend\\Ejercicios1\\src\\Entrada.txt");
			Scanner lectorFichero = new Scanner(fichero);
			while (lectorFichero.hasNextLine()) {
				String data = lectorFichero.nextLine();
				Calculadora calc = new Calculadora();
				double res = calc.calcularCadena(data);
				escribir(calc.getCadena(), Double.toString(res));
				System.out.println(data);
				System.out.println(calc.getCadena());
			}
			lectorFichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el fichero.");
			e.printStackTrace();
		}
	}

	public static void creaFichero() {
		File myObj = new File("Salida.txt");
	}
	
	public static void escribir(String cadena, String resultado) {
		try {
		      FileWriter myWriter = new FileWriter("C:\\\\Eclipse\\\\curso\\\\backend\\\\Ejercicios1\\\\src\\\\Salida.txt");
		      myWriter.write(cadena);
		      myWriter.write("----------\n");
		      myWriter.write(resultado);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
