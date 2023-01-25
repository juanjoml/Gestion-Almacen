package aplicacion.personal;
/* Empleado (hereda de Persona): representa a los empleados de la empresa.
   Atributos: puesto: String, numPagas: int (los empleados tienen 12 pagas, es una constante).
   Metodos: constructor, setters, getters y toString. */

public class Empleado extends Persona{
	
	private String puesto;
	public static final int numPagas=12; // Con public static final puede acceder pero no modificarse
		
	public Empleado (String DNI, String nombre, int edad, float salario, String puesto) 
	{	// No le pasamos numPagas al estar ya asignado como una constante.
		super(DNI, nombre, edad, salario);
		this.puesto=puesto;			
	}
	//-----------------------------------------------------------------
	// getPuesto
	//-----------------------------------------------------------------
	public String getPuesto() {
		return puesto;
	}
	//-----------------------------------------------------------------
	// setPuesto
	//-----------------------------------------------------------------
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	//-----------------------------------------------------------------
	// getNumPagas
	//-----------------------------------------------------------------
	public int getNumPagas() {		// No hacemos setNumPagas al estar ya asignado como una constante.
		return numPagas;
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------
	@Override
	public String toString() {
		return "Empleado: DNI: " +this.DNI + " , Nombre: " + this.nombre + " , Edad: " + this.edad + " , Salario: " + this.salario + ", Puesto: " + puesto + ", Numero de pagas: "+ numPagas + "\n";
	}	
}