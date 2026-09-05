package negocio;

import java.util.List;

import dao.DetallePedidoDao;
import datos.DetallePedido;
import datos.Plato;

public class DetallePedidoABM {

	DetallePedidoDao dao = new DetallePedidoDao();

	public DetallePedido traer(long idDetallePedido) {
		return dao.traer(idDetallePedido);
	}

	public int agregar(DetallePedido d) {
		if(d.getPedido()== null) {
			throw new UnsupportedOperationException("El pedido no existe");
		}else {
			if(d.getPlato()== null) {
				throw new UnsupportedOperationException("El plato no existe");
			}
		}
		return dao.agregar(d);
	}

	public void modificar(DetallePedido d) {
		if(dao.traer(d.getIdDetallePedido())== null) {
			throw new UnsupportedOperationException("El detalle no existe en la base");
		}
		dao.actualizar(d);
	}

	public void eliminar(long idDetallePedido) {
		if(dao.traer(idDetallePedido)== null) {
			throw new UnsupportedOperationException("El detalle no existe en la base");
		}
		DetallePedido d = dao.traer(idDetallePedido);
		dao.eliminar(d);
	}

	public List<DetallePedido> traer() {
		return dao.traer();
	}

	public List<DetallePedido> traer(Plato plato) {
		return dao.traer(plato);
	}
}
