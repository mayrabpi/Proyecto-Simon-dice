package main;
/**
 * clase Record
 * 
 */
public class Record {
	private final int MAX_JUGADORES=10;
	private int contador;
	private Jugador []jugadores = new Jugador[MAX_JUGADORES];
	
	/**
	 * constructor
	 */
	public Record() {
		this.contador=0;
		
	
	}
	/**
	 * Metodo para añadir jugadores al array
	 * @param jugador de la clase Jugador
	 * complejidad O1
	 */
	public void addJugador(Jugador jugador) {
		if(contador< MAX_JUGADORES) {
			this.jugadores[contador]=jugador;
			this.contador++;
			
		}else
			System.out.println("No hay espacio disponible ");
	}
	/**
	 * Ordena el Array, usaremos un algoritmo de ordenacion el metodo de la burbuja 
	 * complejidad 0(n)
	 */
	public void ordenarRanking() {
		for(int i=0;i<this.contador;i++) {
			for(int j=0;j<this.contador - i -1;j++) {
				if (this.jugadores[j].getPuntuacion() < this.jugadores[j+1].getPuntuacion()) {
				Jugador guardar = this.jugadores[j+1];
				this.jugadores[j+1]=this.jugadores[j];
				this.jugadores[j]= guardar;
				}
			}		
		}		
	}
	/**
	 * Muestra el ranking de los n mejores jugadores
	 */
	public void showRanking() {
		ordenarRanking();
		System.out.println("Los 10 mejores jugadores son: ");
		int puesto=0;
		for( int i=0; i< this.MAX_JUGADORES;i++) {
	
			puesto++;
			System.out.println( puesto+". "+ this.jugadores[i].getNombre()+ " " + this.jugadores[i].getPuntuacion() );
		}	
	}
	/**
	 * Muestra el jugador (o jugadores) con la puntuacion mas alta 
	 */
	public void showBestPlayer() {
		ordenarRanking();
		int i=0;
		while(this.jugadores[i]== this.jugadores[0]&& i<=this.contador ) {
			i++;
			System.out.println(this.jugadores[0].getPuntuacion()+" "+ this.jugadores[i].getNombre());			
	
	}
	}

}































