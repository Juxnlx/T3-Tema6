package boletin1.ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {

	// Creamos la constante FICHERO como final para almacenar la ruta del fichero
	// "Temperaturas.txt".
	public static final String FICHERO = "src\\boletin1\\ejercicio8\\Temperaturas.txt";

	// Creamos el Scanner para leer la información que se le solicite al usuario.
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Creamos la variable opc como int para almacenar la opción seleccionada por el
		// usuario.
		int opc;

		do {
			// Llamamos a la función menu para mostrar el menú.
			menu();
			// Le pedimos al usuario que introduzca la opción y la leemos
			opc = sc.nextInt();
			// Limpiamos el buffer.
			sc.nextLine();

			switch (opc) {
			case 1 -> {
				// Comprobamos si la función registrarTemperatura ha realizado el registro, si
				// es así...
				if (registrarTemperatura()) {
					// Mostramos un mensaje de que la nueva temperatura ha sido registrada.
					System.out.println("La nueva temperatura ha sido registrada.");

					// Si no...
				} else {
					// Mostramos un mensaje de que la nueva temperatura no ha sido registrada.
					System.out.println("No se ha registrado la nueva temperatura.");
				}
			}
			case 2 -> {
				//Llamamos a la función mostrarHistorial.
				mostrarHistorial();
				
			}
			case 3 -> {
				// Mostramos un mensaje de salida.
				System.out.println("Saliendo...");
			}
			default -> {
				// Mostramos un mensaje indicando que la opción introducida es incorrecta.
				System.out.println("La opción introducida es incorrecta.");
			}
			}

			// Comprobamos si la opc es distinta de 3 porque en ese caso volvemos a ejecutar
			// el bucle.
		} while (opc != 3);

		// Cerramos el Scanner
		sc.close();
	}

	/**
	 * Esta función se encarga de mostrar todas las opciones disponibles del menú.
	 */
	public static void menu() {
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");
		System.out.println("Introduce una opción --> ");
	}

	/**
	 * Esta función se encarga de solicitar al usuario la fecha y la temperatura
	 * máxima y mínima, y añadirlas al fichero.
	 * 
	 * @return true si se ha añadido, false en caso contrario.
	 */
	public static boolean registrarTemperatura() {
		// Creamos la variable registrar como boolean para indicar si se ha hecho el
		// registro o no.
		boolean registrar = false;

		// Creamos la variable fecha como String para almacenar la fecha introducida por
		// el usuario.
		String fecha;

		// Creamos la variable tempMax como int para almacenar la temperatura maxima
		// introducida por el usuario.
		int tempMax;

		// Creamos la variable tempMin como int para almacenar la temperatura minima
		// introducida por el usuario.
		int tempMin;

		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el BufferedWriter para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {

			// Le pedimos al usuario que introduzca una fecha y la leemos.
			System.out.println("introduce una nueva fecha (YYYY-MM-DD): ");
			fecha = sc.nextLine();

			// Le pedimos al usuario que introduzca la temperatura maxima y la leemos.
			System.out.println("Introduce la nueva temperatura máxima: ");
			tempMax = sc.nextInt();
			// Limpiamos el buffer.
			sc.nextLine();

			// Le pedimos al usuario que introduzca la temperatura minima y la leemos.
			System.out.println("Introduce la nueva temperatura mínima: ");
			tempMin = sc.nextInt();
			// Limpiamos el buffer.
			sc.nextLine();

			// Añadimos la fecha y las temperaturas al fichero.
			bw.write(fecha + ", " + tempMax + ", " + tempMin);

			// Llamamos al metodo del BufferedWriter para añadir un salto de linea.
			bw.newLine();

			// Hacemos un flush para vaciar el buffer y escribir los datos pendientes.
			bw.flush();

			// Ponemos la variable registrar a true, ya que se ha podido realizar el
			// registro.
			registrar = true;

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Ha habido algún problema al abrir el fichero");
		}

		// Devolvemos la variable registra, indica si se ha registrado la nueva
		// temperatura.
		return registrar;
	}

	/**
	 * Esta función se encarga de leer el fichero con todas las temperaturas
	 * registradas e imprimirlas y mostrar cual temperatura maxima es mas alta y
	 * cual minima es mas baja de todas las que hay.
	 */
	public static void mostrarHistorial() {
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {

			// Creamos la variable linea como String para almacenar la linea del fichero que
			// estamos leyendo.
			String linea = br.readLine();

			// Creamos un array para almacenar en posiciones la distinta información con la
			// que cuenta la linea, en este caso la fecha y la temperatura max y min.
			String[] datos;

			// Creamos la variable maxTemperaturaMaxima como int para almacenar el mayor
			// valor maximo de las temperaturas maximas registradas.
			int maxTemperaturaMaxima = Integer.MIN_VALUE;

			// Creamos la variable minTemperaturaMinima como int para almacenar el menor
			// valor minimo de las temperaturas minimas registradas.
			int minTemperaturaMinima = Integer.MAX_VALUE;

			// Creamos la variable tempMax como int para almacenar la temperatura maxima de
			// la linea que estamos leyendo en este momento.
			int tempMax;

			// Creamos la variable tempMin como int para almacenar la temperatura minima de
			// la linea que estamos leyendo en este momento.
			int tempMin;

			// Titulo
			System.out.println("\n---- HISTORIAL DE REGISTROS ----");

			// Comprobamos si la linea que acabamos de leer no esta a null, si es así...
			while (linea != null) {

				// Almacenamos en cada posición las distintas informaciones de una linea.
				datos = linea.split(", ");

				tempMax = Integer.parseInt(datos[1]);
				tempMin = Integer.parseInt(datos[2]);

				// Imprimimos todas las temperaturas registradas.
				System.out.println(linea + "\n");

				// Volvemos a almacenar la siguiente linea en caso de haberla.
				linea = br.readLine();

				// Comprobamos si la temperatura maxima que estamos leyendo es mayor que la
				// temperatura max si es así, a temperatura max le asignamos la temperatura que
				// estamos leyendo.
				if (tempMax > maxTemperaturaMaxima) {
					maxTemperaturaMaxima = tempMax;
				}

				// Comprobamos si la temperatura minima que estamos leyendo es menor que la
				// temperatura min si es así, a temperatura min le asignamos la temperatura que
				// estamos leyendo.
				if (tempMin < minTemperaturaMinima) {
					minTemperaturaMinima = tempMin;
				}
			}

			// Mostramos la temperatura mas alta y menos alta de las registradas.
			System.out.println("\nTemperatura máxima registrada más alta: " + maxTemperaturaMaxima + "°");
			System.out.println("Temperatura mínima registrada más baja: " + minTemperaturaMinima + "°\n");

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
