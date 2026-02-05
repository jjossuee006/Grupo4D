package jcolonia.daw2025.g4d;

import java.util.Random;

/**
 * Valida el funcionamiento de la colección {@link Conjunto4D}.
 * Genera una serie de grupos con valores aleatorios, los almacena en el conjunto
 * y muestra una serie de calculos con sus valores.
 * @author Josué Mateos
 * @version 1.1 (2026)
 */
public class EnsayosConjunto4D {

	/**
     * Ejecuta la prueba de funcionamiento:
     * creación, llenado y visualización del conjunto.
     * * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
    	
    	try {
    		Random rnd = new Random();
        	Conjunto4D conjunto = new Conjunto4D(12);

        	for (int i = 0; i < 12; i++) {
            conjunto.añadirGrupo(
                rnd.nextDouble(-100, 100), 
                rnd.nextDouble(-100, 100), 
                rnd.nextDouble(-100, 100), 
                rnd.nextDouble(-100, 100)
            		);
        	}

        	System.out.printf("%-5s | %-8s | %-8s | %-8s | %-8s%n", "ID", "SUMA", "MEDIA", "MAX", "MIN");
        	System.out.println("-------------------------------------------------------");

        	for (int i = 0; i < conjunto.consultarNumeroElementos(); i++) {
            Grupo4D base = conjunto.consultarGrupo(i);
            Grupo4DMejorado m = new Grupo4DMejorado(base.getA(), base.getB(), base.getC(), base.getD());
            System.out.printf("Nº %-2d | %8.2f | %8.2f | %8.2f | %8.2f%n", 
                (i + 1), m.suma(), m.media(), m.maximo(), m.minimo());
        	}
    	} catch (IllegalArgumentException e) {
    		System.err.println("Error de validación: " + e.getMessage());
    	} catch (IndexOutOfBoundsException e) {
    		System.err.println("Error de índice: " + e.getMessage());
    	} 
    }
}
