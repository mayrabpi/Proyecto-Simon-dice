package filesPackage;

import java.io.*;
import java.util.Scanner;
/**
 * 
 */
public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	public CustomWriteFile(String nombreFichero) throws IOException {
		super(nombreFichero);

	}

	@Override
	public void escribirJugador(String chain) {
		String cadena;
		cadena = chain;
		try {
			FileWriter escritura = new FileWriter("./src/data/top.txt");
			for (int i = 0; i < cadena.length(); i++) {
				escritura.write(cadena.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void closeWriteFile() {

	}

}
