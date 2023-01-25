package aplicacion.personal;
/* Jefe (hereda de Persona): representa a los jefes de la empresa.
   Atributos: cargo: String, numPagas: int (los jefes tienen 14 pagas, es una constante).
   Metodos: constructor, setters, getters y toString */

public class Jefe extends Persona{
	
	private String cargo;
	public static final int numPagas=14; // Con public static final puede acceder pero no modificarse
		
	public Jefe (String DNI, String nombre, int edad, float salario, String cargo) 
	{	// No le pasamos numPagas al estar ya asignado como una constante.
		super(DNI, nombre, edad, salario);
		this.cargo=cargo;				
	}
	//-----------------------------------------------------------------
	// getCargo
	//-----------------------------------------------------------------
	public String getCargo() {
		return cargo;
	}
	//-----------------------------------------------------------------
	// setCargo
	//-----------------------------------------------------------------
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	//-----------------------------------------------------------------
	// getNumPagas
	//-----------------------------------------------------------------
	public int getNumPagas() {	// No hacemos setNumPagas al estar ya asignado como una constante.
		return numPagas;
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------
	@Override
	public String toString() {
		return "Jefe: DNI: " +this.DNI + " , Nombre: " + this.nombre + " , Edad: " + this.edad + " , Salario: " + this.salario 
				+ ", Cargo: " + cargo + ", Numero de pagas: "+ numPagas + "\n";
	}	
}