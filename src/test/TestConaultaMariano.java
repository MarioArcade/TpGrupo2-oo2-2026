package test;

import negocio.DetallePedidoABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.StaffABM;
import negocio.UnidadVentaABM;

public class TestConaultaMariano {

	public static void main(String[] args) {
		FestivalABM abmf = new FestivalABM();
		StaffABM abms = new StaffABM();
		UnidadVentaABM abmu = new UnidadVentaABM();
		PlatoABM abmp = new PlatoABM();
		PedidoABM abmpe= new PedidoABM();
		DetallePedidoABM abmdp = new DetallePedidoABM();
		
		// traer todos los platos vendidos en el festival consulta muchos a muchos
		System.out.print(abmf.traerPlatosDeFestival(5));
		// Traer una lista de foodTracks consutla con herencia 
		System.out.println(abmf.traerFoodTrackFestival(5));
		// Traer una listra de Desarmables consutla con herencia 
		System.out.println(abmf.traerFoodDesarmableFestival(5));
		//Traer a los encargados del festival pendiente a implementar
		//System.out.println(abmf.traerEncargadosFestival(5));
		//Traer una FoodTrack pro patente de un festival consuta con herencia 
		System.out.println(abmf.traerPorPatenteFestival(5, "AA123BC"));
	}

}
