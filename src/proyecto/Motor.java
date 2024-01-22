package proyecto;
import java.util.Scanner;
import java.util.Random ;

/**
 * Clase Motor
 * @author Mayra
 */

public class Motor {
	
	public enum tColores{ROJO,VERDE,AZUL,DORADO;}
    private Scanner entrada=new Scanner(System.in);
    private  int max_colores_seq=12;
    private tColores [] secuenciaColores = new tColores[max_colores_seq];
    private String nombre;
    
   
  /**
   * constructor  
   */
    
    public Motor(){
    	
    	this.nombre = entrada.nextLine();
    //Colores [] secuenciaColores = new tColores[max_colores_seq];
        
    	
    	
    	
    	
    }
    /**
     * metodo charToColor, este método recibe un char y devuelve un color del tipo enum tColeres
     * @param _color representa el caracter del color introducido por el usuario
     * @return 
     */
  public tColores charToColor (char _color) {
	  
	  char _color1 = Character.toLowerCase(_color);
	  tColores charColor=null ;
	  
	  switch (_color1) {
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
      default :
    	  System.out.println("No es correcto");
	  	  
	  }
		return charColor;
		
		/**
		 *Método intColor, este método recibe un int y devuelve la posición del color 
		 *  @param _numero representa el número entero
		 *  @return
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
    	 *Método generarSecuencia, Este método genera una secuencia de colores de forma aleatoria , la que se almacenará en el array
    	 * @param _numColores representa el número de colores que tiene el tipo enum tColores
    	 */
    }
    public void generarSecuencia (int _numColores) {
    	Random rand = new Random();
    	for (int i= 0; i< this.secuenciaColores.length ; i++) {
    		
    		int numAleatorio = rand.nextInt(0,4);
    		this.secuenciaColores[i] = intTocolor(numAleatorio);
    
  
    	}
    	
    	/**
    	 *Método comprobarFallo, este método comprueba si el color introducido por el usuario es correcto o no.  
    	 *@param _index, _tColores
    	 */
    }
    	
    	public boolean comprobarFallo(int _index, tColores _color) {
    	
    		boolean comprobar = true;
    		if ( _color != this.secuenciaColores[_index]) {
    			comprobar= false;
    		}
    		return comprobar;
    	
    
    }
    	/**
    	 * Este metodo muestra la secuencia actual por pantalla para que el usuario la pueda memorizar
    	 * 
    	 * @param _numero representa la secuencia actual
    	 */
    	
    	public void mostrarSecuencia(int _numero) {
    		
    		for (int i= 0; i< _numero ; i++) {
    			
    			System.out.print(this.secuenciaColores[i]+ " ");
    			
    			
    	
    		}
    		
    	
    	
    	}
    	
    	/**
    	 * 
    	 */
    	
    	
    	
      public void menu() {
	   
    	  System.out.println("¿Qué deseas hacer? \n 1 Jugar \n 2 Salir ");
	  
   }
     
      public void play() {
    	  menu();
    	  
    	  int opcion= entrada.nextInt();
    	  this.nombre=entrada.nextLine();
    	 if ( opcion == 1) {
    		 
    		 System.out.println("Bienvenido a Simon Dice ");
    		 System.out.println("Cual es tu nombre ");
    		 this.nombre=entrada.nextLine();
    		 System.out.println("Hola "+ this.nombre + " pulsa ENTER para empezar a jugar");
    		 
    		 generarSecuencia(12);
    		 
    		 
    	 }
    	 
    	 for (int i =0; i<max_colores_seq - 2;i++ ) {
    		 System.out.println("ENTER para continuar");
    		 
    		 for (int j=0; j<50; j++) {
    			 System.out.println();
    		 }
    		 
    		 mostrarSecuencia(3 + i);
        	 System.out.println();
        	 
        	 System.out.println("memorize la secuencia");
        
        	 System.out.println("ESCRIBA en el orden correcto la primera letra de los colores MEMORIZADOS ");
        	 
        	 
        		  
        		
        		  
        	  
        	  
        	  
        	  
        	  
    	 
    	
    	 
    	 }
    	 
    	 
    	 }
	   
   
    
  
	
	
			
			
		
		
		
		
			
		
	
	

}
