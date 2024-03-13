package filesPackage;

import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 */
public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	public CustomWriteFile(String nombreFichero) throws IOException {
		super(nombreFichero);
		// TODO Auto-generated constructor stub
	}
	public void closeWriteFile() {
		
	}
	public void escribirJugador() {
		
	}

}
