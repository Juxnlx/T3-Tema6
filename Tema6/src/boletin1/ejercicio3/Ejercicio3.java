package boletin1.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) {

		// Creamos la variable linea como String para alamcenar la información de cada
		// linea en forma de cadena.
		String linea;

		// Creamos la variable nombre como String para almacenar el nombre de la linea
		// que estamos leyendo.
		String nombre;

		// Creamos la variable sumaEdades como int para almacenar la suma de todas las
		// edades de cada alumno que aparecen en el fichero.
		int sumaEdades = 0;

		// Creamos la variable sumaEstatuta como double para almacenar la suma de todas
		// las estaturas de cada alumno que se encuentra en el fichero.
		double sumaEstatura = 0;

		// Creamos la variable cont como int para almacenar cuantos alumnos hay en el
		// fichero.
		int cont = 0;

		// Capturamos el codigo susceptible a lanzar alguna excepción.
		try {

			// Creamos el BufferedReader alumnos para leer el fichero "Alumnos.txt" y poder
			// acceder a esa información.
			BufferedReader alumnos = new BufferedReader(new FileReader("src\\boletin1\\ejercicio3\\Alumnos.txt"));

			// En la variable linea almacenamos la linea entera que acabamos de leer.
			linea = alumnos.readLine();

			System.out.print("Nombres: ");

			// Comprobamos que la linea que acabamos de leer no este a null, si es así...
			while (linea != null) {

				// Almacenamos en un array unidimensional los datos que aparecen del alumno
				// separados por un espación en blanco y cada uno lo almacenamos en una posición
				// gracias al split.
				String[] datos = linea.split(" ");

				// En la variable nombre almacenamos el nombre del alumno que estamos leyendo.
				nombre = datos[0];

				// En la variable suma edades vamos sumando las edades de cada alumno conforme
				// vamos leyendo linea tras linea.
				sumaEdades += Integer.parseInt(datos[1]);

				// En la variable suma estatura vamos sumando las estaturas de cada alumno
				// conforme vamos leyendo linea tras linea.
				sumaEstatura += Double.parseDouble(datos[2]);

				// Imprimimos el nombre que estamos leyendo en este momento.
				System.out.print(nombre + ", ");

				// Incrementamos el contador en +1 en cada vuelta.
				cont++;

				// Volvemos a leer la siguiente linea para comprobar si esta a null o hay otro
				// alumno.
				linea = alumnos.readLine();
			}

			// Imprimos las medias de las edades y de las estaturas
			System.out.println("\nMedia de edades: " + (double) (sumaEdades / cont));
			System.out.println("Media de esturas: " + (sumaEstatura / cont));

			// Cerramos el BufferedReader.
			alumnos.close();

			// Capturamos la función en caso de que la ruta del fichero sea erronea.
		} catch (FileNotFoundException e) {
			// Mostramos un mensaje indicando que el fichero no se encuentra.
			System.out.println("El fichero no existe");

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.err.println("Error a la hora de leer el fichero");
		}

	}

}
