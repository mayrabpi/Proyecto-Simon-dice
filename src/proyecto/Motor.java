package proyecto;
import java.util.Scanner;
/**
 * Clase Motor
 * @author Mayra
 */

public class Motor {
	public enum tColores{Rojo,Verde,Azul,Dorado};
	private Scanner entrada=new Scanner(System.in);
    private  int max_colores_seq;
    private tColores [] secuenciaColores = new tColores[max_colores_seq];
    private String nombre;
    
    
    public Motor(){
    	this.max_colores_seq = 12;
    	this.nombre = entrada.nextLine();
    	enum tColores{Rojo,Verde,Azul,Dorado};
    	tColores [] secuenciaColores = new tColores[max_colores_seq];
    	char _color=  entrada.next().charAt(' ');
    	
    	
    	
    }

	
	
			
			
		
		
		
		
			
		
	
	

}
