package boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5 {

	public static void main(String[] args) {

		// Rutas de los archivos a comparar
		final String ARCHIVO1 = "src\\boletin2\\ejercicio5\\Texto1.txt";
		final String ARCHIVO2 = "src\\boletin2\\ejercicio5\\Texto2.txt";

		// Abrimos los dos archivos para lectura
		try (BufferedReader br1 = new BufferedReader(new FileReader(ARCHIVO1));
				BufferedReader br2 = new BufferedReader(new FileReader(ARCHIVO2))) {

			// Creamos la variable linea1 como String para almacenar la primera linea del
			// primer archivo.
			String linea1 = br1.readLine();

			// Creamos la variable linea2 como String para almacenar la segunda linea del
			// segundo archivo.
			String linea2 = br2.readLine();

			// Creamos la variable numLinea para alamcenar la linea que estamos recorriendo
			// en cada momento.
			int numLinea = 1;

			// Creamos la variable iguales como boolena para indicar si los textos son
			// iguales o no.
			boolean iguales = true;

			// Creamos la variable minLength como int para almacenar cual de las dos lineas
			// que estamos leyendo son menores.
			int minLength;

			// Creamos la variable caracterDif como boolean para indicar cuando hemos
			// encontrado alguna diferencia con los caracteres.
			boolean caracterDif = false;

			// Comprobamos si las lineas que acabamos de leer no se encuentran a null.
			while (linea1 != null && linea2 != null && iguales) {

				// Comprobamos si las linea son distintas, en ese caso.
				if (!linea1.equals(linea2)) {
					iguales = false;

					// Almacenamos cual de las dos lineas tiene menor longitud y sera esa la que
					// recorremos.
					minLength = Math.min(linea1.length(), linea2.length());

					// Recorremos la linea con menos caracteres y comprobamos caracterDif porque es
					// el caso de ser true, significa que ha encontrado un error y que debemos de
					// parar el recorrido del for..
					for (int i = 0; i < minLength && !caracterDif; i++) {

						// Comprobamos si los caracteres correspondientes de cada linea no son iguales,
						// en ese caso mostramos la linea y el caracter que ha probocado la diferencia.
						if (linea1.charAt(i) != linea2.charAt(i)) {
							System.out.println("Los archivos son distintos.");
							System.out.println("Primera diferencia en línea " + numLinea + ", carácter " + (i + 1));

							// Lo ponemos a true para indicar que hay diferencia entre caracteres.
							caracterDif = true;
						}
					}

					// Hacemos la misma comprobación pero comprobando tambien si caracterDif esta a
					// false porque si es así significa que el error viene por longitud de la linea
					// no de caracter.
					if (linea1.length() != linea2.length() && !caracterDif) {
						System.out.println("Los archivos son distintos.");
						System.out.println("Primera diferencia en línea " + numLinea + ", carácter " + (minLength + 1));
					}
				}

				// Leemos la siguiente linea de cada archivo.
				linea1 = br1.readLine();
				linea2 = br2.readLine();

				// Incrementamos el número de linea en +1.
				numLinea++;
			}

			// Si la variable iguales esta a true significa que los archivos son iguales.
			if (iguales) {
				System.out.println("Los archivos son iguales.");
			}

		} catch (IOException e) {
			// Mostramos un error si los archivos no se han podido leer.
			System.out.println("Error al leer los archivos: " + e.getMessage());
		}
	}
}
