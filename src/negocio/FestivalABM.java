package negocio;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import dao.FestivalDao;
import datos.Desarmable;
import datos.Festival;
import datos.FoodTrack;
import datos.Plato;
import datos.Staff;
import datos.UnidadVenta;

public class FestivalABM {

	FestivalDao dao = new FestivalDao();

	public Festival traer(long idFestival) {
		return dao.traer(idFestival);
	}

	public int agregar(Festival f) {
		/*
		if(f.getFechaInicio().isBefore(LocalDate.now())) {
			throw new UnsupportedOperationException("La fecha ingresada es posterior a la actual. No es una maquina del tiempo mi loko :C");
		}else {
			if(f.getFechaFin().isBefore(f.getFechaInicio()) || f.getFechaFin().isBefore(LocalDate.now())) {
				throw new UnsupportedOperationException("La fiesta no puede acabar antes de comenzar");
			}
		}
		*/
		return dao.agregar(f);
	}

	public void modificar(Festival f) {
		if(dao.traer(f.getIdFestival())== null) {
			throw new UnsupportedOperationException("El Festival no existe en la base");
		}
		dao.actualizar(f);
	}

	public void eliminar(long idFestival) {
		if(dao.traer(idFestival)== null) {
			throw new UnsupportedOperationException("El Festival no existe en la base");
		}
		Festival f = dao.traer(idFestival);
		dao.eliminar(f);
	}

	public List<Festival> traer() {
		return dao.traer();
	}

	public Festival traerFestivalYUnidadesVenta(long idFestival) {
		if(dao.traer(idFestival)== null) {
			throw new UnsupportedOperationException("El Festival no existe en la base");
		}
		return dao.traerFestivalYUnidadesVenta(idFestival);
	}
	public List<Plato> traerPlatosDeFestival(long idFestival){
		if(dao.traer(idFestival)== null) {
			throw new UnsupportedOperationException("El Festival no existe en la base");
		}
		return dao.traerPlatosDeFestival(idFestival);
	}
	//Traer una lista de FoodTracks 
	public List<FoodTrack> traerFoodTrackFestival(long idFestival){
		Set<UnidadVenta> unidades = traerFestivalYUnidadesVenta(idFestival).getUnidadesVenta();
		List<FoodTrack> foodTracks = new ArrayList<>();
		for (UnidadVenta unidad : unidades) {
		    if (unidad instanceof FoodTrack) {
		        foodTracks.add((FoodTrack) unidad);
		    }
		}
		return foodTracks;
	}
	//Traer una lista de Desarmables
	public List<Desarmable> traerFoodDesarmableFestival(long idFestival){
		Set<UnidadVenta> unidades = traerFestivalYUnidadesVenta(idFestival).getUnidadesVenta();
		List<Desarmable> desarmables = new ArrayList<>();
		for (UnidadVenta unidad : unidades) {
		    if (unidad instanceof Desarmable) {
		        desarmables.add((Desarmable) unidad);
		    }
		}
		return desarmables;
	}
	// Pendiente a implementar
	public List<Staff> traerEncargadosFestival(long idFestival){
		if(dao.traer(idFestival)== null) {
			throw new UnsupportedOperationException("El Festival no existe en la base");
		}
		return dao.traerEncargadosFestival(idFestival);
	}
	public UnidadVenta traerPorPatenteFestival(long idFestival,String patente) {
		if(dao.traer(idFestival)== null) {
			throw new UnsupportedOperationException("El Festival no existe en la base");
		}
		if(dao.traerPorPatenteFestival(idFestival, patente)== null) {
			throw new UnsupportedOperationException("No esta registrada esa patente");
		}
		return dao.traerPorPatenteFestival(idFestival, patente);
	}
}
