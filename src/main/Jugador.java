package main;

/**
 * Clase Jugador
 * @author Mayra
 */

public class Jugador {
	
	private String nombre;
	private int puntuacion;
	
	/**
	 * 
	 * @param nombre
	 */
	public Jugador (String nombre ) {
		
		this.nombre=nombre;
		
		
	}
	/**
	 * metodo getter jugador
	 * @return
	 */
	public String getNombre (){
		return this.nombre;
		
	}
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * metodo getter puntuación
	 * @return
	 */	
	public int getPuntuacion() {
		
		return this.puntuacion;
		
	}
	/**
	 * 
	 * @param puntuacion
	 */
	public void setPuntuacion(int puntos) {
		this.puntuacion=puntos;
	}
	
	
}
