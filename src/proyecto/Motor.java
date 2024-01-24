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
      default :
    	  System.out.println(" no es correcto");
	  	  
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
    	
    		boolean comprobar = false;
    		if ( _color != this.secuenciaColores[_index]) {
    			comprobar= true;
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
    	 * Este metodo muestra el menu para que el jugador elija que hacer, si jugar o salir
    	 */
    	
    	
      public void menu() {
	   
    	  System.out.println("¿Qué deseas hacer? \n 0 salir \n 1 jugar ");
	  
   }
      
      public String mostrarColor(tColores _color) {
    	  String color = null;
    	  switch (_color) {
    	  case ROJO:
    		  color="Rojo";
    		  break;
    	  case VERDE:
    		  color ="Verde";
    		  break;
    	  case AZUL:
    		  color = "Azul";
    		  break;
    	  case DORADO:
    		  color = "Dorado";
    		  break;
    		  
    		  
    	  }
    	  return  color;
      }
      /**
       * Este metodo que lleva el control del juego 
       */
      
      public void start () {
    	 
    	  
    	 System.out.println("Bienvenido a Simon Dice ");
 		 System.out.println("Cual es tu nombre ");
 		 
 		 
 		 this.nombre=entrada.nextLine();
 		  Jugador jugador = new Jugador(" ");
 		  jugador.setNombre(nombre);
 		 
 		 System.out.println("Hola "+  jugador.getNombre() + " pulsa ENTER para empezar ");
 		 entrada.nextLine();
 		 menu();
 		 int opcion= entrada.nextInt();
 		 do {
 			 switch(opcion){
 			 
 			 case 0:
 				 System.out.println("Abandonas el juego");
 				 break;
 				 
 			 case 1:
 				 play();
 				 break;
 			  
 			 }
 		 }while (opcion !=0);
 				  
      }
     
      public void play() {
    	  generarSecuencia(12);
    	  
    	     int secuencia=3;
    	     int puntuacion;
    	     boolean fallo = false;
    	     
    	 
    		 
    		 	 
    	      for (int i =0; i<max_colores_seq - 2;i++ ) {
    		 
    		 entrada.nextLine();
    	do {
    		
    		System.out.println("memorize la secuencia cuando este listo pulse enter ");
    		 
    		 mostrarSecuencia(secuencia ++);
        	 System.out.println();
        	 
        	 entrada.nextLine();
        	 
        	  for (int j=0; j<50; j++) {
			 System.out.println();
		 	}
    		
        	 System.out.println("ESCRIBA en el orden correcto la primera letra de los colores MEMORIZADOS ");
         	 
         	    System.out.println();
         	 
         	    
         	 
         	    char miChar =entrada.next().charAt(0);
         	    fallo=false;
         	   
         	 
         	  if(comprobarFallo(0, charToColor(miChar)) == fallo){
         		  
         		 
         		
         	  }else {
  				 fallo =true;
  				 System.out.println("fallaste");
  				entrada.nextLine();
  			 }
         	
         	
         	
    		
    	}while (fallo=true); 
    		
    	System.exit(0);
    	
    	
    	
    		    	 
    	 
    	 }
    	 
    	 
    	 }
	   
   
    
  
	
	
			
			
		
		
		
		
			
		
	
	

}
