package ejercicio6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		ArrayList<Integer> numerosEnteros = new ArrayList<Integer>();

		// Creamos la variable num como int para almacenar el número que estamos leyendo
		// del fichero.
		int num;

		try (Scanner sc = new Scanner(new FileReader("src\\ejercicio6\\NumerosEntDesor.txt"))) {

			while (sc.hasNextInt()) {
				// Leemos el número y lo almacenamos en la variable numero.
				num = sc.nextInt();

				// Almacenamos en la lista el número que estamos leyendo del fichero.
				numerosEnteros.add(num);
			}
			// Capturamos la función en caso de que la ruta del fichero sea erronea.
		} catch (FileNotFoundException e) {
			// Mostramos un mensaje indicando que el fichero no se encuentra.
			System.out.println("Error al leer el fichero.");
		}

		Collections.sort(numerosEnteros);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio6\\NumerosEntOrd.txt", true))) {

			for (int numeros : numerosEnteros) {
				bw.write(String.valueOf(numeros));
				// Llamamos al metodo del BufferedWriter para añadir un salto de linea.
				bw.newLine();
			}

			// Hacemos un flush para vaciar el buffer y escribir los datos pendientes.
			bw.flush();

			// Capturamos este error en caso de que no se puede leer el fichero y lo
			// mostramos mediante un mensaje por consola.
		} catch (IOException e) {
			System.out.println("Ha habido algún problema al abrir el fichero");
		}
	}

}
