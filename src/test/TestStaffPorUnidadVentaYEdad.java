package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Staff;
import datos.UnidadVenta;
import negocio.StaffABM;
import negocio.UnidadVentaABM;

public class TestStaffPorUnidadVentaYEdad {

	public static void main(String[] args) {

		StaffABM abms = new StaffABM();
		UnidadVentaABM abmu = new UnidadVentaABM();
		//a
		// Cargas.java (Mariano) crea Cajeros/Cocineros pero nunca los asigna al "staff" de
		// ninguna UnidadVenta. Reutilizamos algunos de esos registros (por DNI) y los asignamos
		// acá a una unidad, para poder demostrar la consulta con datos reales.
		long idUnidadVenta = 1; // "Lo de carlitos" (Desarmable), cargada por Cargas.java

		UnidadVenta unidad = abmu.traer(idUnidadVenta);

		Set<Staff> staff = new HashSet<>();
		staff.add(abms.traer("3456789")); // Cajero martin gomez, 31 años
		staff.add(abms.traer("6789012")); // Cajero valentina lopez, 28 años
		staff.add(abms.traer("8901234")); // Cajero camila diaz, 29 años
		staff.add(abms.traer("35123698")); // Cocinero Sofía Martínez, 35 años
		staff.add(abms.traer("36984521")); // Cocinero Valentina Sánchez, 32 años
		staff.add(abms.traer("30124567")); // Cocinero Carlos Gómez, 41 años
		staff.add(abms.traer("29654178")); // Cocinero Federico Torres, 42 años

		unidad.setStaff(staff);
		abmu.modificar(unidad);

		// Caso de uso: Staff (Herencia: Cocinero/Cajero) de una UnidadVenta puntual
		// (Uno a Muchos), con edad mayor o igual a un mínimo dado por parámetro.
		int edadMinima = 30;
		List<Staff> resultado = abms.traerPorUnidadVentaYEdadMinima(idUnidadVenta, edadMinima);

		System.out.printf("Staff de '%s' con %d años o más:%n", unidad.getNombre(), edadMinima);
		for (Staff s : resultado) {
			System.out.println(s);
		}
	}
}
