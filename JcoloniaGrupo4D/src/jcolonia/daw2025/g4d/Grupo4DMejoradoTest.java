package jcolonia.daw2025.g4d;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Ejemplo de pruebas de funcionamiento de las diferentes piezas de {@link Grupo4DMejorado}.
 */
class Grupo4DMejoradoTest{

	/** Ejemplo de objeto vacio */
	Grupo4DMejorado grupoVacio;
	/** Ejemplo de objeto que recibira los cuatro valores */
	Grupo4DMejorado grupoLleno;
	/** Ejemplo de objeto que recibira los cuatro valores con una lista */
	Grupo4DMejorado grupoArray;
	
	/**
	 * Inicializa los grupos antes de ejecutar las pruebas.
	 */
	@BeforeEach
	void setUP(){
		grupoVacio = new Grupo4DMejorado();
		grupoLleno = new Grupo4DMejorado(1.0,5.0,6.4,7.8);
		grupoArray = new Grupo4DMejorado(new double[] {5,6,3,2});
	}
	
	
	
	/**
	 * Comprueba que al recibir los valores de un grupo con array estos siguen siendo los mismos para {@link Grupo4D} y {@link Grupo4DMejorado}.
	 */
	@ParameterizedTest
	@CsvSource({"1,2,3,4","3,4,2,4","5,7,4,2"})
	void testGetValoresArray(double a,double b, double c, double d) {
		double[] valorEsperado;
		Grupo4DMejorado grupoArrayVacio;
		valorEsperado = new double[] {a,b,c,d};

		grupoArrayVacio = new Grupo4DMejorado(valorEsperado);
		
		assertArrayEquals(valorEsperado,grupoArrayVacio.getValores(),"El conjunto de valores coincide correctamente");
	}
	
	/**
	 * Verifica que no se deje crear un grupo con una lista <em>array</em> de tamaño
	 * distinto a 4.
	 */
	@Test
	void testConstructorArrayError() {
		double[][] valores = {
				{1.0, 2.0}, 
				null
				};

		assertThrows(
			IllegalArgumentException.class,
			() -> new Grupo4DMejorado(valores[0]),
			"No se a indicado un conjunto de 4 valores con el constructor"
		);
		
		assertThrows(
			IllegalArgumentException.class,
			() -> new Grupo4DMejorado(valores[1]),
			"No se a indicado un conjunto de 4 valores con el constructor"
		);
	}
	
	/**
	 * Verifica que se puede crear un grupo vacio sin valores.
	 */
	@Test
	void testConstructorVacio() {
		assertEquals(0,grupoVacio.getA(),"Primer getter es correcto");
		assertEquals(0,grupoVacio.getB(),"Segundo getter es correcto");
		assertEquals(0,grupoVacio.getC(),"Tercer getter es correcto");
		assertEquals(0,grupoVacio.getD(),"Cuarto getter es correcto");
	}

	/**
	 * Verifica que se puede crear un grupo inidcandole los cuatro numeros.
	 */
	@Test
	void testConstructorLleno() {
		assertEquals(1.0,grupoLleno.getA(),"Primer valor del constructor es correcto");
		assertEquals(5.0,grupoLleno.getB(),"Segundo valor del constructor es correcto");
		assertEquals(6.4,grupoLleno.getC(),"Tercer valor del constructor es correcto");
		assertEquals(7.8,grupoLleno.getD(),"Cuarto valor del constructor es correcto");
	}
	
	 /**
		 * Verifica que no se deje establecer nuevos valores a un grupo si no se le indican cuatro numeros
		 * @see Grupo4DMejorado#setValores(double[])
		 */
		@Test
		void testSetIncompleto() {
			double[][] lista = {
					null,
					{1,3,4}
			};
			Grupo4DMejorado grupoIncompleto;
			
			grupoIncompleto = new Grupo4DMejorado();
			
			
			assertThrows(IllegalArgumentException.class,
						()-> grupoIncompleto.setValores(lista[0]),
						"No se han indicado cuatro valores con el setter"
			);
			assertThrows(IllegalArgumentException.class,
						()-> grupoIncompleto.setValores(lista[1]),
						"No se han indicado cuatro valores con el setter"
			);
		}
	
