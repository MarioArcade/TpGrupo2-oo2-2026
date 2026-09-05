package test;

import java.time.LocalDate;
import datos.Festival;
import datos.UnidadVenta;
import datos.Plato;
import datos.Pedido;
import datos.DetallePedido;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;
import negocio.PlatoABM;
import negocio.PedidoABM;
import negocio.DetallePedidoABM;

public class TestCargaDePedidosFoodTrackParaTestDerecaudacionPorFecha {

    public static void main(String[] args) {
        // 1. Inicialización de capas ABM
        UnidadVentaABM unidadAbm = new UnidadVentaABM();
        FestivalABM festivalAbm = new FestivalABM();
        PedidoABM pedidoAbm = new PedidoABM();
        DetallePedidoABM detallePedidoAbm = new DetallePedidoABM();
        PlatoABM platoAbm = new PlatoABM();

        // 2. Traer entidades existentes de la BD
        Festival festivalPaso = festivalAbm.traer(1);
        UnidadVenta unidadEjemplo = unidadAbm.traer(1);

        Plato platoPizza = platoAbm.traer(1);
        Plato platoEmpanada = platoAbm.traer(2); // Asumiendo que existen más platos
        Plato platoBebida = platoAbm.traer(3);

        // =========================================================================
        // PEDIDO 1 (01/09/2026) - Tu pedido original
        // =========================================================================
        //Pedido pedido1 = new Pedido(unidadEjemplo, festivalPaso, LocalDate.of(2026, 9, 1));
        //pedidoAbm.agregar(pedido1);

        //DetallePedido detallePedido1 = new DetallePedido(pedido1, platoPizza, 7);
       // detallePedidoAbm.agregar(detallePedido1);

        // =========================================================================
        // PEDIDO 2 (02/09/2026) - 2 ítems distintos
        // =========================================================================
        Pedido pedido2 = new Pedido(unidadEjemplo, festivalPaso, LocalDate.of(2026, 9, 2));
        pedidoAbm.agregar(pedido2);

        DetallePedido detallePedido2_1 = new DetallePedido(pedido2, platoPizza, 2);
        DetallePedido detallePedido2_2 = new DetallePedido(pedido2, platoEmpanada, 5);
        detallePedidoAbm.agregar(detallePedido2_1);
        detallePedidoAbm.agregar(detallePedido2_2);

        // =========================================================================
        // PEDIDO 3 (03/09/2026)
        // =========================================================================
        Pedido pedido3 = new Pedido(unidadEjemplo, festivalPaso, LocalDate.of(2026, 9, 3));
        pedidoAbm.agregar(pedido3);

        DetallePedido detallePedido3 = new DetallePedido(pedido3, platoEmpanada, 12);
        detallePedidoAbm.agregar(detallePedido3);

        // =========================================================================
        // PEDIDO 4 (04/09/2026)
        // =========================================================================
        Pedido pedido4 = new Pedido(unidadEjemplo, festivalPaso, LocalDate.of(2026, 9, 4));
        pedidoAbm.agregar(pedido4);

        DetallePedido detallePedido4 = new DetallePedido(pedido4, platoBebida, 4);
        detallePedidoAbm.agregar(detallePedido4);

        // =========================================================================
        // PEDIDO 5 (05/09/2026) - 2 ítems distintos
        // =========================================================================
        Pedido pedido5 = new Pedido(unidadEjemplo, festivalPaso, LocalDate.of(2026, 9, 5));
        pedidoAbm.agregar(pedido5);

        DetallePedido detallePedido5_1 = new DetallePedido(pedido5, platoPizza, 3);
        DetallePedido detallePedido5_2 = new DetallePedido(pedido5, platoBebida, 3);
        detallePedidoAbm.agregar(detallePedido5_1);
        detallePedidoAbm.agregar(detallePedido5_2);

        System.out.println(">>> Carga de 5 pedidos (01/09 al 05/09) realizada con éxito.");
    }
}