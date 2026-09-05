package negocio;

import java.util.List;

import dao.PlatoDao;

import datos.Plato;

public class PlatoABM {

	PlatoDao dao = new PlatoDao();
	

	public Plato traer(long idPlato) {
		return dao.traer(idPlato);
	}

	public int agregar(Plato p) {
		if(p.getUnidadVenta()==null){
			throw new UnsupportedOperationException("La unidad de venta No existe");
			
		}
		return dao.agregar(p);
	}

	public void modificar(Plato p) {
		if(dao.traer(p.getIdPlato())== null) {
			throw new UnsupportedOperationException("El plato no existe");
		}
		dao.actualizar(p);
	}

	public void eliminar(long idPlato) {
		if(dao.traer(idPlato)== null) {
			throw new UnsupportedOperationException("El plato no existe");
		}
		Plato p = dao.traer(idPlato);
		dao.eliminar(p);
	}

	public List<Plato> traer() {
		return dao.traer();
	}
}
