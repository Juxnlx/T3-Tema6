package boletin2.ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Ejercicio4 {

	// Creamos la constante CODEC como String para almacenar la ruta del archivo
	// "codec.txt".
	public static final String CODEC = "src\\boletin2\\ejercicio4\\codec.txt";

	// Creamos la constante TEXTO_ORIGINAL como String para almacenar la ruta del
	// archivo "mensaje.txt".
	public static final String TEXTO_ORIGINAL = "src\\boletin2\\ejercicio4\\mensaje.txt";

	// Creamos la constante TEXTO_CIFRADO como String para almacenar la ruta del
	// archivo "mensaje_cifrado.txt".
	public static final String TEXTO_CIFRADO = "src\\boletin2\\ejercicio4\\cifrado.txt";

	public static void main(String[] args) {

		// Creamos un HashMap para almacenar los caracteres del alfabeto y los
		// caracteres que le corresponden para cifrarlos.
		HashMap<Character, Character> codificador = new HashMap<Character, Character>();

		// Llamamos a la función leerAlfabeto para asignar cada caracter del alfabeto y
		// su codificado al mapa.
		leerAlfabeto(codificador);

		// Llamamos a la función codificarMensaje para escribir en un nuevo fichero el
		// mensaje codificado.
		codificarMensaje(codificador);
	}

	/**
	 * Esta función se encarga de leer el fichero con el alfabeto y el codificado,
	 * agruparlos cada uno en un array y luego añadir cada caracter en el mapa.
	 * 
	 * @param codificador El mapa donde vamos a almacenar el caracter y si caracter
	 *                    por el que lo vamos a codificador.
	 */
	public static void leerAlfabeto(HashMap<Character, Character> codificador) {
		try (BufferedReader br = new BufferedReader(new FileReader(CODEC))) {
			// Creamos la variable lineaAlfabeto como String para almacenar cada caracter
			// del alfabeto.
			String lineaAlfabeto = br.readLine();

			// Creamos la variable lineaCifrado como String para almacenar cada caracter
			// del alfabeto.
			String lineaCifrado = br.readLine();

			// Creamos el array alfabeto como String para almacenar cada caracter del
			// alfabeto.
			String alfabeto[] = lineaAlfabeto.replaceAll("Alfabeto:", "").trim().split(" ");

			// Creamos el array alfabetoCifrado como String para almacenar cada caracter del
			// alfabeto cifrado.
			String alfabetoCodificado[] = lineaCifrado.replaceAll("Cifrado:", "").trim().split(" ");

			// Recorremos el array alfabeto para recorrer cada caracter.
			for (int i = 0; i < alfabeto.length; i++) {

				// Vamos añadiendo a nuestro mapa el caracter que vamos recorriendo, que seria
				// la clave del mapa y el valor seria el caracter por el que se codificaría.
				codificador.put(alfabeto[i].charAt(0), alfabetoCodificado[i].charAt(0));
			}
			// Capturamos la excepción de que el fichero no se puede leer por alguna razón.
		} catch (IOException e) {
			System.out.println("Error al leer el fichero codec: " + e.getMessage());
		}
	}

	/**
	 * Esta función se encarga de leer linea por linea, caracter a caracter y
	 * codificar el caracter que se encuentra en el mapa (clave) por el codificado
	 * que le corresponde (valor). Y luego ese valor esa va añadiendo a una cadena
	 * que finalmente se añadira al nuevo fichero.
	 * 
	 * @param codificador El mapa donde estan almacenados los caracteres y sus
	 *                    codificados correspondientes.
	 */
	public static void codificarMensaje(HashMap<Character, Character> codificador) {

		try {
			// Creamos el BufferedReader para leer el fichero con la información sin
			// codificar.
			BufferedReader br = new BufferedReader(new FileReader(TEXTO_ORIGINAL));

			// Creamos el BufferedWriter para escribir en el fichero la información
			// codificada del mensaje sin codificar.
			BufferedWriter bw = new BufferedWriter(new FileWriter(TEXTO_CIFRADO));

			// Creamos la variable linea como String para almacenar cada linea que tenemos
			// que cifrar.
			String linea = br.readLine();

			// Creamos la variable lineaCifrada como String para almacenar la linea ya
			// codificada.
			String lineaCodificada;

			// Creamos la variable caracter como char para almacenar el caracter de la linea
			// que estamos recorriendo.
			char caracter;

			// Comprobamos si la linea no es null, si es así...
			while (linea != null) {
				// Inicializamos lineaCodificada a cadena vacia.
				lineaCodificada = "";

				// Recorremos cada caracter de la linea.
				for (int i = 0; i < linea.length(); i++) {
					// Almacenamos cada caracter en la variable caracter, la ponemos en minuscula y
					// cogemos el caracter haciendo uso de charAt de i.
					caracter = linea.toLowerCase().charAt(i);

					// Comprobamos si ese caracter se encuentra en el mapa, si es así a linea
					// codificada le añadimos el valor de ese caracter que es el cifrado que le
					// corresponde.
					if (codificador.containsKey(caracter)) {
						lineaCodificada += codificador.get(caracter);

						// Si no, añadimos el caracter normal.
					} else {
						lineaCodificada += caracter;
					}
				}

				// Añadimos el mensaje cifrado al fichero.
				bw.write(lineaCodificada);
				// Añadimos un salto de linea la fichero.
				bw.newLine();
				
				//Leemos la siguiente linea.
				linea = br.readLine();
			}

			// Hacemos un flush para vaciar el buffer y escribir los datos pendientes.
			bw.flush();
			
			//Cerramos los buffer
			br.close();
			bw.close();
			

			// Mostramos un mensaje indicando que el cifrado del mensaje se
			System.out.println("Texto cifrado correctamente.");

			// Capturamos la excepción de que el fichero no se encuentra, ya sea porque no
			// existe o la ruta esta mal escrita
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no se encuentra.");
			// Capturamos la excepción de que el fichero no se puede leer por alguna razón.
		} catch (IOException e) {
			System.out.println("Error al leer el fichero codec: " + e.getMessage());
		}

	}
}
