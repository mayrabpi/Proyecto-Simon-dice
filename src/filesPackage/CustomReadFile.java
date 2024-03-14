package filesPackage;

import java.io.*;
import java.util.Scanner;
/**
 * 
 */
public class CustomReadFile extends FileReader implements ICustomReadFile {
	
	public CustomReadFile(String nombreFichero) throws FileNotFoundException {
		super(nombreFichero);
		
	}
	public void closeReadFile() {
		
	}
	public void leerJugador() {
		try {
			FileReader entrada = new FileReader ("./src/data/top.text");
			int character;
			character = entrada.read();
			while(character!=-1) {
				System.out.print((char) character);
			}
			entrada.close();
			
			 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
