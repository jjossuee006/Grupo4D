/** 
 * UT4: Ejemplo de repaso y estuctura base pra pruebas JUnit y excepciones.
 * 
 *  @author Josué
 *  @version 1.0
 */ 
package jcolonia.daw2025.g4d;

/**
 * Conjunto de cuatro numeros con decimales.
 */
public class Grupo4D {

	/** primer numero */
	private double a;
	/** segundo numero */
	private double b;
	/** tercer numero */
	private double c;
	/** cuarto numero */
	private double d;
	
	/**
	 * Constructor vacio.
	 */
	public Grupo4D() {
	}
	
	/**
	 * Constructor que inicia los cuatro numeros de la clase.
	 * @param a valor inicial del primer numero.
	 * @param b valor inicial del segundo numero.
	 * @param c valor inicial del tercer numero.
	 * @param d valor inicial del cuarto numero.
	 */
	public Grupo4D(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	/**
	 * Devuelve el valor del primer numero .
	 * @return valor de a.
	 */
	public double getA() {
		return a;
	}
	
	/**
	 * Modifica el valor del atributo a.
	 * @param valor nuevo valor para a.
	 */
	public void setA(double valor) {
		this.a = valor;
	}
	
	/**
	 * Devuelve el valor del atributo b.
	 * @return valor de b.
	 */
	public double getB() {
		return b;
	}
	
	/**
	 * Modifica el valor del atributo b.
	 * @param valor nuevo valor para b.
	 */
	public void setB(double valor) {
		this.b = valor;
	}
	
	/**
	 * Devuelve el valor del atributo c.
	 *
	 * @return valor de c.
	 */
	public double getC() {
		return c;
	}
	
	/**
	 * Modifica el valor del atributo c.
	 * @param valor nuevo valor de c.
	 */
	public void setC(double valor) {
		this.c = valor;
	}
	
	/**
	 * Devuelve el valor del atributo d.
	 * @return valor de d.
	 */
	public double getD() {
		return d;
	}
	
	/**
	 * Modifica el valor del atributo d.
	 * @param valor nuevo valor de d.
	 */
	public void setD(double valor) {
		this.d = valor;
	}
	
	/**
     * Devuelve una representación del valor de los atributos de la clase Grupo4D.
     *<div>
     *	A: 90,67 | B: 64,58 | C: 0,81 | D: 59,67
     *</div>
     * @return cadena con los valores de a, b, c y d.
     */
	
	@Override
	public String toString() {
		String resultado;
		resultado = String.format("A: +%8.2f | B: +%8.2f | C: +%8.2f | D: +%8.2f",getA(),getB(),getC(),getD());
		return resultado;
	}
}
