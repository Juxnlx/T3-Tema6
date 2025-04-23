package boletin1.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio7 {

	// Creamos una agenda como mapa para almacenar el nombre con su respectivo
	// número de contacto.
	static TreeMap<String, Integer> agenda = new TreeMap<String, Integer>();

	// Almacenamos la ruta del fichero en forma de constante y de forma estatica ya
	// que no cambia, lo hacemos para no poner la ruta tan larga allá donde la
	// necesitemos.
	public static final String FICHERO = "src\\boletin1\\ejercicio7\\Agenda.txt";

	public static void main(String[] args) {

		// Creamos la variable opc como int para almacenar la opción del menú
		// seleccionada por el usuario.
		int opc;

		// Creamos la variable nombre como String para almacenar el nombre de una
		// persona.
		String nombre;

		// Creamos la variable telefono como int para almacenar el telefono de una
		// persona.
		int telefono;

		// Creamos el Scanner para leer la información introducida por el usuario.
		Scanner sc = new Scanner(System.in);

		do {
			// Añadimos al mapa los contactos que existan en el fichero, en el caso de no
			// existir el fichero se creara.
			leerFichero();

			// Llamamos a la función menu para mostrar el menú y leemos la opción
			// introducida por el usuario.
			menu();
			opc = sc.nextInt();
			// Limpiamos el buffer
			sc.nextLine();

			// Comprobamos que opción a seleccionado el usuario.
			switch (opc) {
			case 1 -> {
				// Le pedimos al usuario que introduzca un nombre y lo leemos.
				System.out.println("Introduce el nombre del nuevo contacto --> ");
				nombre = sc.nextLine();

				// Le pedimos al usuario que introduzca un telefono y lo leemos.
				System.out.println("Introduce el teléfono del nuevo contacto --> ");
				telefono = sc.nextInt();
				// Limpiamos buffer
				sc.nextLine();

				// Comprobamos si la función añadirContacto nos devuelve true, en ese caso
				// indicamos que el nuevo contacto se ha añadido.
				if (añadirContacto(nombre, telefono)) {
					System.out.println("Nuevo contacto añadido.");
					// Si no, imprimimos que el contacto no se ha añadido a la agenda.
				} else {
					System.out.println("El contacto no se ha podido añadir a la agenda.");
				}

			}
			case 2 -> {
				// Le pedimos al usuario que introduzca un nombre y lo leemos.
				System.out.println("Introduce el nombre del contacto --> ");
				nombre = sc.nextLine();

				// Comprobamos si el nombre introducido por el usuario no es distinto de null,
				// en ese caso imprimimos el número de teléfono y el nombre de esa persona.
				if (agenda.get(nombre) != null) {
					System.out.println("Nombre: " + nombre + ". Teléfono: " + agenda.get(nombre));
					// Si no, imprimimos que el número no existe.
				} else {
					System.out.println("El número introducido no existe.");
				}

			}
			case 3 -> {
				// Hacemos uso del método keySet para recorrer las claves y luego con la clave
				// usamos el metodo get para coger el valor de ese nombre.
				for (String contacto : agenda.keySet()) {
					System.out.println(contacto + ": " + agenda.get(contacto));
				}
			}
			case 4 -> {
				// Llamamos a la función escribirFichero para añadir todos los contactos del
				// mapa al fichero "Agenda.txt".
				escribirFichero();

				// Imprimimos un mensaje de salida.
				System.out.println("Saliendo...");
			}
			default -> {
				// Imprimimos un mensaje de que la opción introducida es incorrecta.
				System.out.println("La opción introducida es erronea.");
			}
			}

			// Comprobamos que la opción sea distinta de 4, ya que la opción 4 nos sale del
			// programa.
		} while (opc != 4);

		// Cierre de Scanner
		sc.close();
	}

	/**
	 * Esta función se encarga de leer el fichero y añadir a la agenda los contactos
	 * que se encuentran en el fichero. En el caso de no haber un fichero se crearia
	 * uno vacio.
	 */
	public static void leerFichero() {
		// Creamos el BufferedReader para leer el fichero, lo hacemos donde el try ya
		// que puede lanzar una excepción.
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			// Creamos la variable linea como String para almacenar la primera linea del
			// fichero.
			String linea = br.readLine();
			// Creamos un array para almacenar en posiciones la distinta información con la
			// que cuenta la linea, en este caso el nombre y el teléfono.
			String[] datos;

			// Comprobamos si la linea es distinta de null, si es así...
			while (linea != null) {
				// Almacenamos en cada posición las distintas informaciones de una linea.
				datos = linea.split(" ");

				// Añadimos al mapa la información almacenada en el array cada información en su
				// lugar correspondiente.
				agenda.put(datos[0], Integer.parseInt(datos[1]));

				// Añadimos un saldo de linea al fichero.
				linea = br.readLine();
			}

			// En caso de que el fichero agenda no este creado lo crearemos.
		} catch (FileNotFoundException e) {
			try {
				// Creamos el fichero "Agenda.txt" vacio.
				FileWriter f = new FileWriter(FICHERO);
				f.close();

				// En caso de que salte la excepción imprimimos un mensaje de error indicando
				// que el fichero no se ha podido eliminar.
			} catch (IOException e1) {
				System.out.println("Error al crear el fichero: " + e.getMessage());
			}
			// En caso de que salte la excepción imprimimos un mensaje de error indicando
			// que el fichero no se ha podido leer.
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
		}
	}

	/**
	 * Esta función se encarga de recorrer la agenda e ir escribiendo cada contacto
	 * en el fichero con su respectivo número de teléfono.
	 */
	public static void escribirFichero() {
		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el BufferedWriter para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, false))) {

			// Hacemos uso del método keySet para recorrer las claves y luego con la clave
			// usamos el metodo get para coger el valor de ese nombre.
			for (String nombre : agenda.keySet()) {
				// Añadimos cada nombre al fichero.
				bw.write(nombre + " ");
				// Añadimos el número de teléfono al fichero.
				bw.write(String.valueOf(String.valueOf(agenda.get(nombre))));
				// Llamamos al metodo del BufferedWriter para añadir un salto de linea.
				bw.newLine();
				System.out.println();
			}
			// Hacemos un flush para vaciar el buffer y escribir los datos pendientes.
			bw.flush();

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Ha habido algún problema al abrir el fichero");
		}
	}

	/**
	 * Esta función se encarga de imprimir el menú con las distinas opcines y nos
	 * pregunta cual es la opción seleccionada.
	 */
	public static void menu() {
		System.out.println("----------MENÚ----------");
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir.");
		System.out.println("Introduce una opción --> ");
	}

	/**
	 * Esta función se encarga de comprobar que la agenda tenga una longitud menor
	 * de 20 y que el nombre del contacto a añadir no exista. En ese caso añadimos
	 * el contacto y devolvemos true.
	 * 
	 * @param nombre   El nombre del nuevo contacto.
	 * @param telefono El telefono del nuevo contacto.
	 * @return true si se ha añadido, false si no lo ha hecho.
	 */
	public static boolean añadirContacto(String nombre, int telefono) {
		// Creamos la variable añadido como boolean para indicar si se ha añadido el
		// contacto o no.
		boolean añadido = false;

		// Comprobamos que el tamaño sea menor que 20 y que el nombre no existe en la
		// agenda, en ese caso...
		if (agenda.size() < 20 && !agenda.containsKey(nombre)) {
			// Añadimos el contacto a la agenda.
			agenda.put(nombre, telefono);

			// Ponemos añadido a true.
			añadido = true;
		}

		// Devolvemos añadido.
		return añadido;
	}

}
