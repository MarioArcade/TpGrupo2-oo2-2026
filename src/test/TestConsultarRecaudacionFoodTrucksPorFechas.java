package test;

import java.time.LocalDate;
import java.util.List;
import dao.PedidoDao;
import datos.Pedido;
import negocio.PedidoABM;

public class TestConsultarRecaudacionFoodTrucksPorFechas {

    public static void main(String[] args) {
    	    // =========================================================================
    	    // 1. INICIALIZACIÓN DE OBJETOS DE CAPA DE NEGOCIO Y ACCESO A DATOS
    	    // =========================================================================
    	    PedidoABM pedidoABM = new PedidoABM(); // Capa de Negocio: Contiene la lógica para calcular la recaudación
    	    PedidoDao pedidoDao = new PedidoDao(); // Capa DAO: Se comunica con la BD via Hibernate para traer datos

    	    // =========================================================================
    	    // 2. DEFINICIÓN DEL FILTRO DE BUSQUEDA (RANGO DE FECHAS)
    	    // Se establece el periodo desde el 01/01/2026 hasta el 31/12/2026.
    	    // =========================================================================
    	    LocalDate desde = LocalDate.of(2026, 9, 1);
    	    LocalDate hasta = LocalDate.of(2026, 9, 5);

    	    System.out.println("=== CONSULTA DE PEDIDOS EN FOOD TRUCKS POR RANGO DE FECHAS ===");
    	    
    	    // =========================================================================
    	    // 3. CONSULTA DE PEDIDOS A LA BASE DE DATOS
    	    // 'pedidoDao.traerPedidosFoodTrucksPorFechas' ejecuta la consulta HQL que:
    	    //  - Filtra pedidos por el rango de fechas.
    	    //  - Se asegura de que la UnidadVenta sea del tipo FoodTrack (excluyendo Desarmables).
    	    //  - Utiliza "join fetch" para traer en memoria la Unidad, los Detalles y el Plato.
    	    // =========================================================================
    	    List<Pedido> pedidos = pedidoDao.traerPedidosFoodTrucksPorFechas(desde, hasta);

    	    // =========================================================================
    	    // 4. IMPRESIÓN Y RECORRIDO DE LA LISTA DE PEDIDOS
    	    // Muestra por consola el detalle resumido de cada pedido devuelto.
    	    // =========================================================================
    	    for (Pedido p : pedidos) {
    	        System.out.println("Pedido ID: " + p.getIdPedido() + 
    	                           " | Fecha: " + p.getFechaTransaccion() + 
    	                           " | Unidad: " + p.getUnidadVentaEntrega().getNombre());
    	    }

    	    // =========================================================================
    	    // 5. CÁLCULO DE LA RECAUDACIÓN TOTAL (LÓGICA DE NEGOCIO)
    	    // 'pedidoABM.calcularRecaudacionFoodTrucksPorFechas' realiza lo siguiente:
    	    //  a) Llama a 'pedidoDao' para obtener la lista de pedidos.
    	    //  b) Recorre cada Pedido e invoca 'p.precioTotalPedido()'.
    	    //  c) Suma el precio total de todos los pedidos y retorna la recaudación.
    	    // =========================================================================
    	    double recaudacionTotal = pedidoABM.calcularRecaudacionFoodTrucksPorFechas(desde, hasta);
    	    
    	    // =========================================================================
    	    // 6. MUESTRA DEL RESULTADO FINAL
    	    // =========================================================================
    	    System.out.println("\n---------------------------------------------------------");
    	    System.out.println("RECAUDACIÓN TOTAL DE FOOD TRUCKS: $" + recaudacionTotal);
    	    System.out.println("---------------------------------------------------------");
    	}
}