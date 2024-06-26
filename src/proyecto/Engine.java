package proyecto;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase Motor
 * 
 * @author Mayra
 */
public class Engine {

	public enum tColores {ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA}
	public enum tModo{ FACIL, DIFICIL}

	private Scanner entrada = new Scanner(System.in);
	private Scanner entrada1 = new Scanner(System.in);
	private final int MAX_COLORES_SEQ = 15;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	private String nombre;
	private int ayuda;

	/**
	 * constructor
	 */
	public Engine() {
		this.ayuda=3;
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
		case 'B':
			return tColores.BLANCO;
		case 'M':
			return tColores.MARRON;
		case 'N':
			return tColores.NARANJA;
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
		case 4:
			posicion=tColores.BLANCO;
			break;
		case 5:
			posicion = tColores.MARRON;
			break;
		case 6:
			posicion = tColores.NARANJA;
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
			int numAleatorio = rand.nextInt(0, _numColores);
			this.secuenciaColores[i] = intTocolor(numAleatorio);
		}
	}
	
	/**
	 * Metodo comprobarFallo, este metodo comprueba si el color introducido por el
	 * usuario es correcto o no.
	 * 
	 * @param _index indice del color que se va a comprobar 
	 * @param _color
	 * @return fallo  true si no hay fallo , fallo false si hay fallo
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
	 *  Este metodo muestra el menu para que el jugador elija que hacer, si jugar o
	 * salir
	 */
	public void menu() {
		System.out.println("¿Qué deseas hacer? \n 0 salir \n 1 jugar modo fácil \n 2 jugar modo dificil  ");
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
	 * Metodo que permite utiliza las ayudas disponibles. si no quedan, deberá mostrar un mensaje informando sobre ello.
	 * @param _idex indice del color i-esimo que desea comprobar.
	 * @return true si quedan ayudas, false si no quedan ayudas.
	 */
	public boolean usarAyuda(int _index) {
		if(this.ayuda>0) {
			System.out.println("tienes "+ this.ayuda + " ayudas ,  siguiente color es: "+ this.secuenciaColores[_index]+ ", introducelo ");			
			this.ayuda--;
			return true;
		}else {
			System.out.println("no te quedan ayudas");
			return false;
		}
		}
			
	/**
	 * Este metodo lleva el control del juego con un menu para que el jugador elija que desea hacer 
	 */
	public void start() {
		System.out.println("Bienvenido a Simon Dice!!! ");
		System.out.println(" ");
		System.out.println("¿Cual es tu nombre? ");

		String nombre = entrada.nextLine();
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
				int resultado = play(tModo.FACIL);
				jugador.setPuntuacion(resultado);
				
				break;
			case 2:
				int resultado1 = play(tModo.DIFICIL);
				jugador.setPuntuacion(resultado1);
				break;
			}
		} while (opcion != 0);
	}
	/**
	 * Metodo que llevara el control del juego. Sera el encargado de controlar la secuencia en la que se encuentra el juego
	 * 
	 * @param tModo  modo facil o dificil segun el modo de juego que elija el jugador
	 * @return puntuacion
	 */
	public int play(tModo modo) {
		int puntuacion=0;
		if(modo == tModo.FACIL) {
			generarSecuencia(4);
		}else {
			generarSecuencia(7);
		}
		
		Jugador jugador = new Jugador(nombre);
		int secuencia = 3;
		boolean fallo = true;
		int numSecuencia = 1;

		do {
			
			
			while (secuencia <=this.MAX_COLORES_SEQ && fallo) {
				System.out.println("secuencia nº: "+ numSecuencia);
				System.out.println("memorize la secuencia  de colores cuando este listo pulse enter ");

				mostrarSecuencia(secuencia);
				entrada.nextLine();
				entrada1.nextLine();

				for (int j=0; j<50; j++) {
					System.out.println();
				}
				
				System.out.println("introduzca la secuencia de colores (x para ayuda)");

				int indice = 0;
				
				while (indice < secuencia && fallo) {
					char miChar = entrada1.next().charAt(0);
						
					if(miChar =='x') {
						usarAyuda(indice);
						miChar =entrada1.next().charAt(0);
					}
					
				 if (comprobarFallo(indice, charToColor(miChar))) {
						System.out.println("correcto ya tienes : "+jugador.getPuntuacion() +" puntos" );
						indice++;
						System.out.println();
												
					} else {
						
						System.out.println("Lo siento has perdido, vuelve a intentarlo");
						entrada.nextLine();						
					}
				}
				numSecuencia++;

				if (fallo && secuencia < this.MAX_COLORES_SEQ) {
					
					secuencia++;
					
				} else if (fallo && secuencia ==this.MAX_COLORES_SEQ) {
					System.out.println("Enhorabuena has ganado!!!!!! y sumado 40 puntos  "+" tu puntuacion final es "+ (jugador.getPuntuacion()+40)+" puntos");
					entrada.nextLine();	
				
				}
			}
					
		}	 while (fallo==false && secuencia ==this.MAX_COLORES_SEQ);	
	
	return puntuacion;

	}
}
