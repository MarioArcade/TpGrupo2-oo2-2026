package test;
import java.time.LocalDate;
import datos.Festival;
import negocio.FestivalABM;
import datos.Cajero;
import datos.Cocinero;
import datos.Desarmable;
import negocio.StaffABM;
import datos.FoodTrack;
import negocio.UnidadVentaABM;
import negocio.PlatoABM;
import datos.Plato;
import datos.Pedido;
import negocio.PedidoABM;
import negocio.DetallePedidoABM;
import datos.DetallePedido;
public class Cargas {

	public static void main(String[] args) {
		
		// =========================================================================
		// 1. INICIALIZACIÓN DE OBJETOS DE CAPA DE NEGOCIO (ABM / CONTROLADORES)
		// Son los encargados de guardar (agregar) y consultar (traer) datos en la BD.
		// =========================================================================
		FestivalABM abmf = new FestivalABM();          // ABM para gestionar Festivales
		StaffABM abms = new StaffABM();                // ABM para gestionar el Staff (Cajeros y Cocineros)
		UnidadVentaABM abmu = new UnidadVentaABM();    // ABM para gestionar Unidades de Venta (FoodTrucks y Desarmables)
		PlatoABM abmp = new PlatoABM();                // ABM para gestionar Platos del menú
		PedidoABM abmpe = new PedidoABM();              // ABM para gestionar Pedidos realizadoss
		DetallePedidoABM abmdp = new DetallePedidoABM(); // ABM para gestionar los ítems/detalles de los Pedidos


		// =========================================================================
		// 2. CREACIÓN Y GUARDADO DE FESTIVALES
		// Instancia objetos 'Festival' (f1 a f10) y los persiste en la BD usando 'abmf'.
		// =========================================================================
		Festival f1 = new Festival("Inicio de otoño","Otoño",LocalDate.of(2026, 03, 10),LocalDate.of(2026, 03, 16));
		Festival f2 = new Festival("Revolucion Fest","Otoño",LocalDate.of(2026, 05, 23),LocalDate.of(2026, 05, 28));
		Festival f3 = new Festival("Solsticio de invierno","Invierno",LocalDate.of(2026, 07, 10),LocalDate.of(2026, 07, 16));
		Festival f4 = new Festival("Vacaciones de invierno","Invierno",LocalDate.of(2026, 07, 20),LocalDate.of(2026, 07, 30));
		Festival f5 = new Festival("Dia de la Primavera","Primavera",LocalDate.of(2026, 9 ,21),LocalDate.of(2026, 9, 30));
		Festival f6 = new Festival("Musica folklorica","Primavera",LocalDate.of(2026, 10, 10),LocalDate.of(2026, 10, 15));
		Festival f7 = new Festival("Sabores autoctonos","Verano",LocalDate.of(2026, 11, 10),LocalDate.of(2026, 11, 17));
		Festival f8 = new Festival("Vacaciones","Verano",LocalDate.of(2026, 12, 10),LocalDate.of(2026, 12, 28));
		Festival f9 = new Festival("Año nuevo","Verano",LocalDate.of(2027, 01, 05),LocalDate.of(2026, 01, 15));
		Festival f10 = new Festival("Marzo fest","Verano",LocalDate.of(2026, 03, 8),LocalDate.of(2026, 03, 18));

		// Se guardan los festivales en la base de datos a través de abmf (ABM Festival)
		abmf.agregar(f1);
		abmf.agregar(f2);
		abmf.agregar(f3);
		abmf.agregar(f4);
		abmf.agregar(f5);
		abmf.agregar(f6);
		abmf.agregar(f7);
		abmf.agregar(f8);
		abmf.agregar(f9);
		abmf.agregar(f10);


		// =========================================================================
		// 3. CREACIÓN Y GUARDADO DE INTEGRANTES DEL STAFF: CAJEROS
		// Instancia empleados tipo 'Cajero' (c1 a c9) y los guarda con 'abms'.
		// =========================================================================
		Cajero c1 = new Cajero("Hernan", "fernandez", "4667892" ,LocalDate.of(1990, 5, 15), LocalDate.of(2020, 8, 30), 900000, "tarde", 1);
		Cajero c2 = new Cajero("lucia", "fernandez", "2345678", LocalDate.of(1988, 11, 22), LocalDate.of(2019, 3, 10), 850000, "mañana", 2);
		Cajero c3 = new Cajero("martin", "gomez", "3456789", LocalDate.of(1995, 2, 8), LocalDate.of(2021, 6, 15), 920000, "noche", 3);
		Cajero c4 = new Cajero("sofia", "rodriguez", "4567890", LocalDate.of(1992, 7, 30), LocalDate.of(2022, 1, 20), 880000, "tarde", 4);
		Cajero c5 = new Cajero("juan", "martinez", "5678901", LocalDate.of(1985, 9, 12), LocalDate.of(2018, 11, 5), 980000, "mañana", 5);
		Cajero c6 = new Cajero("valentina", "lopez", "6789012", LocalDate.of(1998, 4, 25), LocalDate.of(2023, 7, 1), 820000, "tarde", 6);
		Cajero c7 = new Cajero("facundo", "sanchez", "7890123", LocalDate.of(1991, 12, 3), LocalDate.of(2020, 2, 17), 950000, "noche", 7);
		Cajero c8 = new Cajero("camila", "diaz", "8901234", LocalDate.of(1997, 6, 18), LocalDate.of(2024, 4, 8), 800000, "mañana", 8);
		Cajero c9 = new Cajero("agustin", "pereyra", "9012345", LocalDate.of(1989, 10, 27), LocalDate.of(2021, 9, 13), 930000, "noche", 9);

		// Se guardan los cajeros en la base de datos usando abms (ABM Staff)
		abms.agregar(c1);
		abms.agregar(c2);
		abms.agregar(c3);
		abms.agregar(c4);
		abms.agregar(c5);
		abms.agregar(c6);
		abms.agregar(c7);
		abms.agregar(c8);
		abms.agregar(c9);


		// =========================================================================
		// 4. CREACIÓN Y GUARDADO DE INTEGRANTES DEL STAFF: COCINEROS
		// Instancia empleados tipo 'Cocinero' (co1 a co10) y los guarda con 'abms'.
		// =========================================================================
		Cocinero co1 = new Cocinero("Carlos", "Gómez", "30124567", LocalDate.of(1985, 3, 15), LocalDate.of(2018, 5, 10), 850000, "Pastas", "Chef Profesional", 80000);
		Cocinero co2 = new Cocinero("María", "Fernández", "32256891", LocalDate.of(1988, 7, 22), LocalDate.of(2020, 2, 3), 780000, "Repostería", "Pastelería Profesional", 60000);
		Cocinero co3 = new Cocinero("Julián", "Rodríguez", "28987453", LocalDate.of(1982, 11, 8), LocalDate.of(2015, 9, 17), 920000, "Carnes", "Chef Profesional", 100000);
		Cocinero co4 = new Cocinero("Sofía", "Martínez", "35123698", LocalDate.of(1991, 1, 30), LocalDate.of(2021, 6, 14), 750000, "Cocina Italiana", "Gastronomía Internacional", 55000);
		Cocinero co5 = new Cocinero("Diego", "López", "27456832", LocalDate.of(1979, 9, 12), LocalDate.of(2012, 3, 5), 980000, "Parrilla", "Especialista en Parrilla", 120000);
		Cocinero co6 = new Cocinero("Valentina", "Sánchez", "36984521", LocalDate.of(1994, 5, 19), LocalDate.of(2022, 8, 1), 720000, "Cocina Vegana", "Cocina Saludable", 50000);
		Cocinero co7 = new Cocinero("Martín", "Díaz", "31254789", LocalDate.of(1986, 12, 3), LocalDate.of(2017, 4, 20), 870000, "Pescados y Mariscos", "Chef Profesional", 75000);
		Cocinero co8 = new Cocinero("Lucía", "Romero", "33478912", LocalDate.of(1990, 6, 27), LocalDate.of(2019, 10, 7), 810000, "Cocina Mexicana", "Gastronomía Internacional", 65000);
		Cocinero co9 = new Cocinero("Federico", "Torres", "29654178", LocalDate.of(1984, 2, 14), LocalDate.of(2016, 11, 11), 900000, "Sushi", "Especialista en Cocina Japonesa", 95000);
		Cocinero co10 = new Cocinero("Camila", "Vega", "37891245", LocalDate.of(1996, 10, 5), LocalDate.of(2023, 1, 16), 700000, "Comida Rápida", null, 0);

		// Se guardan los cocineros en la base de datos usando abms (ABM Staff)
		abms.agregar(co1);
		abms.agregar(co2);
		abms.agregar(co3);
		abms.agregar(co4);
		abms.agregar(co5);
		abms.agregar(co6);
		abms.agregar(co7);
		abms.agregar(co8);
		abms.agregar(co9);
		abms.agregar(co10);


		// =========================================================================
		// 5. CREACIÓN Y GUARDADO DE UNIDADES DE VENTA TIPO 'FOODTRACK'
		// Nota: Para vincular los FoodTracks, consulta en tiempo real:
		// - abms.traer(id): Trae el miembro de Staff de la BD por su ID.
		// - abmf.traer(5): Trae el Festival de la BD por su ID (Festival ID=5: "Dia de la Primavera").
		// =========================================================================
		FoodTrack ft0 = new FoodTrack("El gordo mario", "d1", 200, abms.traer(1), abmf.traer(5),"aeh133");
		FoodTrack ft1 = new FoodTrack("La Pasta Loca", "A1", 12, abms.traer(2), abmf.traer(5), "AA123BC");
		FoodTrack ft2 = new FoodTrack("Burger House", "A2", 15, abms.traer(2), abmf.traer(5), "AB456DE");
		FoodTrack ft3 = new FoodTrack("Pizza Express", "A3", 10, abms.traer(4), abmf.traer(5), "AC789FG");
		FoodTrack ft4 = new FoodTrack("El Buen Taco", "B1", 14, abms.traer(5), abmf.traer(5), "AD321HI");
		FoodTrack ft5 = new FoodTrack("Sabores del Sur", "B2", 18, abms.traer(6), abmf.traer(5), "AE654JK");
		FoodTrack ft6 = new FoodTrack("Dulce Tentación", "B3", 9, abms.traer(7), abmf.traer(5), "AF987LM");
		FoodTrack ft7 = new FoodTrack("Parrilla Móvil", "C1", 20, abms.traer(8), abmf.traer(5), "AG147NP");
		FoodTrack ft8 = new FoodTrack("Sushi Time", "C2", 11, abms.traer(9), abmf.traer(5), "AH258QR");
		FoodTrack ft9 = new FoodTrack("Rincón Vegano", "C3", 13, abms.traer(10), abmf.traer(5), "AI369ST");
		FoodTrack ft10 = new FoodTrack("Café Rodante", "D1", 8, abms.traer(11), abmf.traer(5), "AJ741UV");

		// Se guardan los FoodTracks usando abmu (ABM UnidadVenta)
		abmu.agregar(ft0);
		abmu.agregar(ft1);
		abmu.agregar(ft2);
		abmu.agregar(ft3);
		abmu.agregar(ft4);
		abmu.agregar(ft5);
		abmu.agregar(ft6);
		abmu.agregar(ft7);
		abmu.agregar(ft8);
		abmu.agregar(ft9);
		abmu.agregar(ft10);


		// =========================================================================
		// 6. CREACIÓN Y GUARDADO DE UNIDADES DE VENTA TIPO 'DESARMABLE'
		// Similar a los FoodTracks, pero son puestos desarmables (d1 a d10).
		// También consulta staff con 'abms.traer()' y festival con 'abmf.traer(5)'.
		// =========================================================================
		Desarmable d1 = new Desarmable("Puesto de Empanadas", "A1", 8, abms.traer(1), abmf.traer(5), 1, 20);
		Desarmable d2 = new Desarmable("Puesto de Choripanes", "A2", 10, abms.traer(2), abmf.traer(5), 1, 25);
		Desarmable d3 = new Desarmable("Puesto de Hamburguesas", "A3", 12, abms.traer(3), abmf.traer(5), 2, 35);
		Desarmable d4 = new Desarmable("Puesto de Pizzas", "B1", 9, abms.traer(4), abmf.traer(5), 1, 30);
		Desarmable d5 = new Desarmable("Puesto de Pastas", "B2", 14, abms.traer(5), abmf.traer(5), 2, 40);
		Desarmable d6 = new Desarmable("Puesto de Tacos", "B3", 11, abms.traer(6), abmf.traer(5), 1, 25);
		Desarmable d7 = new Desarmable("Puesto de Parrilla", "C1", 16, abms.traer(7), abmf.traer(5), 2, 45);
		Desarmable d8 = new Desarmable("Puesto de Sushi", "C2", 10, abms.traer(8), abmf.traer(5), 1, 35);
		Desarmable d9 = new Desarmable("Puesto Vegano", "C3", 13, abms.traer(9), abmf.traer(5), 2, 40);
		Desarmable d10 = new Desarmable("Puesto de Postres", "D1", 7, abms.traer(10), abmf.traer(5), 1, 20);

		// Se guardan los puestos desarmables usando abmu (ABM UnidadVenta)
		abmu.agregar(d1);
		abmu.agregar(d2);
		abmu.agregar(d3);
		abmu.agregar(d4);
		abmu.agregar(d5);
		abmu.agregar(d6);
		abmu.agregar(d7);
		abmu.agregar(d8);
		abmu.agregar(d9);
		abmu.agregar(d10);


		// =========================================================================
		// 7. CREACIÓN Y GUARDADO DE PLATOS (MENÚ)
		// Cada plato (p0 a p10) se asocia a una UnidadVenta (FoodTrack/Desarmable)
		// obtenida de la BD mediante abmu.traer(1).
		// =========================================================================
		Plato p0 = new Plato("Pizza mozzarella", 20000, 5000, abmu.traer(1));
		Plato p1 = new Plato("Ravioles con Salsa", 8500, 3200, abmu.traer(1));
		Plato p2 = new Plato("Hamburguesa Completa", 9500, 3800, abmu.traer(1));
		Plato p3 = new Plato("Pizza Muzzarella", 9000, 3500, abmu.traer(1));
		Plato p4 = new Plato("Empanadas de Carne", 6500, 2500, abmu.traer(1));
		Plato p5 = new Plato("Pollo al Horno con Papas", 11000, 4500, abmu.traer(1));
		Plato p6 = new Plato("Tacos de Carne", 8000, 3000, abmu.traer(1));
		Plato p7 = new Plato("Sushi Variado", 12500, 5500, abmu.traer(1));
		Plato p8 = new Plato("Choripán Completo", 7000, 2800, abmu.traer(1));
		Plato p9 = new Plato("Ensalada César", 7500, 2700, abmu.traer(1));
		Plato p10 = new Plato("Brownie con Helado", 6000, 2200, abmu.traer(1));

		// Se guardan los platos usando abmp (ABM Plato)
		abmp.agregar(p0);
		abmp.agregar(p1);
		abmp.agregar(p2);
		abmp.agregar(p3);
		abmp.agregar(p4);
		abmp.agregar(p5);
		abmp.agregar(p6);
		abmp.agregar(p7);
		abmp.agregar(p8);
		abmp.agregar(p9);
		abmp.agregar(p10);


		// =========================================================================
		// 8. CREACIÓN Y GUARDADO DE PEDIDOS (CABECERAS)
		// Se crean pedidos vacíos (nP1 a nP10) asociando la UnidadVenta ID=1 (abmu.traer(1)) 
		// y el Festival ID=1 (abmf.traer(1)) en una fecha determinada.
		// =========================================================================
		Pedido nP1 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP2 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP3 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP4 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP5 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP6 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP7 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP8 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP9 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));
		Pedido nP10 = new Pedido(abmu.traer(1), abmf.traer(1), LocalDate.of(2026, 9 ,21));

		// Se guardan los pedidos base en la BD con abmpe (ABM Pedido)
		abmpe.agregar(nP1);
		abmpe.agregar(nP2);
		abmpe.agregar(nP3);
		abmpe.agregar(nP4);
		abmpe.agregar(nP5);
		abmpe.agregar(nP6);
		abmpe.agregar(nP7);
		abmpe.agregar(nP8);
		abmpe.agregar(nP9);
		abmpe.agregar(nP10);


		// =========================================================================
		// 9. CREACIÓN Y GUARDADO DE LOS DETALLES DEL PEDIDO (LÍNEAS DE PEDIDO)
		// Cada DetallePedido conecta:
		// - Un Pedido guardado: abmpe.traer(idPedido)
		// - Un Plato guardado: abmp.traer(idPlato)
		// - La cantidad comprada de ese plato (número final)
		// =========================================================================
		DetallePedido dp1 = new DetallePedido(abmpe.traer(1), abmp.traer(1), 3);   // Pedido 1 lleva 3 del Plato 1
		DetallePedido dp2 = new DetallePedido(abmpe.traer(1), abmp.traer(4), 2);   // Pedido 1 lleva 2 del Plato 4
		DetallePedido dp3 = new DetallePedido(abmpe.traer(1), abmp.traer(7), 1);   // Pedido 1 lleva 1 del Plato 7
		DetallePedido dp4 = new DetallePedido(abmpe.traer(2), abmp.traer(2), 4);   // Pedido 2 lleva 4 del Plato 2
		DetallePedido dp5 = new DetallePedido(abmpe.traer(2), abmp.traer(8), 2);   // Pedido 2 lleva 2 del Plato 8
		DetallePedido dp6 = new DetallePedido(abmpe.traer(3), abmp.traer(3), 5);   // ...
		DetallePedido dp7 = new DetallePedido(abmpe.traer(3), abmp.traer(6), 2);
		DetallePedido dp8 = new DetallePedido(abmpe.traer(3), abmp.traer(10), 1);
		DetallePedido dp9 = new DetallePedido(abmpe.traer(4), abmp.traer(1), 4);
		DetallePedido dp10 = new DetallePedido(abmpe.traer(4), abmp.traer(5), 3);
		DetallePedido dp11 = new DetallePedido(abmpe.traer(5), abmp.traer(4), 2);
		DetallePedido dp12 = new DetallePedido(abmpe.traer(5), abmp.traer(9), 6);
		DetallePedido dp13 = new DetallePedido(abmpe.traer(6), abmp.traer(2), 3);
		DetallePedido dp14 = new DetallePedido(abmpe.traer(6), abmp.traer(7), 1);
		DetallePedido dp15 = new DetallePedido(abmpe.traer(7), abmp.traer(3), 5);
		DetallePedido dp16 = new DetallePedido(abmpe.traer(7), abmp.traer(8), 2);
		DetallePedido dp17 = new DetallePedido(abmpe.traer(8), abmp.traer(6), 4);
		DetallePedido dp18 = new DetallePedido(abmpe.traer(9), abmp.traer(10), 3);
		DetallePedido dp19 = new DetallePedido(abmpe.traer(10), abmp.traer(5), 6);
		DetallePedido dp20 = new DetallePedido(abmpe.traer(10), abmp.traer(9), 2);

		// Se guardan los detalles usando abmdp (ABM DetallePedido)
		abmdp.agregar(dp1);
		abmdp.agregar(dp2);
		abmdp.agregar(dp3);
		abmdp.agregar(dp4);
		abmdp.agregar(dp5);
		abmdp.agregar(dp6);
		abmdp.agregar(dp7);
		abmdp.agregar(dp8);
		abmdp.agregar(dp9);
		abmdp.agregar(dp10);
		abmdp.agregar(dp11);
		abmdp.agregar(dp12);
		abmdp.agregar(dp13);
		abmdp.agregar(dp14);
		abmdp.agregar(dp15);
		abmdp.agregar(dp16);
		abmdp.agregar(dp17);
		abmdp.agregar(dp18);
		abmdp.agregar(dp19);
		abmdp.agregar(dp20);
		
	
	}
	
}
