package proyecto;
import java.util.Scanner;
/**
 * Clase Motor
 * @author Mayra
 */

public class Motor {
	public enum tColores{ROJO,VERDE,AZUL,DORADO};
	
	
    	
	private Scanner entrada=new Scanner(System.in);
    final private  int max_colores_seq=12;
    private tColores [] secuenciaColores = new tColores[max_colores_seq];
    private String nombre;
  /**
   * constructor  
   */
    
    public Motor(){
    	
    	this.nombre = entrada.nextLine();
    	tColores [] secuenciaColores = new tColores[max_colores_seq];
    	char _color = entrada.next().charAt(' ');
    	int _numero;
    	
    	
    }
    /**
     * metodo charToColor, este método recibe un char y devuelve un color del tipo enum tColeres
     * @param _color
     * @return
     */
  public tColores charToColor (char _color) {
	  tColores charColor=null ;
	  switch (_color) {
	  case 'R':
		  charColor= tColores.ROJO;
		  break;
	  case 'V':
		  charColor= tColores.VERDE;
		  break;
	  case 'A':
		  charColor= tColores.AZUL;
		  break;
	  case 'D':
		  charColor= tColores.DORADO;
		  break;
	  	  
	  }
		return charColor;
		
		/**
		 * Método intColor, este método recibe un int y devuelve la posición del color
		 */
  }
    
    public tColores intTocolor (int _numero) {
    	 tColores posicion=null;
    	switch (_numero) {
    	case 0:
    		posicion= tColores.ROJO;
    		break;
    	case 1:
    		posicion= tColores.VERDE;
    		break;
    	case 2: 
    		posicion= tColores.AZUL;
    		break;
    	case 3:
    		posicion=tColores.DORADO;
    		break;
    		
    	}
    	return posicion;
    	
    	/**
    	 * Método generarSecuencia 
    	 */
    }
    public void generarSecuencia (int _numColores) {
    	
    }
   public void menu() {
	   System.out.println("¿Que deseas hacer? \\n: 0 Salir \\n 1 Jugar ");
   }
    
    
	
	
			
			
		
		
		
		
			
		
	
	

}
