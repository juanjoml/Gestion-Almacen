package aplicacion.almacen;
/* Televisor (hereda de Electrodomestico): esta clase representa un televisor.
   Atributos: recargoReciclaje: float, margenVenta: float (0,15 para televisores).
   Metodos: constructor, toString.
   Metodos adicionales:
   -calcularRecargoReciclaje: calcula un incremento del pvp
       Si la calificacion esta entre A y C, sumar 50
	   Si la calificacion esta entre D y E, sumar 100
	   Si la calificacion es inferior a E, sumar 150
   -calcularPVP: calcula el PVP de la siguiente forma:
	   pvp = precioCompra + precioCompra*margenVenta + recargoReciclaje	 */

public class Televisor extends Electrodomestico {
	
	private float recargoReciclaje;
	private final float margenVenta = 0.15f;  // No ponemos en el constructor margenVenta porque ya tiene un valor fijo.
	
	public Televisor(String codigo, String nombre, float precioCompra, char calificacionEnergetica,
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
		if (this.calificacionEnergetica=='A' || this.calificacionEnergetica=='B' || this.calificacionEnergetica=='C')
		{
			this.recargoReciclaje=50;
		}
		else if (this.calificacionEnergetica=='D' || this.calificacionEnergetica=='E')
		{
			this.recargoReciclaje=100;
		}
		else 
		{
			this.recargoReciclaje=150;
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
		return "Televisor: Codigo: " + this.getCodigo() + " , Nombre: " + this.getNombre() + " , Stock: " + this.getCantidadStock() + "\n";				
	}
}