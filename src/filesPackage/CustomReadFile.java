package filesPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import main.Jugador;

/**
 * 
 */
public class CustomReadFile extends FileReader implements ICustomReadFile {

	private Scanner sc;

	public CustomReadFile(String leeFichero) throws FileNotFoundException {
		super(leeFichero);
		this.sc = new Scanner(this);
	}
	@Override
	public ArrayList<Jugador> leerJugador() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		while (this.sc.hasNextLine()) {
			int puntos =this.sc.nextInt();
			String cadena =this.sc.nextLine();
			
			Jugador jugador = new Jugador(cadena);	
			jugador.setPuntuacion(puntos);
			jugadores.add(jugador);
		
			//System.out.println(cadena);
		}
		closeReadFile();
		return jugadores;
	}
	@Override
	public void closeReadFile() {
		try {
			this.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	

}


/*
 * try { FileReader entrada = new FileReader ("./src/data/top.text"); int
 * character; character = entrada.read(); while(character!=-1) {
 * System.out.print((char) character); } entrada.close();
 * 
 * 
 * } catch (IOException e) {
 * 
 * e.printStackTrace(); }
 */
