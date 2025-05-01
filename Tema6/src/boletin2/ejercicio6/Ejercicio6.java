package boletin2.ejercicio6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio6 {

	// Creamos la variable FICHERO como String una constate ya que sera la ruta del
	// fichero donde vamos a leer los datos del deportista y no debe de cambiar.
	static final String FICHERO = "src\\boletin2\\ejercicio6\\deportistas.txt";

	public static void main(String[] args) {

		// Creamos la variable nombreMayorEdad como String para almacenar el nombre del
		// deportista con mayor edad.
		String nombreMayorEdad = "";

		// Creamos la variable nombreMayorPeso como String para almacenar el nombre del
		// deportista con mayor peso.
		String nombreMayorPeso = "";

		// Creamos la variable nombreMayorEstatura como String para almacenar el nombre
		// del deportista con mayor estatura.
		String nombreMayorEstatura = "";

		// Creamos la variable mayorEdad como int para almacenar la edad del deportista
		// mas mayor.
		int mayorEdad = 0;

		// Creamos la variable mayorPeso como double para almacenar el peso del portista
		// con mayor peso.
		double mayorPeso = 0;

		// Creamos la variable mayorEstatura como double para almacenar la estatura del
		// deportista mas alto.
		double mayorEstatura = 0;

		// Creamos el BufferedReader para leer el fichero pasado por parametro al
		// FileReader.
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {

			// Creamos la variable linea como String para almacenar la linea del fichero que
			// estemos leyendo en este momento. Leemos una nueva para descartar el
			// encabezado.
			String linea = br.readLine();

			// Declaramos el array partes como String para almacenar en posiciones la
			// distinta información de la linea.
			String[] partes;

			// Creamos la variable nombre como String para almacenar el nombre del
			// deportista que estamos leyendo.
			String nombre;

			// Creamos la variable edad como int para almacenar la edad del deportista que
			// estamos leyendo.
			int edad;

			// Creamos la variable peso como double para almacenar el peso del deportista
			// que estamos leyendo.
			double peso;

			// Creamos la variable estatura como double para almacenar la estatura del
			// deportista que estamos leyendo.
			double estatura;

			// Leemos la siguiente linea y almacenamos la información en linea.
			linea = br.readLine();

			// Comprobamos si la linea que estamos leyendo no esta a null, si es así...
			while (linea != null) {

				// Almacenamos en el array la información de la linea haciendo un trim y un
				// split de "\\s+". Este caracter representa cualquier caracter de espacio en
				// blanco.
				partes = linea.trim().split("\\s+");

				// Almacenamos en la variable nombre el nombre y los apellidos de cada
				// deportista, hacemos un join para unir todas las palabras por un espacio.
				// copyOfRange me une todas las palabras desde la posición 0 hasta las 3 ultimas
				// posiciones, así el nombre puede ser de la longitud y tener las palabras que
				// queramos.
				nombre = String.join(" ", Arrays.copyOfRange(partes, 0, partes.length - 3));
				// En la variable edad almacenamos la edad que estamos leyendo que se encuentra
				// en la posición antepenúltima.
				edad = Integer.parseInt(partes[partes.length - 3]);
				// En la variable peso almacenamos el peso que estamos leyendo que se encuentra
				// en la posición peníltima.
				peso = Double.parseDouble(partes[partes.length - 2].replace(",", "."));
				// En la variable estatura almacenamos la estatura que estamos leyendo que se
				// encuentra en la ultima posición.
				estatura = Double.parseDouble(partes[partes.length - 1].replace(",", "."));

				// Comprobamos si la edad del deportista es mayor que mayorEdad, si es así...
				if (edad > mayorEdad) {
					// Almacenamos en mayorEdad la edad del deportista.
					mayorEdad = edad;
					// Almacenamos en nombreMayorEdad el nombre del deportista de mayor Edad.
					nombreMayorEdad = nombre;
				}

				// Comprobamos si el peso del deportista es mayor que mayorPeso, si es así...
				if (peso > mayorPeso) {
					// Almacenamos en mayorPeso el peso del deportista.
					mayorPeso = peso;
					// Almacenamos en nombreMayorPeso el peso del deportista de mayor peso.
					nombreMayorPeso = nombre;
				}

				// Comprobamos si la estatura del deportista es mayor que mayorEstatura, si es
				// así...
				if (estatura > mayorEstatura) {
					// Almacenamos en mayorEstatura la estatura del deportista.
					mayorEstatura = estatura;
					// Almacenamos en nombreMayorEstatura la estatura del deportista de mayor
					// estatura.
					nombreMayorEstatura = nombre;
				}

				// Leemos la siguiente linea.
				linea = br.readLine();
			}

			// Imprimimos el deportista con mayor edad, peso y estatura.
			System.out.println("Deportista con mayor edad: " + nombreMayorEdad + " (" + mayorEdad + " años)");
			System.out.println("Deportista con mayor peso: " + nombreMayorPeso + " (" + mayorPeso + " kg)");
			System.out.println("Deportista con mayor estatura: " + nombreMayorEstatura + " (" + mayorEstatura + " m)");

			// Controlamos la excepción en caso de que salte cualquier error a la hora de
			// leer el fichero e imprimimos un mensaje de que ha habido un error al leer el
			// fichero.
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero: " + e.getMessage());
		}
	}
}
