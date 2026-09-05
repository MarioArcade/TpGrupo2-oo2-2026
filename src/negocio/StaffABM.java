package negocio;

import java.util.List;

import dao.StaffDao;
import datos.Staff;

public class StaffABM {

	StaffDao dao = new StaffDao();

	public Staff traer(long idStaff) {
		return dao.traer(idStaff);
	}

	public Staff traer(String dni) {
		return dao.traer(dni);
	}

	public int agregar(Staff s) {
		
		if(dao.traer(s.getDni())!=null){
			throw new UnsupportedOperationException("Dni cargado");
		}
		
		return dao.agregar(s);
	}

	public void modificar(Staff s) {
		if(dao.traer(s.getDni())==null){
			throw new UnsupportedOperationException("La Persona no Existe");
		}
		dao.actualizar(s);
	}

	public void eliminar(String dni) {
		if(dao.traer(dni)==null){
			throw new UnsupportedOperationException("La Persona no Existe");
		}
		Staff s = dao.traer(dni);
		dao.eliminar(s);
	}

	public List<Staff> traer() {
		return dao.traer();
	}

	public List<Staff> traerPorUnidadVentaYEdadMinima(long idUnidadVenta, int edadMinima) {
		return dao.traerPorUnidadVentaYEdadMinima(idUnidadVenta, edadMinima);
	}
}
