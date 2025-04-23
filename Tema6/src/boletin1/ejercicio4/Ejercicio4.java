package boletin1.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		// Creamos la variable frase como int para almacenar la frase introducida por el
		// usuario.
		String frase;

		// Creamos el Scanner para leer las frases introducidas por el usuario.
		Scanner sc = new Scanner(System.in);
	

		// Capturamos el codigo susceptible a lanzar alguna excepción. Capturamos en el
		// try el BufferedWriter para que se cierre cuando termine de ejecutarse el
		// bloque try.
		try (BufferedWriter frasesUsuario = new BufferedWriter(new FileWriter("src\\boletin1\\ejercicio4\\Texto.txt", true))) {

			// Le pedimos al usuario que introduzca una frase y la leemos.
			System.out.println("Introduce una frase: ");
			frase = sc.nextLine();

			// Comprobamos si la frase es distinta a fin, si es así...
			while (!frase.equals("fin")) {

				// Llamamos al metodo write del BufferedWriter para añadir al fichero la frase
				// pasada por parametro.
				frasesUsuario.write(frase);

				// Llamamos al metodo del BufferedWriter para añadir un salto de linea.
				frasesUsuario.newLine();

				// Le pedimos al usuario que introduzca una frase y la leemos.
				System.out.println("Introduce una frase: ");
				frase = sc.nextLine();
			}

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
