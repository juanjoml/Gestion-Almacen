package aplicacion;
/* Este proyecto tiene un paquete principal llamado aplicacion, que contiene la clase Aplicacion con el metodo main de la aplicacion 
   y dos paquetes adicionales para organizar sus ficheros: aplicacion.personal y aplicacion.almacen.
   La clase Aplicacion contiene un objeto de tipo Personal, y otro de tipo Almacen, que representan, respectivamente, 
   al modulo de gestion de personal y al modulo de gestion del almacen. 
   El metodo main() tiene un menu con las siguientes opciones:
	Gestion de personal:
		1. Registrar un nuevo empleado: registra un nuevo empleado.
		2. Registrar un nuevo jefe: registra un nuevo jefe.
		3. Borrar personal: borra un empleado o jefe (dando su DNI).
		4. Listar personal de la empresa: muestra el listado de personal, asi como el coste total de los salarios y el coste total de los empleados.
	Gestion de almacen:
		5. Registrar una nueva mercancia: registra una nueva mercancia en el almacen de la empresa.
		6. Vender una mercancia: se vende una mercancia (dando el codigo de electrodomestico y teniendo en cuenta que haya unidades suficientes).
		7. Listar el inventario: imprime el inventario del almacen.
	Aplicacion
		8. Salir de la aplicacion */

import java.util.Scanner;

import aplicacion.almacen.*;
import aplicacion.personal.Empleado;
import aplicacion.personal.Jefe;
import aplicacion.personal.Personal;

@SuppressWarnings("resource")

public class Aplicacion {
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);		
		int salir = -1;
		
		while (salir == -1)
		{
			System.out.println("\nGestion de personal \n");
			System.out.println("\t1) Registrar un nuevo empleado  ");
			System.out.println("\t2) Registrar un nuevo jefe  ");
			System.out.println("\t3) Borrar personal ");
			System.out.println("\t4) Listar personal de la empresa ");
			System.out.println("\t5) Registrar mercancia ");
			System.out.println("\t6) Vender mercancia ");
			System.out.println("\t7) Listar inventario ");
			System.out.println("\t8) Salir \n");
			System.out.print("Introduce una opcion: \n");
			
			int opcion = scan.nextInt();
			
			switch(opcion)
			{
				case 1:
				{
					registrarEmpleado();
					break;
				}	
				case 2:
				{
					registrarJefe();
					break;
				}	
				case 3:
				{
					borrarPersonal();
					break;
				}	
				case 4:
				{
					listarPersonal();
					break;
				}					
				case 5:
				{
					registrarMercancia();
					break;
				}				
				case 6:
				{
					venderMercancia();
					break;
				}				
				case 7:
				{
					listarInventario();
					break;
				}				
				case 8:
				{
					salir=0;
					break;
				}				
				default:
				break;
			}	
		}	
	}
	//-----------------------------------------------------------------
	// registrarEmpleado
	//-----------------------------------------------------------------
	public static void registrarEmpleado() {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Introduce un nuevo empleado: \n");
		System.out.println("Introduce el DNI: ");
		String DNI= scan.next();
		System.out.println("Introduce el nombre: ");
		String nombre= scan.next();		
		System.out.println("Introduce la edad: ");		
		int edad = scan.nextInt();		
		System.out.println("Introduce el salario: ");		
		float salario=scan.nextFloat();		
		System.out.println("Introduce el puesto: ");		
		String puesto= scan.next(); 
		
		Empleado empleado = new Empleado(DNI, nombre, edad, salario, puesto); // Creamos la instancia empleado
		
		Personal.registrarPersonal(empleado);	// y la agregamos al ArrayList personal (que es de tipo Persona)	
	}
	//-----------------------------------------------------------------
	// registrarJefe
	//-----------------------------------------------------------------
	public static void registrarJefe() {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Introduce un nuevo jefe: \n");
		System.out.println("Introduce el DNI: ");
		String DNI= scan.next();
		System.out.println("Introduce el nombre: ");		
		String nombre= scan.next();		
		System.out.println("Introduce la edad: ");		
		int edad = scan.nextInt();		
		System.out.println("Introduce el salario: ");		
		float salario=scan.nextFloat();		
		System.out.println("Introduce el cargo: ");		
		String cargo= scan.next(); 
		
		Jefe jefe = new Jefe(DNI, nombre, edad, salario, cargo);
		
		Personal.registrarPersonal(jefe);		
	}
	//-----------------------------------------------------------------
	// borrarPersonal
	//-----------------------------------------------------------------
	public static void borrarPersonal() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce el DNI a borrar: ");		
		String DNI = scan.next();		
		int borrado = Personal.borrarPersonal(DNI);
		
		if(borrado==1)
		{
			System.out.println("\n...borrado con exito");
		}
		else
		{
			System.out.println("\nNo se encuentra ningun personal con dicho DNI");
		}
	}
	//-----------------------------------------------------------------
	// listarPersonal
	//-----------------------------------------------------------------
	public static void listarPersonal() {
		
		System.out.println("Lista de personal: ");
		System.out.println();
		System.out.println(Personal.listarPersonal());
	}
	//-----------------------------------------------------------------
	// registrarMercancia
	//-----------------------------------------------------------------
	public static void registrarMercancia() {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Introduce una nueva mercancia: ");
		System.out.println("\nTipo de mercancia (1=Televisor 2=Lavadora 3=Portatil)");
		int tipo =scan.nextInt();		
		System.out.println();		
		System.out.println("Introduce el codigo: ");		
		String codigo= scan.next();		
		System.out.println("Introduce el nombre: ");		
		String nombre= scan.next();		
		System.out.println("Introduce el precio de compra: ");		
		float precioCompra= scan.nextFloat();		
		System.out.println("Introduce calificacionEnergetica (A-F): ");		
		char calificacionEnergetica= scan.next().charAt(0); //.charAt(0)se queda con el primer caracter de un String		
		System.out.println("Introduce la cantidad en stock: ");		
		int cantidadStock= scan.nextInt();		
		System.out.println("Introduce la ubicacion: ");		
		String ubicacion= scan.next();		
		
		Electrodomestico e =null;
	
		switch(tipo)
		{
			case 1: 
			{
				e = new Televisor(codigo, nombre, precioCompra, calificacionEnergetica,
						cantidadStock, ubicacion) ;				
				break;
			}	
			case 2: 
			{
				e = new Lavadora(codigo, nombre, precioCompra, calificacionEnergetica,
						cantidadStock, ubicacion)  ;				
				break;
			}	
			case 3: 	
			{
				
				e = new Portatil (codigo, nombre, precioCompra, calificacionEnergetica,
						cantidadStock, ubicacion)  ;
				break;
			}	
				default: break;
		}
		Almacen.registrarMercancia(e);
	}
	//-----------------------------------------------------------------
	// venderMercancia
	//-----------------------------------------------------------------
	public static void venderMercancia()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce el codigo de la mercancia a vender: ");		
		String codigo = scan.next();		
		System.out.print("Introduce la cantidad: ");		
		int cantidad = scan.nextInt();		
		float beneficio = Almacen.venderMercancia(codigo, cantidad);
		
		if(beneficio==0.0f)
		{
			System.out.println("\nBeneficio de la venta: 0 (el articulo no existe o no hay existencias)");
		}
		else
		{
			System.out.println("\nBeneficio de la venta: "+ beneficio);
		}
	}
	//-----------------------------------------------------------------
	// listarInventario
	//-----------------------------------------------------------------
	public static void listarInventario()
	 {
			System.out.println("Lista de mercancias: ");
			System.out.println();
			System.out.println(Almacen.listarInventario());
	 }
}