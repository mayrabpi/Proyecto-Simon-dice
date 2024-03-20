package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import filesPackage.CustomReadFile;
import filesPackage.CustomWriteFile;

/**
 * clase Record
 * 
 */
public class Record {
	private final int MAX_JUGADORES =10;
	private int contador;
	private Jugador jugadores[];
	private Scanner entrada;

	/**
	 * constructor
	 */
	public Record() {
		this.contador = 0;
		this.jugadores = new Jugador[MAX_JUGADORES];
		this.entrada = new Scanner(System.in);
	}

	/**
	 * Metodo para añadir jugadores al array
	 * 
	 * @param jugador de la clase Jugador complejidad O1
	 */
	public void addJugador(Jugador jugador) {
		if (this.contador <this.MAX_JUGADORES) {
			this.jugadores[contador] = jugador;
			this.contador++;

		} else 
			System.out.println("No hay espacio disponible ");
	}
	
	/**
	 * Ordena el Array, usaremos un algoritmo de ordenacion el metodo de la burbuja
	 * complejidad 0(n)
	 */
	public void ordenarRanking() {
		for (int i = 0; i < this.contador; i++) {
			for (int j = 0; j < this.contador - i - 1; j++) {
				if (this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					Jugador guardar = this.jugadores[j + 1];
					this.jugadores[j + 1] = this.jugadores[j];
					this.jugadores[j] = guardar;
				}
			}
		}
	}

	/**
	 * showRanking , muestra los 10 mejores jugadores 
	 */
	public void showRanking() {
		System.out.println("Los 10 mejores jugadores son: ");
		int puesto = 0;
		for (int i = 0; i < this.contador; i++) {
			puesto++;
			System.out.println(puesto + ". " + this.jugadores[i].getNombre() + " " + this.jugadores[i].getPuntuacion());		
		}
		entrada.hasNextLine();
	}

	/**
	 * Muestra el jugador (o jugadores) con la puntuacion mas alta
	 */
	public void showBestPlayer() {
		int i = 0;
		System.out.println("El (Los) mejor(es) jugador(es): ");

		while (i < this.MAX_JUGADORES) {

			if (this.jugadores[i].getPuntuacion() == this.jugadores[0].getPuntuacion() && i <= this.contador) {

				System.out.println(this.jugadores[0].getPuntuacion() + " " + this.jugadores[i].getNombre());
				i++;
			}
		}
	}
	/**
	 * metodo escribir ranking para escribir los jugadores en un fichero 
	 * @throws IOException
	 */
	public void escribirRanking() throws IOException {
		try (CustomWriteFile e = new CustomWriteFile("./src/data/top.txt")) {
			String cadena = "";
			for (int i = 0; i < this.contador; i++) {
				 cadena= this.jugadores[i].getPuntuacion() + " " + this.jugadores[i].getNombre()+ "\n";	
				 //System.out.println(this.jugadores[i].getNombre());
				 e.escribirJugador(cadena);
			}
			 e.closeWriteFile();
		}
	}
	
	/**
	 * carga el ranking
	 * @throws IOException
	 */
	public void cargarRanking() throws IOException {
		try (CustomReadFile cargar = new CustomReadFile("./src/data/top.txt")) {
			ArrayList<Jugador> jugador = new ArrayList<Jugador>();
			jugador = cargar.leerJugador();
			int i =0;
			while(i<jugador.size() && i< this.MAX_JUGADORES) {
				addJugador(jugador.get(i));
				i++;
			}
			cargar.closeReadFile();
		}
		
	}
}






//this.jugadores[this.contador-1]=jugador;
