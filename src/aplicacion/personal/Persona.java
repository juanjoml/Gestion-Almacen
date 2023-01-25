package aplicacion.personal;
/* Persona: Esta clase representa a las personas que trabajan en la empresa. Se especializa en dos subclases: Empleado y Jefe.
   Atributos: DNI: String, nombre: String, edad: int, salario: float. 
   Metodos: constructor, setters, getters.	*/

public abstract class Persona {
	
	protected String DNI;
	protected String nombre;
	protected int edad; 
	protected float salario;
	
	public Persona(String DNI, String nombre, int edad, float salario) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	//-----------------------------------------------------------------
	// getDNI
	//-----------------------------------------------------------------
	public String getDNI() {
		return DNI;
	}
	//-----------------------------------------------------------------
	// setDNI
	//-----------------------------------------------------------------
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	//-----------------------------------------------------------------
	// getNombre
	//-----------------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	//-----------------------------------------------------------------
	// setNombre
	//-----------------------------------------------------------------
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//-----------------------------------------------------------------
	// getEdad
	//-----------------------------------------------------------------
	public int getEdad() {
		return edad;
	}
	//-----------------------------------------------------------------
	// setEdad
	//-----------------------------------------------------------------
	public void setEdad(int edad) {
		this.edad = edad;
	}
	//-----------------------------------------------------------------
	// getSalario
	//-----------------------------------------------------------------
	public float getSalario() {
		return salario;
	}
	//-----------------------------------------------------------------
	// setSalario
	//-----------------------------------------------------------------
	public void setSalario(float salario) {
		this.salario = salario;
	}
}