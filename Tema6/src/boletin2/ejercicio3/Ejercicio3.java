package boletin2.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		// Creamos la constante FICHERO como final para almacenar la ruta del fichero
		// "Texto.txt".
		final String FICHERO = "src\\boletin2\\ejercicio3\\Texto.txt";

		// Creamos la constante LINEAS_PAGINAS como int para almacenar el número de
		// lineas que tenemos que ir leyendo. Y en este caso ira siendo de 24 en 24.
		final int LINEAS_PAGINAS = 24;

		// Creamos el Scanner para hacer que el usuario pulse enter para ir mostrandole
		// otras 24 lineas.
		Scanner sc = new Scanner(System.in);

		// Creamos el BufferedReader para leer el fichero, lo hacemos donde el try ya
		// que puede lanzar una excepción.
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {

			// Creamos la variable linea como String para almacenar la información de la
			// linea que estamos leyendo en este momento.
			String linea = br.readLine();

			// Creamos la variable contLineas como int para almacenar la cantidad de lineas
			// que vamos leyendo.
			int contLineas = 0;

			// Comprobamos si la linea que acabamos de leer no esta a null, si es así...
			while (linea != null) {

				// Imprimimos la liena que estamos leyendo en este momento.
				System.out.println(linea);

				// Incrementamos el contador de lienas en cada vuelta a +1.
				contLineas++;

				// Comprobamos si el contador de lineas es igual a la constante
				// (LINEAS_PAGINAS), si es así...
				if (contLineas == LINEAS_PAGINAS) {
					// Le pedimos al usuario que introduzca enter para mostrar otras 24 lineas.
					System.out.println("\n-- Pulsa Enter para continuar --");
					sc.nextLine();
					// Reiniciamos el contLienas a 0.
					contLineas = 0;
				}

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

		// Cierre de Scanner
		sc.close();
	}

}
