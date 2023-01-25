package aplicacion.personal;

/* Personal: esta clase representa al modulo de gestion de personal de la aplicacion. 
   Contiene los metodos de logica de negocio (vease el apartado modulos adicionales, mas abajo). 
   Contiene un ArrayList en el que se registran todas las personas que trabajan en la empresa.
   Atributos: personal: ArrayList de tipo Persona, costeEmpleados: float, costeSalarios: float.
   Metodos adicionales (estaticos):
   -registrarPersonal: agrega una nueva persona al sistema.
   -borrarPersonal: borra una persona (dado su DNI).
   -actualizarCostePersonal: actualiza los costes de personal:
   -costeSalarios: se suman todos los salarios (multiplicando por el n�mero de pagas, segun si es Empleado o Jefe).
   -costeEmpleados: se multiplica costeSalarios * 1,21.
   -listarPersonal: devuelve un String con todo el personal. Se incluye informacion del coste total de los salarios 
	   y el coste total de los empleados (que es el coste de la empresa), representados por los atributos costeSalarios y costeEmpleados. */

import java.util.ArrayList;

public class Personal {
	
	private static ArrayList<Persona> personal = new ArrayList<Persona>();
	private static float costeEmpleados=0.0f;
	private static float costeSalarios=0.0f;
	
	// Esta clase no tiene constructor porque todos los atributos son estaticos (pertenecen a la clase, no a un objeto).
	
	//-----------------------------------------------------------------
	// registrarPersonal
	//-----------------------------------------------------------------
	public static void registrarPersonal(Persona p)
	{	
		personal.add(p);
		actualizarCostePersonal();	//Actualiza los costes.	
	}
	//-----------------------------------------------------------------
	// borrarPersonal
	//-----------------------------------------------------------------
	public static int borrarPersonal(String DNI) // Le pasamos un dni y si encuentra alguien en el Array con el, lo borra.
	{			
		int borrado = 0;
		
		for (int i=0; i<personal.size(); i++) 	// Recorre el numero de elementos del ArrayList
		{				
			if(personal.get(i).getDNI().compareTo(DNI)==0) // Compara el DNI de c/elemento del ArrayList con el que le pasamos.
			{ 											// compareTo compara dos cadenas y da 0 si son iguales.			
				personal.remove(i);	// Si son iguales, borramos.
				borrado=1;
			}
		}
		actualizarCostePersonal(); //Actualiza los costes.
		return borrado;	// Devuelve el resultado de borrado.
	}
	//-----------------------------------------------------------------
	// actualizarCostePersonal
	//-----------------------------------------------------------------
	private static void actualizarCostePersonal()
	{	// Metodo que no recibe nada pero realiza unos calculos.
		// Si tengo un ArrayList con varias Personas, coge
		// todas las personas, suma los salarios y los guarda
		// en costeEmpleados y costeSalarios.
		
		costeSalarios=0.0f; // Se inicializan cada vez que usan
		costeEmpleados=0.0f; // "                             "
		
		for (int i=0; i<personal.size(); i++) 
		{			
			if (personal.get(i) instanceof Jefe) // Compruebo si el objeto es de tipo Jefe
			{
				costeSalarios +=personal.get(i).getSalario()*Jefe.numPagas; // Calculo el numero de pagas del jefe.								
				costeEmpleados +=personal.get(i).getSalario()*Jefe.numPagas*1.21f; // Calculo el coste de los empleados.								
			}
			else if (personal.get(i) instanceof Empleado) // Y si el objeto es de tipo empleado
			{
				costeSalarios +=personal.get(i).getSalario()*Empleado.numPagas; // Calculo el numero de pagas de los empleados.											
				costeEmpleados +=personal.get(i).getSalario()*Empleado.numPagas*1.21f; // Calculo el coste de los empleados.								
			}			
			// Suma el salario anual de todo el mundo multiplicado por 1.21
		}
	}
	//-----------------------------------------------------------------
	// listarPersonal
	//-----------------------------------------------------------------
	public static String listarPersonal()
	{
		String listado="";		
		for (int i=0; i<personal.size(); i++)
		{
			listado +=personal.get(i).toString();
		}		
		listado +="\n";
		// valueOf convierte a cadenas los tipos de datos pasados como parametro
		listado +="Coste empleados: "+String.valueOf(costeEmpleados)+"\n"; 				
		listado +="Coste salarios: "+String.valueOf(costeSalarios)+"\n";		
		return listado;
	}
}