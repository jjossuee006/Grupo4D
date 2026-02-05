package jcolonia.daw2025.g4d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprueba el funcionamiento de los diferentes funciones que presenta {@link Conjunto4D}
 * @author Josué Mateos
 * @version 1.0 (03022026)
 */
class ConjuntoTest {

	/** Crea un almacen donde se guardaran diversos grupos */
	Conjunto4D conjunto;
	/** Crea un almacen el cual no tendra huevo para almacenar nuevos grupos */
	Conjunto4D conjuntoLleno;
	
	/**
	 * Inicializa los almacenes asignandoles un tamaño
	 */
	@BeforeEach
	void setUp() {
		conjunto = new Conjunto4D(5);
		conjuntoLleno = new Conjunto4D(0);
	}

	/**
	 * Comprueba que el programa nos permite añadir y grupo al almacen.
	 * posteriormente comprobara que los valores se añadieron correctamente.
	 * @param a primer valor del grupo
	 * @param b segundo valor del grupo
	 * @param c tercer valor del grupo
	 * @param d cuarto valor del grupo
	 */
	@ParameterizedTest
	@DisplayName("Comprobar añadir grupo y verificar contenido")
	@CsvSource({"1,2,5,6", "8,0,2,8"})
	void testAñadirGrupo(double a, double b, double c, double d) {
	    conjunto.añadirGrupo(a, b, c, d);
	    
	    assertEquals(1, conjunto.consultarNumeroElementos(), "El número de elementos debe ser 1");
	    
	    Grupo4D resultado = conjunto.consultarGrupo(0);
	    assertAll("Verificar valores guardados",
	        () -> assertEquals(a, resultado.getA(),"El primer elemento debe coincidir con a"),
	        () -> assertEquals(b, resultado.getB(),"El segundo elemento debe coincidir con b"),
	        () -> assertEquals(c, resultado.getC(),"El tercer elemento debe coincidir con c"),
	        () -> assertEquals(d, resultado.getD(),"El cuarto elemento debe coincidir con d")
	    );
	}
	
	/**
	 * Comprueba que al intentar añadir un grupo a un almacen que este lleno el programa nos dira que no se puede
	 */
	@Test
	@DisplayName("Error al añadir un grupo")
	void testErrorAñadir() {
		double a,b,c,d;
		
		a = 5;
		b = 7;
		c = 1;
		d = 8;

		assertThrows(IllegalArgumentException.class,
				()-> conjuntoLleno.añadirGrupo(a, b, c, d)
		);
		assertTrue(conjuntoLleno.consultarNumeroElementos() == 0);
		
	}
	
	/**
	 * Comprueba que se elimina un grupo correctamente y que los demas grupos se mueven para no dejar posiciones libres dentro del almacen.
	 */
	@Test
	@DisplayName("Comprobar eliminar grupo")
	void testEliminarGrupo() {
		Grupo4D resultado;
		//Añade grupos
		conjunto.añadirGrupo(5,6,7,8);
		conjunto.añadirGrupo(9,6,5,4);
		//Comprueba que el conjunto contiene 2 numeros
		assertEquals(2, conjunto.consultarNumeroElementos(), "El número de elementos debe ser 1");
		//Elimina el primer grupo
		conjunto.eliminarGrupo(0);
		//Comprueba que el conjunto tiene un grupo menos
		assertEquals(1, conjunto.consultarNumeroElementos(), "El número de elementos debe ser 1");
		//Guarda los valores de grupo restante
		resultado = conjunto.consultarGrupo(0);
		//Comprueba que el grupo se a movido a la posicion libre
		assertAll("Verificar valores guardados",
			       () -> assertEquals(9, resultado.getA(),"El primer elemento debe coincidir con a"),
			       () -> assertEquals(6, resultado.getB(),"El segundo elemento debe coincidir con b"),
			       () -> assertEquals(5, resultado.getC(),"El tercer elemento debe coincidir con c"),
			       () -> assertEquals(4, resultado.getD(),"El cuarto elemento debe coincidir con d")
			    );
	}
	
	/**
	 * Comprueba que da un error al intentar eliminar que este fuera del rango del almacen.
	 */
	@Test
	@DisplayName("Error al eliminar un grupo fuera del rango")
	void testEliminarFueraRango() {
		conjunto.añadirGrupo(5,6,7,8);
		
		assertThrows(IndexOutOfBoundsException.class,
				()-> conjunto.eliminarGrupo(2)
		);
		assertTrue(conjunto.consultarNumeroElementos() == 1);
	}
	
	/**
	 * Comprueba que devuelve de forma correcta el tamaño total del conjunto.
	 */
	@Test
	@DisplayName("Comprueba el tamaño del conjunto")
	void testDevolverTamaño() {
		assertEquals(5,conjunto.consultarTamaño());
	}
	
	/**
	 * Comprueba que devuelve de forma correcta el numero de elementos que estan en el almacen.
	 */
	@Test
	@DisplayName("Comprobar numero de elementos")
	void testNumElementos() {
		conjunto.añadirGrupo(5, 4, 3, 2);
		assertEquals(1,conjunto.consultarNumeroElementos());
	}
	
	/**
	 * Compreuba que se amplica de forma correcta el tamaño del almacen.
	 * posteriormente comprueba que se pueden añadir elementos con el nuevo tamaño.
	 */
	@Test
	@DisplayName("Comprobar que el conjunto puede aumentar su capacidad")
	void testAmpliarCapacidad() {
	    for(int i = 0; i < 5; i++) {
	        conjunto.añadirGrupo(1, 1, 1, 1);
	    }
	    
	    conjunto.ampliar(10);
	    
	    assertEquals(10, conjunto.consultarTamaño(), "El tamaño total debería ser 10");
	    
	    assertEquals(5, conjunto.consultarNumeroElementos(), "Debería conservar los 5 elementos previos");
	    
	    assertDoesNotThrow(() -> conjunto.añadirGrupo(2, 2, 2, 2), 
	        "Debería permitir añadir más elementos tras ampliar");
	}
}
