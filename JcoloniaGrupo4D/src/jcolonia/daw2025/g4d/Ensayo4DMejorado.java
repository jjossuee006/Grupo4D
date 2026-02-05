package jcolonia.daw2025.g4d;

import java.util.Random;

/**
 * Ejemplo de prueba de resultado de {@link Grupo4DMejorado}.
 */
public class Ensayo4DMejorado {
	
	/**
	 * Genera un grupo con cuatro numerós con decimales de manera aleatoria.
	 * @param args de la linea de comandos.
	 */
	public static void main(String[] args) {

		Grupo4DMejorado grupo1;
		Random rnd;
		double r1,r2,r3,r4;
		
		grupo1 = new Grupo4DMejorado();
		rnd = new Random();
		
		r1 = rnd.nextDouble(-100,100);
    	r2 = rnd.nextDouble(-100,100);
    	r3 = rnd.nextDouble(-100,100);
    	r4 = rnd.nextDouble(-100,100);
    	
    	grupo1.setValores(new double[] { r1, r2, r3, r4 });
    	
    	System.out.println(grupo1.toString());
    	System.out.println(grupo1.suma());
    	System.out.println(grupo1.media());
    	System.out.println(grupo1.maximo());
		
		
	
	}
}
