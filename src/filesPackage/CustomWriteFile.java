package filesPackage;

import java.io.*;
/**
 * 
 */
public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	
	public CustomWriteFile(String chain) throws IOException {
		super(chain);
		

	}

	@Override
	public void escribirJugador(String cadena) {
		try {
			this.write(cadena);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	@Override
	public void closeWriteFile() {
		try {
			this.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}






/*String cadena;
cadena = chain;
try {
	FileWriter escritura = new FileWriter("./src/data/top.txt");
	for (int i = 0; i < cadena.length(); i++) {
		escritura.write(cadena.charAt(i));
	}
	escritura.close();
} catch (IOException e) {

	e.printStackTrace();
}*/
