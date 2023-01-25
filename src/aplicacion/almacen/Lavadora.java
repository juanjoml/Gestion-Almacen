package aplicacion.almacen;
/* Lavadora (hereda de Electrodomestico): esta clase representa una lavadora.
   Atributos: recargoReciclaje: float, margenVenta: float (0,12 para lavadoras).
   Metodos: constructor, toString.
   Metodos adicionales:
   -calcularRecargoReciclaje: calcula un incremento del pvp
       Si la calificacion esta entre A y B, sumar 25
	   Si la calificacion esta entre B y D, sumar 50
	   Si la calificacion es inferior a D, sumar 70
   -calcularPVP: calcula el PVP de la siguiente forma:
	   pvp = precioCompra + precioCompra*margenVenta + recargoReciclaje  */

public class Lavadora extends Electrodomestico {
	
	private float recargoReciclaje;
	private final float margenVenta = 0.12f;  // No ponemos en el constructor margenVenta porque ya tiene un valor fijo.
	
	public Lavadora(String codigo, String nombre, float precioCompra, char calificacionEnergetica,
			int cantidadStock, String ubicacion) 
	{
		super(codigo, nombre, precioCompra, calificacionEnergetica, cantidadStock, ubicacion);
		calcularRecargoReciclaje();
		calcularPVP();		// recargoReciclaje y el atributo heredado pvp los calculamos en los siguientes metodos:
	}
	//-----------------------------------------------------------------
	// calcularRecargoReciclaje
	//-----------------------------------------------------------------	
	private void calcularRecargoReciclaje()
	{
		if (this.calificacionEnergetica=='A' || this.calificacionEnergetica=='B')
		{
			this.recargoReciclaje=25;
		}
		else if (this.calificacionEnergetica=='C' || this.calificacionEnergetica=='D')
		{
			this.recargoReciclaje=50;
		}
		else 
		{
			this.recargoReciclaje=70;
		}
	}
	//-----------------------------------------------------------------
	// calcularPVP
	//-----------------------------------------------------------------	
	private void calcularPVP()
	{
		this.pvp = this.precioCompra + this.precioCompra * this.margenVenta + this.recargoReciclaje;
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------	
	@Override
	public String toString() {
			return "Lavadora: Codigo: " + this.getCodigo() + " , Nombre: " + this.getNombre() + " , Stock: " + this.getCantidadStock() + "\n";					
		}
}