package jcolonia.daw2025.g4d;

import java.util.Random;

/**
 * Clase de prueba para la clase {@link Grupo4D}.
 * tiene el metodo main desde el que se crean
 * y utilizan atributos del Grupo4D.
 */
public class Ensayo4D {

    /**
     * Método principal del programa.
     * 
     * @param argumentos de la línea de comandos
     */
    public static void main(String[] argumentos) {
    	
    	Random aleatorio = new Random();
    	
    	double a;
    	double b;
    	double c;
    	double d;
    	
    	a = aleatorio.nextDouble() * 100;
    	b = aleatorio.nextDouble() * 100;
    	c = aleatorio.nextDouble() * 100;
    	d = aleatorio.nextDouble() * 100;
     	
        // Crear un objeto Grupo4D usando el constructor
        Grupo4D grupo1 = new Grupo4D(a,b,c,d);

        // Muestra los valores iniciales
        System.out.println("Valores iniciales");
        System.out.println(grupo1);

        // Modificar algunos valores usando setters
        a =  aleatorio.nextDouble() * 100;
    	c =  aleatorio.nextDouble() * 100;
        grupo1.setA(a);
        grupo1.setC(c);

        // Muestra los nuevos valores
        System.out.println("Nuevos valores");
        System.out.println(grupo1);
        
        //Muestra la suma total
        System.out.println("Suma Total");
    }
}
