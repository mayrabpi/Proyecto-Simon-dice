package filesPackage;

import java.util.ArrayList;

import main.Jugador;

/**
 * interfaz  ICustomReadFile 
 */
public interface ICustomReadFile {
	public void closeReadFile();
	public ArrayList<Jugador> leerJugador();
		

}
