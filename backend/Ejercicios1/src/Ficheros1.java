import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Ficheros1 {
	public static void main(String[] args) throws Exception {
		leeFichero("C:\\Eclipse\\curso\\backend\\Ejercicios1\\src\\Entrada.txt");
		creaFichero("Salida.txt");
		zip("C:\\Eclipse\\curso\\backend\\Ejercicios1\\src\\Salida.txt",
				"C:\\\\Eclipse\\\\curso\\\\backend\\\\Ejercicios1\\\\src\\\\compressed.zip");
		unzip("C:\\Eclipse\\curso\\backend\\Ejercicios1\\src\\compressed.zip",
				"C:\\Eclipse\\curso\\backend\\Ejercicios1\\src\\test");
	}

	public static void leeFichero(String inFichero) throws IOException {
		try {
			File fichero = new File(inFichero);
			Scanner lectorFichero = new Scanner(fichero);
			while (lectorFichero.hasNextLine()) {
				String data = lectorFichero.nextLine();
				Calculadora calc = new Calculadora();
				double res = calc.calcularCadena(data);
				escribir(calc.getCadena(), Double.toString(res),
						"C:\\Eclipse\\curso\\backend\\Ejercicios1\\src\\Salida.txt");
			}
			lectorFichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el fichero.");
			e.printStackTrace();
		}
	}

	public static void creaFichero(String to) {
		File myObj = new File(to);
	}

	public static void escribir(String cadena, String resultado, String archivo) throws IOException {
		File log = new File(archivo);
		try {
			if (!log.exists()) {
				log.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(log, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(cadena);
			bufferedWriter.write("----------\n");
			bufferedWriter.write(resultado + "\n\n\n");
			bufferedWriter.close();
		} catch (IOException e) {
			throw new IOException("No existe log");
		}
	}

	public static void zip(String file, String to) throws Exception {
		String sourceFile = file;
		FileOutputStream fos = new FileOutputStream(to);
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		File fileToZip = new File(sourceFile);
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		zipOut.close();
		fis.close();
		fos.close();
	}

	public static void unzip(String file, String to) throws IOException {
		String fileZip = file;
		File destDir = new File(to);
		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
		ZipEntry zipEntry = zis.getNextEntry();
		while (zipEntry != null) {
			File newFile = newFile(destDir, zipEntry);
			if (zipEntry.isDirectory()) {
				if (!newFile.isDirectory() && !newFile.mkdirs()) {
					throw new IOException("Error al crear el directorio " + newFile);
				}
			} else {
				File parent = newFile.getParentFile();
				if (!parent.isDirectory() && !parent.mkdirs()) {
					throw new IOException("Error al crear el directorio " + parent);
				}
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
			}
			zipEntry = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
	}

	public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
		File destFile = new File(destinationDir, zipEntry.getName());

		String destDirPath = destinationDir.getCanonicalPath();
		String destFilePath = destFile.getCanonicalPath();

		if (!destFilePath.startsWith(destDirPath + File.separator)) {
			throw new IOException("La entrada esta fuera del fichero destino: " + zipEntry.getName());
		}

		return destFile;
	}

}
