package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import datos.Pedido;

public class PedidoABM {

	PedidoDao dao = new PedidoDao();

	public Pedido traer(long idPedido) {
		return dao.traer(idPedido);
	}
	// Caso de Uso: Calcula la recaudación total de los Food Trucks dentro de un período determinado
	public long calcularRecaudacionFoodTrucksPorFechas(LocalDate desde, LocalDate hasta) {
	    if (desde.isAfter(hasta)) {
	        throw new IllegalArgumentException("La fecha 'desde' no puede ser posterior a 'hasta'");
	    }

	    List<Pedido> pedidos = dao.traerPedidosFoodTrucksPorFechas(desde, hasta);
	    
	    long totalRecaudado = 0;
	    for (Pedido p : pedidos) {
	        totalRecaudado += p.precioTotalPedido();
	    }
	    
	    return totalRecaudado;
	}
	public int agregar(Pedido p) {
		if(p.getFestivalPaso()== null) {
			throw new UnsupportedOperationException("El Festival no existe");
		}else {
			if(p.getUnidadVentaEntrega()==null) {
				throw new UnsupportedOperationException("La unidad de venta no existe");
			}
		}
		return dao.agregar(p);
	}

	public void modificar(Pedido p) {
		if(dao.traer(p.getIdPedido())== null) {
			throw new UnsupportedOperationException("El pedido no existe");
		}
		dao.actualizar(p);
	}

	public void eliminar(long idPedido) {
		if(dao.traer(idPedido)== null) {
			throw new UnsupportedOperationException("El pedido no existe");
		}
		Pedido p = dao.traer(idPedido);
		dao.eliminar(p);
	}

	public List<Pedido> traer() {
		return dao.traer();
	}

	public Pedido traerPedidoYDetalles(long idPedido) {
		if(dao.traer(idPedido)== null) {
			throw new UnsupportedOperationException("El pedido no existe");
		}
		return dao.traerPedidoYDetalles(idPedido);
	}
}
