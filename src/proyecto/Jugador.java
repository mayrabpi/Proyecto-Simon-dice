package proyecto;

/**
 * Clase Jugador
 * @author Mayra
 */

public class Jugador {
	
	private String nombre;
	private int puntuacion;
	
	/**
	 * constructora
	 */
	public Jugador (String nombre) {
		
		this.nombre=" ";
		this.puntuacion=0;
		
	}
	/**
	 * metodo getter jugador
	 * @return
	 */
	public String getNombre (){
		return this.nombre;
		
	}
	/**
	 * Método setter jugador
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método getter puntuación
	 * @return
	 */
	
	public int getPuntuacion() {
		return this.puntuacion;
		
	}
	/**
	 * Método setter puntuación
	 */
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion=0;
	}
	
}
