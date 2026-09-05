package datos;


import java.util.Set;

public class Plato {

	private long idPlato;
	private String nombre;
	private long precio;
	private long costoProd;
	private Set<DetallePedido> detalles;
	private UnidadVenta unidadVenta;

	public Plato() {}
	
	


	public Plato(String nombre, long precio, long costoProd, UnidadVenta unidadVenta) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.costoProd = costoProd;
		this.unidadVenta = unidadVenta;
	}




	public long getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(long idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public long getCostoProd() {
		return costoProd;
	}

	public void setCostoProd(long costoProd) {
		this.costoProd = costoProd;
	}

	

	public Set<DetallePedido> getDetalles() {
		return detalles;
	}




	public void setDetalles(Set<DetallePedido> detalles) {
		this.detalles = detalles;
	}




	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}


	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}


	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costoProd=" + costoProd
				+ "]";
	}
}
