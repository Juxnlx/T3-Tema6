package boletin1.ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {

		// Creamos la variable nombre como String para almacenar el nombre de una
		// persona.
		String nombre;

		// Creamos la variable edad como int para almacenar la edad de una persona.
		int edad;

		// Creamos el Scanner para leer el nombre y la edad solicitadas al usuario.
		Scanner sc = new Scanner(System.in);

		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el BufferedWriter para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (BufferedWriter frasesUsuario = new BufferedWriter(new FileWriter("src\\boletin1.ejercicio5\\datos.txt", true))) {

			// Le pedimos al usuario que introduzca un nombre y la leemos.
			System.out.println("Introduce un nombre: ");
			nombre = sc.nextLine();

			// Le pedimos al usuario que introduzca la edad y la leemos.
			System.out.println("Introduce una edad: ");
			edad = sc.nextInt();

			// Llamamos al metodo write del BufferedWriter para añadir al fichero los datos
			// solicitados al usuario.
			frasesUsuario.write(nombre);
			frasesUsuario.write(" ");
			frasesUsuario.write(String.valueOf(edad));

			// Llamamos al metodo del BufferedWriter para añadir un salto de linea.
			frasesUsuario.newLine();

			// Hacemos un flush para vaciar el buffer y escribir los datos pendientes.
			frasesUsuario.flush();

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Ha habido algún problema al abrir el fichero");
		}

		// Cierre de Scanner
		sc.close();
	}

}