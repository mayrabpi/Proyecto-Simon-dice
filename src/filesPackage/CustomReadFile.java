package filesPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	
	public CustomReadFile(String nombreFichero) throws FileNotFoundException {
		super(nombreFichero);
		// TODO Auto-generated constructor stub
	}
	public void closeReadFile() {
		
	}
	public void leerJugador() {
		
	}

}
