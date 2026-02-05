package jcolonia.daw2025.g4d;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas de uso de los distintos metodos de {@link Grupo4D}
 */
class Grupo4DTest {

	/** Creacion de objeto usando el constructor vacio. */
	Grupo4D grupoVacio;
	/** Creacion de objeto usando el constructor con numeros */
	Grupo4D grupoLleno;
	
	
	/**
	 * Asignacion de numeros de los diferentes objetos
	 */
	@BeforeEach
	public void setUp(){
		grupoVacio = new Grupo4D();
		grupoLleno = new Grupo4D(1.0,2.5,3.0,6.9);
	}
	
	/** 
	 * Comprueba el funcionamiento del constructor vacio.
	 */
	@Test
	void testConstructorVacio() {
		assertEquals(0.0,grupoVacio.getA());
		assertEquals(0.0,grupoVacio.getB());
		assertEquals(0.0,grupoVacio.getC());
		assertEquals(0.0,grupoVacio.getD());
	}
	
	/**
	 * Comprueba el funcionamiento del constructor con parametros.
	 */
	@Test
	void testConstructorLleno() {
		assertEquals(1.0,grupoLleno.getA());
		assertEquals(2.5,grupoLleno.getB());
		assertEquals(3.0,grupoLleno.getC());
		assertEquals(6.9,grupoLleno.getD());
	}
	
	/**
	 * Comprueba que asigna y devuelve de forma correcta el primer numero.
	 */
	@Test
	void testGetYSetA() {
		grupoVacio.setA(5.0);
		assertEquals(5.0,grupoVacio.getA());
	}
	
	/**
	 * Comprueba que asigna y devuelve de forma correcta el segundo numero.
	 */
	@Test 
	void testGetYSetB(){
		grupoVacio.setB(3.0);
		assertEquals(3.0,grupoVacio.getB());
	}
	
	/**
	 * Comprueba que asigna y devuelve de forma correcta el tercer numero.
	 */
	@Test 
	void testGetYSetC(){
		grupoVacio.setC(6.0);
		assertEquals(6.0,grupoVacio.getC());
	}
	
	/**
	 * Comprueba que asigna y devuelve de forma correcta el cuarto numero.
	 */
	@Test 
	void testGetYSetD(){
		grupoVacio.setD(9.0);
		assertEquals(9.0,grupoVacio.getD());
	}
	
	/**
	 * Comprueba que devuelve una cadena de texto con los numeros correctos
	 */
	@Test
	void testToString() {
		String texto;
		texto = grupoLleno.toString();
		assertNotNull(texto);
		assertTrue(texto.contains("1,0"));
		assertTrue(texto.contains("2,5"));
		assertTrue(texto.contains("3,0"));
		assertTrue(texto.contains("6,9"));
	}

}
