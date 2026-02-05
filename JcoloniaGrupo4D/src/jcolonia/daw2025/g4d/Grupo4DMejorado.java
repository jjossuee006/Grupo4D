package jcolonia.daw2025.g4d;

/**
 * Hija de Grupo4D que agrega nuevos constructores y realiza diferentes acciones con los numeros de {@link Grupo4D}.
 */
public class Grupo4DMejorado extends Grupo4D implements Sumable{
	
	/**
	 * constructor vacio
	 */
	public Grupo4DMejorado() {
	}
	
	/**
	 * Constructor que llama a su padre {@link Grupo4D}
	 * @param a primer numero.
	 * @param b segundo numero.
	 * @param c tercer numero.
	 * @param d cuarto numero.
	 */
	public Grupo4DMejorado(double a, double b, double c, double d) {
		super(a,b,c,d);
	}
	
	/**
	 * Constructor que añade 4 numeros a una lista.
	 * @param valores lista que contiene los cuatro numeros
	 */
	public Grupo4DMejorado(double[] valores) {
		if (valores == null || valores.length != 4) {
			throw new IllegalArgumentException("Tienes que indicar 4 valores");
		}
		setValores(valores);
	}
	
	/**
	 * Modifica los numeros guardados en {@link Grupo4D} con los cuatro numeros de Grupo4DMejorado.
	 * @param valores nuevos numeros que asigna a los valores de {@link Grupo4D}.
	 */
	public void setValores(double[] valores) {
		if(valores == null || valores.length != 4) { 
			throw new IllegalArgumentException("Valores debe contener 4 numeros");
		}
		setA(valores[0]);
		setB(valores[1]);
		setC(valores[2]);
		setD(valores[3]);
	}
	
	/**
	 * Obtiene los numeros de {@link Grupo4D}.
	 * @return valor de a,b,c,d
	 */
	public double[] getValores() {
		return new double[] {getA(),getB(),getC(),getD()};
	}
	
	/**
	 * Devuelve un texto que contiene los cuatro numeros.
	 */
	@Override 
	public String toString() {
		String valores;
		valores = super.toString();
		return valores;
	} 
	
	/**
	 * Devuelve la suma total de los cuatro numeros
	 * @return suma de los cuatro numeros.
	 */
	@Override
	public double suma() {
		return  getA() + getB() + getC() + getD();
	}
	
	/**
	 * Devuelve la media total de los cuatro numeros.
	 * @return media de los cuatro numeros.
	 */
	@Override
	public double media() {
		double media;
		media = suma() / 4;
		return media;
	}
	
	/**
	 * Devuelve el numero mas grande de entre los cuatro.
	 * @return maximo 
	 */
	@Override
	public double maximo() {
		double maximo;
		maximo = getA();
		if (getB() > maximo) maximo = getB();
		if (getC() > maximo) maximo = getC();
		if (getD() > maximo) maximo = getD();
		return maximo;
	}
	
	/**
	 * Devuelve el numero mas pequeño de entre los cuatro.
	 * @return minimo
	 */
	@Override
	public double minimo() {
		double minimo;
		minimo = getA();
		if (getB() < minimo) minimo = getB();
		if (getC() < minimo) minimo = getC();
		if (getD() < minimo) minimo = getD();
		return minimo;
	}
}