	/**
	 * Verifica que se deje crear un array con tamaño 4
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("ArrayTamañoCorrecto")
	void testSetYGetValores() {
		Grupo4DMejorado grupo;
		
		grupo = new Grupo4DMejorado();
		double[][] conjuntos = {
	            {5, 5, 5, 5},
	            {4, 6, 5, 5},
	            {5, 5, 5, 5}
	        };
		
		assertDoesNotThrow(
				()-> grupo.setValores(conjuntos[0]),
				"4 es un tamaño de array valido"
				);
		assertArrayEquals(conjuntos[0],grupo.getValores(),"Primer conjunto de valores es correcto");
		
		assertDoesNotThrow(
				()-> grupo.setValores(conjuntos[1]),
					"4 es un tamaño de array valido"
				);
		assertArrayEquals(conjuntos[1],grupo.getValores(),"Segundo conjunto de valores es correcto");
		
		assertDoesNotThrow(
				()-> grupo.setValores(conjuntos[2]),
						"4 es un tamaño de array valido"
				);
		assertArrayEquals(conjuntos[2],grupo.getValores(),"Tercer conjunto de valores es correcto");
	}

	/**
	 * Verifica que suma correctamente los cuatro valores y devuelve el resultado.
	 */
	@Test
	void testSuma() {
		double[][] conjuntos = {
	            {5, 5, 5, 5},
	            {4, 6, 5, 7},
	            {5, 5, 6, 5}
	        };

		double[] resultadosEsperados = {20,22,21};
		
		for(int i = 0; i < conjuntos.length;i++) {
			grupoVacio.setValores(conjuntos[i]);
			assertEquals(resultadosEsperados[i],grupoVacio.suma(),"Suma total de los valores correcta");
		} 
	}

	
	/**
	 * Verifica que calcula la media total de entre los cuatro valores y devuelve el resultado.
	 */
	@Test
	void testMedia() {
		double[][] conjuntos = {
	            {5, 5, 5, 5},
	            {4, 6, 5, 7},
	            {5, 5, 6, 5}
	        };

		double[] resultadosEsperados = {5, 5.5, 5.25};
		
		for(int i = 0; i < conjuntos.length;i++) {
			grupoVacio.setValores(conjuntos[i]);
			assertEquals(resultadosEsperados[i],grupoVacio.media(),"Media total de los valores correcta");
		} 
	}
	
	/**
	 * Verifica que identifica correctamente el valor mas grande de entre los cuatro valores.
	 */
	@Test
	void testMaximo() {
		grupoLleno.setValores(new double[] {10,0,0,0});
		assertEquals(10,grupoLleno.maximo(),"Valor a como valor mas grande");
		
		grupoLleno.setValores(new double[] {0,10,0,0});
		assertEquals(10,grupoLleno.maximo(),"Valor b como valor mas grande");
		
		grupoLleno.setValores(new double[] {0,0,10,0});
		assertEquals(10,grupoLleno.maximo(),"Valor c como valor mas grande");
		
		grupoLleno.setValores(new double[] {0,0,0,10});
		assertEquals(10,grupoLleno.maximo(),"Valor d como valor mas grande");
		
	}
	
	/**
	 * Verifica que indentifica correctamente el valor mas pequeño de entre los cuatro valores.
	 */
	@Test
	void testMinimo() {
		grupoLleno.setValores(new double[] {0,10,10,10});
		assertEquals(0,grupoLleno.minimo(),"Valor a como valor mas pequeño");
		
		grupoLleno.setValores(new double[] {10,0,10,10});
		assertEquals(0,grupoLleno.minimo(),"Valor b como valor mas pequeño");
		
		grupoLleno.setValores(new double[] {10,10,0,10});
		assertEquals(0,grupoLleno.minimo(),"Valor c como valor mas pequeño");
		
		grupoLleno.setValores(new double[] {10,10,10,0});
		assertEquals(0,grupoLleno.minimo(),"Valor d como valor mas pequeño");
	}
	
	/**
	 * Comprueba que devuelve una cadena de texto con los numeros correctos.
	 */
	@Test
	void testToString() {
		String texto;
		texto = grupoLleno.toString();
		assertNotNull(texto,"El texto no debe ser nulo");
		assertFalse(texto.isEmpty(),"El texto no debe estar vacio");
		assertTrue(texto.contains("1,0"),"El texto contiene el valor a de forma correcta");
		assertTrue(texto.contains("5,0"),"El texto contiene el valor b de forma correcta");
		assertTrue(texto.contains("6,4"),"El texto contiene el valor c de forma correcta");
		assertTrue(texto.contains("7,8"),"El texto contiene el valor d de forma correcta");
	}
	
	/**
	 * Comprueba que ocurre si al comrpobar al valor mas grande de un grupo hay dos valores maximos que valgan lo mismo.
	 */
	@Test
	void testDosMaximos() {
		Grupo4DMejorado grupoDosMax;
		grupoDosMax = new Grupo4DMejorado(1,3,4,4);
		assertEquals(4,grupoDosMax.maximo(),"No tiene ningun fallo si detecta dos valores iguales");
	}
	
	
}
