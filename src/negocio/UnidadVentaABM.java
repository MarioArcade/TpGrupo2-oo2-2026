package negocio;

import java.util.List;

import dao.UnidadVentaDao;

import datos.UnidadVenta;

public class UnidadVentaABM {

	UnidadVentaDao dao = new UnidadVentaDao();

	public UnidadVenta traer(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}
	
	
	public int agregar(UnidadVenta u) {
		
		if(dao.traer(u.getCodigo())!=null){
			throw new UnsupportedOperationException("Esta unidad de venta  ya se encuentra cargada");
			
		}
		
		return dao.agregar(u);
	}

	public void modificar(UnidadVenta u) {
		if(dao.traer(u.getCodigo())==null){
			throw new UnsupportedOperationException("Esta unidad de venta No Existe");
		}
		dao.actualizar(u);
	}

	public void eliminar(String codigo) {
		if(dao.traer(codigo)==null){
			throw new UnsupportedOperationException("Esta unidad de venta No Existe");
		}
		UnidadVenta u = dao.traer(codigo);
		dao.eliminar(u);
	}

	public List<UnidadVenta> traer() {
		return dao.traer();
	}
}
