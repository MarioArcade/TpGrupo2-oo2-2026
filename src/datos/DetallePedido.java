package datos;

public class DetallePedido {

	private long idDetallePedido;
	private Pedido pedido;
	private Plato plato;
	private int cantPlato;

	public DetallePedido() {}

	public DetallePedido(Pedido pedido, Plato plato, int cantPlato) {
		this.pedido = pedido;
		this.plato = plato;
		this.cantPlato = cantPlato;
	}

	public long getIdDetallePedido() {
		return idDetallePedido;
	}

	protected void setIdDetallePedido(long idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantPlato() {
		return cantPlato;
	}

	public void setCantPlato(int cantPlato) {
		this.cantPlato = cantPlato;
	}

	
	public Long precioTotal() {
	    if (plato != null) {
	        // Multiplica la cantidad por el precio (asumiendo que plato.getPrecio() retorna un tipo entero/long).
	        return (long) cantPlato * plato.getPrecio(); 

	    }
	    return 0L;
	}

	@Override
	public String toString() {
		return "DetallePedido [idDetallePedido=" + idDetallePedido + ", cantPlato=" + cantPlato + "]";
	}
}
