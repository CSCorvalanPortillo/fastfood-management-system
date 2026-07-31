package fastFoodControladores;

import fastFoodModelos.DetallePedido;
import fastFoodModelos.EstadoPedido;
import fastFoodModelos.Pedido;
import fastFoodModelos.Producto;
import fastFoodService.DetallePedidoService;
import fastFoodService.PedidoService;
import fastFoodService.ProductoService;
import fastFoodView.CocineroMenu;
import java.util.List;

public class CocineroControlador {

    private PedidoService pedidoService;
    private CocineroMenu cocineroMenu;
    private DetallePedidoService detallePedidoService;
    private ProductoService productoService;

public CocineroControlador(){

    pedidoService = new PedidoService();
    detallePedidoService = new DetallePedidoService();
    productoService = new ProductoService();

    cocineroMenu = new CocineroMenu();

}

    public void iniciarMenu() {

        int opcion;

        do {

            cocineroMenu.MostrarMenu();

            opcion = cocineroMenu.pedirOpcion();

            switch (opcion) {

                case 1:

                    verPedidosPendientes();

                    break;

                case 2:

                    cambiarEstadoPedido();

                    break;

                case 0:

                    System.out.println("Cerrando sesión...");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }

private void verPedidosPendientes() {


    List<Pedido> pedidos =
            pedidoService.listarPendientes();


    if(pedidos.isEmpty()){

        System.out.println("No hay pedidos pendientes.");

        return;

    }



    for(Pedido pedido : pedidos){


        System.out.println();
        System.out.println("==================================");
        System.out.println("          PEDIDO " + pedido.getID());
        System.out.println("==================================");

        System.out.println(
                "Fecha: " + pedido.getFecha()
        );

        System.out.println(
                "Estado: " + pedido.getEstado()
        );


        System.out.println();
        System.out.println("Productos:");
        System.out.println("----------------------------------");


        double total = 0;



        List<DetallePedido> detalles =
                detallePedidoService.buscarPorPedido(
                        pedido.getID()
                );



        for(DetallePedido detalle : detalles){


            Producto producto =
                    productoService.buscarProducto(
                            detalle.getIDProducto()
                    );


            if(producto != null){


                double subtotal =
                        detalle.calcularSubtotal();


                System.out.println(
                        producto.getDescripcion()
                        + " x"
                        + detalle.getCantidad()
                        + "   $"
                        + subtotal
                );


                total += subtotal;


            }


        }



        System.out.println("----------------------------------");

        System.out.println(
                "TOTAL: $" + total
        );


    }


}
    private void cambiarEstadoPedido() {

        String id
                = cocineroMenu.pedirIDPedido();

        Pedido pedido
                = pedidoService.buscarPedido(id);

        if (pedido == null) {

            System.out.println("No existe el pedido.");

            return;

        }

        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {

            System.out.println("El pedido ya fue despachado.");

            return;

        }

        pedido.setEstado(EstadoPedido.DESPACHADO);

        pedidoService.modificarPedido(pedido);

        System.out.println(
                "Pedido despachado correctamente."
        );

    }

}
