package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Creamos el Scanner para leer el fichero "NumerosReales" con algunos números
		// reales.
		Scanner sc;

		// Creamos la variable numero como int para almacenar el número que se encuentre
		// en el fichero.
		int numero;

		// Creamos la variable suma como int para almacenar la suma de todos los números
		// que se encuentren en el fichero.
		int suma = 0;

		// Creamos la variable media como int para almacenar la media de los números
		// almacenados en el fichero.
		double media;

		// Creamos la variable cont como int para contabilizar los números del fichero.
		int cont = 0;

		// Capturamos el codigo susceptible a lanzar alguna excepción.
		try {
			// Declaramos el Scanner con el FileReader, indicando la ruta donde se encuentra
			// el fichero a leer.
			sc = new Scanner(new FileReader("src\\ejercicio2\\Enteros.txt"));

			// Comprobamos si el siguiente caracter a leer es un entero si es así...
			while (sc.hasNextInt()) {
				// Leemos el número y lo almacenamos en la variable numero.
				numero = sc.nextInt();
				// Almacenamos en la variable suma la suma de los números que vamos leyendo.
				suma += numero;
				// Incrementamos el contador en +1 cada vez aparece un número.
				cont++;
			}

			// Calculamos la media aritmética, la suma entre los números que hay.
			media = (double) suma / cont;

			// Mostramos la suma y la media de los números leidos del fichero.
			System.out.println("Suma: " + suma);
			System.out.println("Media aritmética: " + media);

			// Cierre de Scanner
			sc.close();

			// Capturamos la función en caso de que la ruta del fichero sea erronea.
		} catch (FileNotFoundException e) {
			// Mostramos un mensaje indicando que el fichero no se encuentra.
			System.out.println("Error al leer el fichero.");

		}

	}

}
