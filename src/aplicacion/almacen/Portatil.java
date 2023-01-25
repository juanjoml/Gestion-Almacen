package aplicacion.almacen;
/* Portatil (hereda de Electrodomestico): esta clase representa un portatil.
   Atributos: recargoReciclaje: float, margenVenta: float (0,23 para portatiles).
   Metodos: constructor, toString.
   Metodos adicionales:
   -calcularRecargoReciclaje: calcula un incremento del pvp
       Si la calificacion esta entre A y C, sumar 30
	   Si la calificacion esta entre D y E, sumar 50
	   Si la calificacion es inferior a E, sumar 65
   -calcularPVP: calcula el PVP de la siguiente forma:
	   pvp = precioCompra + precioCompra*margenVenta + recargoReciclaje  */

public class Portatil extends Electrodomestico {
	
	private float recargoReciclaje;
	private final float margenVenta = 0.23f;  // No ponemos en el constructor margenVenta porque ya tiene un valor fijo.
	
	public Portatil(String codigo, String nombre, float precioCompra, char calificacionEnergetica,
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
			this.recargoReciclaje=30;
		}
		else if (this.calificacionEnergetica=='D' || this.calificacionEnergetica=='E')
		{
			this.recargoReciclaje=50;
		}
		else 
		{
			this.recargoReciclaje=65;
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
			return "Portatil: Codigo: " + this.getCodigo() + " , Nombre: " + this.getNombre() + " , Stock: " + this.getCantidadStock() + "\n";					
		}
}