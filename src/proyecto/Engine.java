package proyecto;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase Motor
 * 
 * @author Mayra
 */
public class Engine {

	public enum tColores {
		ROJO, VERDE, AZUL, DORADO;
	}

	private Scanner entrada = new Scanner(System.in);
	private Scanner entrada1 = new Scanner(System.in);
	final int max_colores_seq = 12;
	private tColores[] secuenciaColores = new tColores[max_colores_seq];
	private String nombre;

	/**
	 * constructor
	 */
	public Engine() {

		this.nombre = entrada.nextLine();

	}

	/**
	 * metodo charToColor, este método recibe un char y devuelve un color del tipo
	 * enum tColeres
	 * 
	 * @param _color representa el caracter del color introducido por el usuario
	 * @return
	 */
	public tColores charToColor(char _color) {
		char charColor = Character.toUpperCase(_color);

		switch (charColor) {
		case 'R':
			return tColores.ROJO;
		case 'V':
			return tColores.VERDE;
		case 'A':
			return tColores.AZUL;
		case 'D':
			return tColores.DORADO;
		default:
			return null;

		}

	}

	/**
	 * Metodo intoColor, este método recibe un int y devuelve la posición del color
	 * 
	 * @param _numero representa el número entero
	 * @return
	 */
	public tColores intTocolor(int _numero) {
		tColores posicion = null;
		switch (_numero) {
		case 0:
			posicion = tColores.ROJO;
			break;
		case 1:
			posicion = tColores.VERDE;
			break;
		case 2:
			posicion = tColores.AZUL;
			break;
		case 3:
			posicion = tColores.DORADO;
			break;
		}
		return posicion;
	}

	/**
	 * Método generarSecuencia, Este metodo genera una secuencia de colores de forma
	 * aleatoria , la que se almacenará en el array
	 * 
	 * @param _numColores representa el número de colores que tiene el tipo enum
	 *                    tColores
	 */
	public void generarSecuencia(int _numColores) {
		Random rand = new Random();
		for (int i = 0; i < this.secuenciaColores.length; i++) {
			int numAleatorio = rand.nextInt(0, 4);
			this.secuenciaColores[i] = intTocolor(numAleatorio);
		}
	}

	/**
	 * Metodo comprobarFallo, este metodo comprueba si el color introducido por el
	 * usuario es correcto o no.
	 * 
	 * @param _index
	 * @param _color
	 * @return
	 */
	public boolean comprobarFallo(int _index, tColores _color) {
		boolean fallo = true;
		if (_color != this.secuenciaColores[_index]) {
			fallo = false;
		}
		return fallo;
	}

	/**
	 * Este metodo muestra la secuencia actual por pantalla para que el usuario la
	 * pueda memorizar
	 * 
	 * @param _numero representa la secuencia actual
	 */
	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(this.secuenciaColores[i] + " ");

		}
	}

	/**
	 * Este metodo muestra el menu para que el jugador elija que hacer, si jugar o
	 * salir
	 */
	public void menu() {
		System.out.println("¿Qué deseas hacer? \n 0 salir \n 1 jugar ");
	}

	public String mostrarColor(tColores _color) {
		String color = null;
		switch (_color) {
		case ROJO:
			color = "Rojo";
			break;
		case VERDE:
			color = "Verde";
			break;
		case AZUL:
			color = "Azul";
			break;
		case DORADO:
			color = "Dorado";
			break;
		}
		return color;
	}

	/**
	 * Este metodo lleva el control del juego
	 */
	public void start() {
		System.out.println("Bienvenido a Simon Dice!!! ");
		System.out.println(" ");
		System.out.println("¿Cual es tu nombre? ");

		this.nombre = entrada.nextLine();
		Jugador jugador = new Jugador(nombre);
		

		System.out.println("Hola " + jugador.getNombre() + " pulsa ENTER para empezar ");
		entrada.nextLine();
		menu();

		int opcion = entrada.nextInt();
		do {
			switch (opcion) {
			case 0:
				System.out.println("Abandonas el juego");
				break;
			case 1:
				play();
				break;
			}
		} while (opcion != 0);

	}

	/**
	 * Metodo que lleva el control del juego, sera el encargado de controlar la
	 * secuencia en la que se encuentre el juego
	 * 
	 */
	public void play() {
		generarSecuencia(max_colores_seq);
		int secuencia = 3;
		int puntuacion;
		boolean fallo = true;
		int numSecuencia = 1;

		do {

			while (secuencia <= max_colores_seq && fallo) {

				System.out.println("memorize la secuencia  de colores cuando este listo pulse enter ");
				System.out.println("secuencia nº: " + numSecuencia);

				mostrarSecuencia(secuencia);
				entrada.nextLine();
				entrada1.nextLine();

				for (int j = 0; j < 50; j++) {
					System.out.println();
				}

				int i = 0;
				while (i < secuencia && fallo) {
					char miChar = entrada1.next().charAt(0);

					if (comprobarFallo(i, charToColor(miChar))) {
						System.out.println("correcto ");
						i++;

					} else {
						fallo = false;
						System.out.println("no es correcto");
					}

				}
				numSecuencia++;

				if (fallo && secuencia < max_colores_seq) {
					
					secuencia++;

				} else if (fallo && secuencia == max_colores_seq) {
					System.out.println("Enhorabuena has ganado!!!!!!");
					entrada.nextLine();
					start();

				}
			}
		} while (fallo = false );
		
		System.out.println("Lo siento has perdido, vuelve a intentarlo ");
		System.out.println(" ");
		start();

				
			
		
		
		    
		
		
		
		

		

	

	}

}
