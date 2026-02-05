package jcolonia.daw2025.g4d;

/** Plantilla para calcular diferentes valores con los numerós */
public interface Sumable {
	
	/** plantilla para hacer sumar los valores 
	 * @return suma
	 * */
	double suma();
	
	/** plantilla para calcular la media de los numerós.
	 * @return media
	 * */
	double media();
	
	/** plantilla que devuelve el valor mas grande 
	 * @return maximo
	 **/
	double maximo();
	
	/** plantilla que devuelve el valor mas pequeño
	 * @return minimo
	 * */
	double minimo();
}
