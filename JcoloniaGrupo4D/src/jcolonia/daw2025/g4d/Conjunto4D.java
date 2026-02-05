package jcolonia.daw2025.g4d;

/**
 * Almacenara diferentes grupos de valores de{@link Grupo4D} en un mismo conjunto.
 * 
 * @author Josue Mateos,
 * @version 1.0 (29012026).
 */
public class Conjunto4D{

	/** Lugar donde se almacenaran los diferentes grupos de valores que se le indiquen */
	Grupo4D[] almacen;
	/** Numero maximo de grupos que podra almacenar en el conjunto*/
	int tamaño;
	/** Numero total de grupos que contiene el conjunto*/
	int numElementos;
	
	/**
	 * Crea un conjunto para poder alamcenar los diferentes grupo que se indiquen.
	 * @param tamaño numero maximo de grupos que podra almacenar el conjunto.
	 */
	public Conjunto4D(int tamaño) {
		this.tamaño = tamaño;
		almacen = new Grupo4D[tamaño];
		numElementos = 0;
	}
	
	/**
	 * Añadira un grupo de valores a un conjunto
	 * @param a primer valor del grupo
	 * @param b segundo valor del grupo
	 * @param c tercer valor del grupo
	 * @param d cuarto valor del grupo
	 */
	public void añadirGrupo(double a,double b, double c, double d) {
		Grupo4D grupo;
		grupo = new Grupo4D(a,b,c,d);
		if(numElementos == tamaño) {
			throw new IllegalArgumentException("EL grupo ya esta lleno");
		}
		almacen[numElementos] = grupo;
		numElementos++;
		
	}
	
	/**
	 * Consulta un grupo especifico almacenado en un conjunto
	 * @param posicion del grupo
	 * @return valores del grupo.
	 */
	public Grupo4D consultarGrupo(int posicion) {
		return almacen[posicion];
	}
	
	/**
	 * Elimina del conjunto el grupo que le indiquemos
	 * @param posicion del grupo
	 */
	public void eliminarGrupo(int posicion) {
		 	if (posicion > numElementos) {
		        throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
		    }

		    for (int i = posicion; i < numElementos - 1; i++) {
		        almacen[i] = almacen[i + 1];
		    }

		    almacen[numElementos - 1] = null;
		    numElementos--;
	}
	
	/**
	 * Devuelve el numero de grupos que puede contener el conjunto
	 * @return tamaño del del conjunto
	 */
	public int consultarTamaño() {
		return almacen.length;
	}
	
	/**
	 * Devuelve el numero de grupos qie hay almacenados en el conjunto
	 * @return grupos almacenados
	 */
	public int consultarNumeroElementos() {
		return numElementos;
	}
	
	/**
	 * Aumenta el numero de grupos que se pueden añadir a un conjunto.
	 * @param nuevoTamaño del conjunto.
	 */
	public void ampliar(int nuevoTamaño) {
		Grupo4D[] nuevo;
		nuevo = new Grupo4D[nuevoTamaño];
		for(int i = 0;i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		
		tamaño = nuevoTamaño;
		almacen = nuevo;
		
	}
	
}
