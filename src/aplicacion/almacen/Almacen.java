package aplicacion.almacen;
/* Almacen: esta clase representa al modulo de gestion de almacen de la aplicacion. 
   Contiene los metodos de logica de negocio (vease el apartado modulos adicionales, mas abajo). 
   Contiene un ArrayList en el que se registran todos los articulos que la empresa tiene en stock.
   Atributos: stock: ArrayList que contiene Electrodomesticos en stock, stockValorado: float, stockPVP: float.
   Metodos adicionales (estaticos):
   -registrarMercancia: agrega un nuevo electrodomestico al sistema.
   -venderMercancia: vende una mercancia del almacen, restando la cantidad especificada. 
	   Se debe comprobar que la mercancia exista (indicando el codigo previamente). 
	   Se debe contemplar tambien la cantidad que vamos a vender y solo se realiza la venta siempre y cuando haya cantidad suficiente. 
	   Este metodo devuelve el beneficio obtenido de la venta (se calcula restando al pvp el precio de compra).
   -calcularInventarioValorado: actualiza stockValorado para sumar los precios de compra de todos los articulos. 
	   Tambien actualiza stockPVP para sumar todo el importe en euros resultante de sumar el pvp de cada articulo (multiplicandolo por 
	   las cantidades almacenadas en el almacen).
   -listarInventario: devuelve un string con todos los articulos del almacen. Adicionalmente, devuelve tambien el stockValorado y 
	   el stockPVP en euros en el mismo string.*/

import java.util.ArrayList;

public class Almacen {
	
	public static ArrayList<Electrodomestico> stock = new ArrayList<Electrodomestico>();
	
	public static float stockValorado=0.0f;
	public static float stockPVP=0.0f;
	//-----------------------------------------------------------------
	// registrarMercancia
	//-----------------------------------------------------------------	
	public static void registrarMercancia(Electrodomestico e)	// Agrega el nuevo electrodomestico que le pasamos al ArrayList (e)
	{
		stock.add(e);	
		calcularInventarioValorado();	//Actualiza los costes
	}
	//-----------------------------------------------------------------
	// venderMercancia
	//-----------------------------------------------------------------	
	public static float venderMercancia(String codigo, int cantidadVenta)	// Le pasamos los 2 valores que vamos a comparar
	{						
		float beneficio=0.0f;		
		for (int i=0; i<stock.size(); i++) // Recorre el ArrayList: 
		{
			if(stock.get(i).getCodigo().compareTo(codigo)==0) // Primero, viendo que ese codigo exista
			{
				if(stock.get(i).getCantidadStock()>=cantidadVenta)// y segundo, que haya cantidad suficiente.
				{
					// Obtengo el pvp y el precio de compra de ese elemento del ArrayList y asigno ambos a una variable					
					float pvp = stock.get(i).getPvp();					
					float precioCompra = stock.get(i).getPrecioCompra();
					// Calculo el beneficio, que puede incrementarse si lo ejecutamos de nuevo.					
					beneficio += cantidadVenta * (pvp-precioCompra);
					//Primero me da la cantidad de stock, le resto la cantidad de venta y la guardo otra vez en la cantidad de stock.
					stock.get(i).setCantidadStock(stock.get(i).getCantidadStock()-cantidadVenta);
				}
			}
		}
		return beneficio;
	}
	//-----------------------------------------------------------------
	// calcularInventarioValorado
	//-----------------------------------------------------------------	
	public static void calcularInventarioValorado()
	{
		stockValorado=0.0f; // Se inicializan cada vez que usan
		stockPVP=0.0f; 	    // "                             "		
		for (int i=0; i<stock.size(); i++)
		{	// Sumamos el precio por la cantidad de todos los articulos del stock	
			stockValorado +=stock.get(i).getPrecioCompra() * stock.get(i).getCantidadStock(); 	
			// Sumamos el pvp por la cantidad de todos los articulos del stock	
			stockPVP +=stock.get(i).getPvp() * stock.get(i).getCantidadStock();			
		}
	}
	//-----------------------------------------------------------------
	// listarInventario
	//-----------------------------------------------------------------	
	public static String listarInventario()
	{
		String listado="";
		for (int i=0; i<stock.size(); i++)
		{
			listado +=stock.get(i).toString();
		}		
		listado +="\n";	
		// valueOf convierte a cadenas los tipos de datos pasados como parametro
		listado +="Stock valorado: "+String.valueOf(stockValorado)+"\n";				
		listado +="Stock PVP: "+String.valueOf(stockPVP)+"\n";		
		return listado;
	}	
}