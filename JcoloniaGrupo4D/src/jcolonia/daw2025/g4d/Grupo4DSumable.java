package jcolonia.daw2025.g4d;
/**
 * Conjunto de cuatro números con decimales que nos permite calcular la suma total de ellos.
 * <p> Extiende de la clase {@link Grupo4D} e implementa la interfaz {@link Sumable}. </p>
 */
public class Grupo4DSumable extends Grupo4D implements Sumable{
	
	/**
	 * Inicialización de los cuatro números.
	 * @param a primer número.
	 * @param b segundo número.
	 * @param c tercer número.
	 * @param d cuarto número.
	 */
	public Grupo4DSumable(double a, double b, double c,double d) {
		super(a,b,c,d);
	}
	
	/**
	 * Calcula la suma total de los cuatro números.
	 * 
	 * @return a + b + c + d
	 */
	@Override
	public double suma() {
		return getA() + getB() + getC() + getD();
	}

	@Override
	public double media() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double maximo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double minimo() {
		// TODO Auto-generated method stub
		return 0;
	}
}
