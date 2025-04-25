package boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	// Creamos la constante FICHERO como final para almacenar la ruta del fichero
	// "Carta.txt".
	public static final String FICHERO = "src\\boletin2\\ejercicio1\\Carta.txt";

	public static void main(String[] args) {

		// Creamos la variable contCaracter como int para almacenar la cantidad de
		// caracteres del fichero.
		int contCaracter = 0;

		// Creamos la variable contPalabras como int para almacenar la cantidad de
		// palabras del fichero.
		int contPalabras = 0;

		// Creamos la variable contLineas como int para almacenar la cantidad de
		// lineas del fichero.
		int contLineas = 0;

		// Creamos el BufferedReader para leer el fichero, lo hacemos donde el try ya
		// que puede lanzar una excepción.
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			// Creamos la variable linea como String para almacenar la linea del fichero que
			// estamos leyendo.
			String linea = br.readLine();

			// Creamos un array para almacenar en posiciones la distinta información con la
			// que cuenta la linea, en este caso la fecha y la temperatura max y min.
			String[] datos;

			// Comprobamos si la linea que acabamos de leer no esta a null, si es así...
			while (linea != null) {

				// Almacenamos en cada posición las distintas informaciones de una linea.
				datos = linea.split(" ");

				// Recorremos el array datos para recorrer cada palabra.
				for (String palabra : datos) {
					// Contabilizamos los caracteres de cada palabra.
					contCaracter += palabra.length();

					// Incrementamos la palabra en 1 en cada vuelta.
					contPalabras++;
				}

				// Contamos como caracter los espacios en blanco tambien.
				contCaracter += datos.length;

				// Incrementamos en +1 las lineas.
				contLineas++;

				// Añadimos un saldo de linea al fichero.
				linea = br.readLine();
			}

			// Imprimimos la cantidad de caracteres, palabras y lineas que se encuentran en
			// el fichero.
			System.out.println("Número de caracteres: " + contCaracter + " en total");
			System.out.println("Número de palabras: " + contPalabras + " en total");
			System.out.println("Número de lineas: " + contLineas + " en total");

			// Capturamos la función en caso de que la ruta del fichero sea erronea.
		} catch (FileNotFoundException e) {
			// Mostramos un mensaje indicando que el fichero no se encuentra.
			System.out.println("El fichero no existe.");
			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
		}
	}
}
