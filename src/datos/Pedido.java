package datos;

import java.time.LocalDate;

import java.util.Set;

public class Pedido {

	private long idPedido;
	private UnidadVenta unidadVentaEntrega;
	private Festival festivalPaso;
	private LocalDate fechaTransaccion;
	private Set<DetallePedido> detalles;

	public Pedido() {}

	

	public Pedido(UnidadVenta unidadVentaEntrega, Festival festivalPaso, LocalDate fechaTransaccion) {
		super();
		this.unidadVentaEntrega = unidadVentaEntrega;
		this.festivalPaso = festivalPaso;
		this.fechaTransaccion = fechaTransaccion;
	}



	public long getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public UnidadVenta getUnidadVentaEntrega() {
		return unidadVentaEntrega;
	}

	public void setUnidadVentaEntrega(UnidadVenta unidadVentaEntrega) {
		this.unidadVentaEntrega = unidadVentaEntrega;
	}

	public Festival getFestivalPaso() {
		return festivalPaso;
	}

	public void setFestivalPaso(Festival festivalPaso) {
		this.festivalPaso = festivalPaso;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}



	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}



	public Set<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public long precioTotalPedido() {
	    long total = 0;
	    if (detalles != null) {
	        for (DetallePedido detalle : detalles) {
	            total += detalle.precioTotal();
	        }
	    }
	    return total;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
}
