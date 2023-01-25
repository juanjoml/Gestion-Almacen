package aplicacion.almacen;
/* Electrodomestico: esta clase representa a los electrodomesticos que vende la empresa. Se especializa en 3 subclases: 
   Televisor, Lavadora y Portatil.
   Atributos: codigo: String, nombre: String, precioCompra: float, pvp: float (precio de venta al publico),
   calificacionEnergetica: char (letras A-F), cantidadStock: int (numero de unidades en stock),
   ubicacion: String (contiene la posicion del almacen).
   Metodos: constructor, setters, getters */
public abstract class Electrodomestico {
	
	protected String codigo;
	protected String nombre;
	protected float precioCompra;
	protected float pvp;
	protected char calificacionEnergetica;
	protected int cantidadStock;
	protected String ubicacion;
	
	public Electrodomestico(String codigo, String nombre, float precioCompra, char calificacionEnergetica,
			int cantidadStock, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.calificacionEnergetica = calificacionEnergetica;
		this.cantidadStock = cantidadStock;
		this.ubicacion = ubicacion;
	}
	//-----------------------------------------------------------------
	// getCodigo
	//-----------------------------------------------------------------
	public String getCodigo() {
		return codigo;
	}
	//-----------------------------------------------------------------
	// setCodigo
	//-----------------------------------------------------------------
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	// getPrecioCompra
	//-----------------------------------------------------------------
	public float getPrecioCompra() {
		return precioCompra;
	}
	//-----------------------------------------------------------------
	// setPrecioCompra
	//-----------------------------------------------------------------
	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}
	//-----------------------------------------------------------------
	// getPvp
	//-----------------------------------------------------------------
	public float getPvp() {
		return pvp;
	}
	//-----------------------------------------------------------------
	// setPvp
	//-----------------------------------------------------------------
	public void setPvp(float pvp) {
		this.pvp = pvp;
	}
	//-----------------------------------------------------------------
	// getCalificacionEnergetica
	//-----------------------------------------------------------------
	public char getCalificacionEnergetica() {
		return calificacionEnergetica;
	}
	//-----------------------------------------------------------------
	// setCalificacionEnergetica
	//-----------------------------------------------------------------
	public void setCalificacionEnergetica(char calificacionEnergetica) {
		this.calificacionEnergetica = calificacionEnergetica;
	}
	//-----------------------------------------------------------------
	// getCantidadStock
	//-----------------------------------------------------------------
	public int getCantidadStock() {
		return cantidadStock;
	}
	//-----------------------------------------------------------------
	// setCantidadStock
	//-----------------------------------------------------------------
	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	//-----------------------------------------------------------------
	// getUbicacion
	//-----------------------------------------------------------------
	public String getUbicacion() {
		return ubicacion;
	}
	//-----------------------------------------------------------------
	// setUbicacion
	//-----------------------------------------------------------------
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}