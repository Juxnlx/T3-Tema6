package boletin1.ejercicio6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		// Creamos una lista llamada numerosEnteros donde almacenar una serie de números
		// que lee de un fichero.
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		// Almacenamos en nuestra lista la lista que nos devuelve la función Lectura.
		numeros = lectura();

		// Ordenamos la lista.
		Collections.sort(numeros);

		// Llamamos a la función escritura para que nos lea la lista pasada como
		// parametro y escriba los números en otro fichero.
		escritura(numeros);
	}

	/**
	 * Esta función se encarga de leer los números de un fichero y los añade a la
	 * lista que nos creamos, que sera la que luego devolvamos.
	 * 
	 * @return La lista que nos acabamos de crear con los números leidos del
	 *         fichero.
	 */
	public static ArrayList<Integer> lectura() {
		// Creamos una lista llamada numerosEnteros donde almacenar una serie de números
		// que lee de un fichero.
		ArrayList<Integer> numerosEnteros = new ArrayList<Integer>();

		// Creamos la variable num como int para almacenar el número que esta leyendo
		// del fichero.
		int num;

		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el Scanner para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (Scanner sc = new Scanner(new FileReader("src\\boletin1\\ejercicio6\\NumerosEntDesor.txt"))) {

			// Comprobamos si existen números enteros en el documento.
			while (sc.hasNextInt()) {
				// Leemos el número y lo almacenamos en la variable num.
				num = sc.nextInt();

				// Almacenamos en la lista el número que estamos leyendo del fichero.
				numerosEnteros.add(num);
			}
			// Capturamos la función en caso de que la ruta del fichero sea erronea.
		} catch (FileNotFoundException e) {
			// Mostramos un mensaje indicando que el fichero no se encuentra.
			System.out.println("Error al leer el fichero.");
		}

		// Devolvemos nuestra lista creada.
		return numerosEnteros;
	}

	/**
	 * Esta función se encarga de recorrer la lista pasada por parametro, ir
	 * recorriendo cada número de esa lista y los añade a otro fichero.
	 * 
	 * @param num La lista con los números a escribir.
	 */
	public static void escritura(ArrayList<Integer> num) {
		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el BufferedWriter para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\ejercicio6\\NumerosEntOrd.txt", true))) {

			// Recorremos la lista para ir añadiendo cada número a un nuevo fichero.
			for (int numeros : num) {
				// Añadimos el número que vamos leyendo.
				bw.write(String.valueOf(numeros));
				// Llamamos al metodo del BufferedWriter para añadir un salto de linea.
				bw.newLine();
			}

			// Hacemos un flush para vaciar el buffer y escribir los datos pendientes.
			bw.flush();

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Ha habido algún problema al abrir el fichero");
		}
	}
}
