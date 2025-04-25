package boletin2.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio2 {

	// Creamos la constante FICHERO como final para almacenar la ruta del fichero
	// "firmas.txt".
	public static final String FICHERO = "src\\boletin2\\ejercicio2\\firmas.txt";

	// Creamos un conjunto para almacenar los nombres que se encuentran en el
	// fichero y no podamos añadir nombres repetidos.
	public static HashSet<String> nombres = new HashSet<String>();

	public static void main(String[] args) {

		// Creamos la variable nombre como String para almacenar el nuevo nombre
		// introducido por el usuario.
		String nombre;

		// Creamos el Scanner para leer el nombre introducido por el usuario.
		Scanner sc = new Scanner(System.in);

		// Llamamos a la función leerFichero.
		leerFichero();

		System.out.println("----------LISTA DE FIRMAS----------");
		// Imprimimos nuestro conjunto con todos los nombres del fichero.
		for (String firma : nombres) {
			System.out.println(firma);
		}

		// Le pedimos al usuario que introduzca un nombre y lo leemos.
		System.out.println("\nIntroduce un nuevo nombre: ");
		nombre = sc.nextLine();

		// Llamamos a la función insertarNombre para añadir el nuevo nombre que acabamos
		// de leer.
		insertarNombre(nombre);

		// Cierre de Scanner
		sc.close();
	}

	/**
	 * Esta función se encarga de leer el fichero y añadir todos los nombres que se
	 * encuentre en el fichero al conjunto nombres.
	 */
	public static void leerFichero() {
		// Creamos el BufferedReader para leer el fichero, lo hacemos donde el try ya
		// que puede lanzar una excepción.
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			// Creamos la variable linea como String para almacenar la linea del fichero que
			// estamos leyendo.
			String linea = br.readLine();

			// Comprobamos si la linea que acabamos de leer no esta a null, si es así...
			while (linea != null) {

				// Añadimos al conjunto el nombre del fichero que estamos leyendo.
				nombres.add(linea);

				// Añadimos un saldo de linea al fichero.
				linea = br.readLine();
			}

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

	/**
	 * Esta función se encarga de comprobar si el nombre pasado como parametro se
	 * encuentra en nuestro conjunto si es así no lo añade y en caso contrario si lo
	 * añade al fichero.
	 * 
	 * @param nombre El nombre pasado por parametro.
	 */
	public static void insertarNombre(String nombre) {

		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el BufferedWriter para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {

			// Comprobamos si el nombre no existe en el conjunto, si es así lo añadimos al
			// fichero.
			if (!nombres.contains(nombre)) {
				bw.write(nombre);
				bw.newLine();
				System.out.println("El nombre se ha añadido correctamente");
			} else {
				System.out.println("El nombre introducido ya se encuentra en el fichero.");
			}

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
		}
	}
}
