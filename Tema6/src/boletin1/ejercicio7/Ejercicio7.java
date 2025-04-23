package boletin1.ejercicio7;

import java.io.BufferedReader;
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

	public static final String FICHERO = "src\\boletin1.ejercicio7\\agenda.txt";

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

				// Le pedimos al usuario que introduzca un telefono y lo leemos.
				System.out.println("Introduce el teléfono del contacto --> ");
				telefono = sc.nextInt();
				// Limpiamos buffer
				sc.nextLine();

				if (agenda.get(nombre) != null) {
					System.out.println("Nombre: " + telefono);
				} else {
					System.out.println("El número introducido no existe.");
				}

			}
			case 3 -> {
				// Hacemos uso del método keySet para recorrer las claves y luego con la clave
				// usamos el metodo get para coger el valor de ese nombre.
				for (String contacto : agenda.keySet()) {
					System.out.println(contacto + ": " + agenda.get(contacto));
					System.out.println();
				}
			}
			case 4 -> {
				System.out.println("Saliendo...");
			}
			default -> {
				System.out.println("La opción introducida es erronea.");
			}
			}

			// Comprobamos que la opción sea distinta de 4, ya que la opción 4 nos sale del
			// programa.
		} while (opc != 4);

		// Cierre de Scanner
		sc.close();
	}

	public static void leerFichero() {
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			String linea = br.readLine();
			String[] datos;

			while (linea != null) {
				datos = linea.split(" ");

				agenda.put(datos[0], Integer.parseInt(datos[1]));

				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			try {
				FileWriter f = new FileWriter(FICHERO);
				f.close();
			} catch (IOException e1) {
				System.out.println("Error al crear el fichero: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
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
