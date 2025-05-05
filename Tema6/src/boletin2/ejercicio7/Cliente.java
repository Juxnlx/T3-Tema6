package boletin2.ejercicio7;

public class Cliente implements Comparable<Cliente>{

	// Creamos la variable dni como String para almacenar el dni del cliente.
	String dni;

	// Creamos la variable nombre como String para almacenar el nombre completo del
	// cliente.
	String nombre;

	// Creamos la variable fechaNacimiento como String para almacenar la fecha
	// del nacimiento del cliente.
	String fechaNacimiento;

	// Creamos la variable saldo como double para almacenar el saldo del cliente.
	double saldo;

	/**
	 * Creamos un constructor con solo el atributo dni ya que se puede utilizar en
	 * funciones como buscar o dar de baja a clientes.
	 * 
	 * @param dni El dni del cliente.
	 */
	public Cliente(String dni) {
		if (dni != null && !dni.isBlank()) {
			this.dni = dni;
		}
	}

	/**
	 * Creamos un constructor con todos los atributos para la creación de un
	 * cliente.
	 * 
	 * @param dni             El dni del cliente.
	 * @param nombre          El nombre del cliente.
	 * @param fechaNacimiento La fecha de nacimiente del cliente.
	 * @param saldo           El saldo del cliente.
	 */
	public Cliente(String dni, String nombre, String fechaNacimiento, double saldo) {
		this(dni);

		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

		if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {
			this.fechaNacimiento = fechaNacimiento;
		}

		if (saldo >= 0) {
			this.saldo = saldo;
		}
	}

	/**
	 * Esta función nos devuelve el nombre del cliente.
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Esta función modifica el nombre por el pasado por parametro.
	 * 
	 * @param nombre El nuevo nombre del cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Esta función nos devuelve la fecha de nacimiento del cliente.
	 * 
	 * @return La fecha de nacimiento del cliente.
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Esta función modifica la fecha de nacimiento por la nueva fecha pasada por
	 * parametro.
	 * 
	 * @param fechaNacimiento La nueva fecha de nacimiento.
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Esta función nos devuelve el saldo del cliente.
	 * 
	 * @return El saldo del cliente.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Esta función modifica el saldo por el nuevo saldo pasado por parametro.
	 * 
	 * @param saldo El nuevo saldo del cliente.
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Esta función se encarga de devolver el dni del cliente.
	 * 
	 * @return El dni del cliente.
	 */
	public String getDni() {
		return dni;
	}

	@Override
	public java.lang.String toString() {
		String infoCliente;
		
		infoCliente = "DNI: " + dni + "\n";
		infoCliente = "Nombre: " + nombre + "\n";
		infoCliente = "Saldo: " + saldo + "\n";
		infoCliente = "Edad: " + fechaNacimiento + "\n";
		
		return infoCliente;
	}
	
	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.dni);
	}
}
