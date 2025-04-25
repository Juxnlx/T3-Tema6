package boletin2.ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio2 {

	// Creamos la constante FICHERO como final para almacenar la ruta del fichero
	// "firmas.txt".
	public static final String FICHERO = "src\\boletin2\\ejercicio2\\firmas.txt";

	public static HashSet<String> nombres = new HashSet<String>();

	public static void main(String[] args) {

		// Creamos la variable nombre como String para almacenar el nuevo nombre
		// introducido por el usuario.
		String nombre;

		// Creamos el Scanner para leer el nombre introducido por el usuario.
		Scanner sc = new Scanner(System.in);

		// Le pedimos al usuario que introduzca un nombre y lo leemos.
		System.out.println("Introduce un nuevo nombre: ");
		nombre = sc.nextLine();
		
		
		//Cierre de Scanner
		sc.close();
	}

	public static void leerFichero() {
		// Creamos el BufferedReader para leer el fichero, lo hacemos donde el try ya
		// que puede lanzar una excepción.
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			// Creamos la variable linea como String para almacenar la linea del fichero que
			// estamos leyendo.
			String linea = br.readLine();

			// Comprobamos si la linea que acabamos de leer no esta a null, si es así...
			while (linea != null) {

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

	public static void insertarNombre(String nombre) {
	}
}
