package fastFoodControladores;

import fastFoodModelos.DetallePedido;
import fastFoodModelos.Pedido;
import fastFoodModelos.Producto;
import fastFoodService.DetallePedidoService;
import fastFoodService.EmpleadoService;
import fastFoodService.IngredienteService;
import fastFoodService.PedidoService;
import fastFoodService.ProductoService;
import fastFoodView.PedidoMenu;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fastFoodView.VendedorMenu;

public class VendedorControlador {

    private PedidoService pedidoService;
    private DetallePedidoService detallePedidoService;
    private ProductoService productoService;
    private IngredienteService ingredienteService;
    private EmpleadoService empleadoService;

    private PedidoMenu pedidoMenu;
    private VendedorMenu vendedorMenu;
    private String idEmpleadoLogueado;



public VendedorControlador(String idEmpleadoLogueado) {

    pedidoService = new PedidoService();
    detallePedidoService = new DetallePedidoService();
    productoService = new ProductoService();
    ingredienteService = new IngredienteService();
    empleadoService = new EmpleadoService();

    pedidoMenu = new PedidoMenu();
    vendedorMenu = new VendedorMenu();

    this.idEmpleadoLogueado = idEmpleadoLogueado;

}

    public void iniciarMenu() {

        int opcion;

        do {

            vendedorMenu.MostrarMenu();

            opcion = vendedorMenu.pedirOpcion();

            switch (opcion) {

                case 1:

                    registrarPedido();

                    break;

                case 2:

                    consultarPedidos();

                    break;

                case 0:

                    System.out.println("Cerrando sesión...");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }

    private void registrarPedido() {

        String idPedido;

        do {

            idPedido = pedidoMenu.pedirIDPedido();

            if (pedidoService.buscarPedido(idPedido) != null) {

                System.out.println("Ya existe un pedido con ese ID.");

            }

        } while (pedidoService.buscarPedido(idPedido) != null);


        Pedido pedido = new Pedido(
                idPedido,
                LocalDate.now(),
                idEmpleadoLogueado
        );

        List<DetallePedido> detalles = new ArrayList<>();

        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {

            Producto producto = null;

            do {

                String idProducto = pedidoMenu.pedirIDProducto();

                producto = productoService.buscarProducto(idProducto);

                if (producto == null) {

                    System.out.println("Producto inexistente. Ingrese otro.");

                }

            } while (producto == null);

            if (!producto.isDisponible()) {

                System.out.println("Ese producto aún no está disponible.");

            } else {

                int cantidad;

                do {

                    cantidad = pedidoMenu.pedirCantidad();

                    if (cantidad <= 0) {

                        System.out.println(
                                "La cantidad debe ser mayor a cero."
                        );

                    }

                } while (cantidad <= 0);

                detalles.add(
                        new DetallePedido(
                                idPedido,
                                producto.getID(),
                                cantidad,
                                producto.getPrecio()
                        )
                );

            }

            continuar = pedidoMenu.continuarProductos();

        }

        if (detalles.isEmpty()) {

            System.out.println("No se agregó ningún producto.");
            return;

        }

        pedidoService.registrarPedido(pedido);

        for (DetallePedido detalle : detalles) {

            detallePedidoService.registrarDetalle(detalle);

        }

        System.out.println("Pedido registrado correctamente.");

    }

    private void consultarPedidos() {

        List<Pedido> pedidos = pedidoService.listarPedidos();

        if (pedidos.isEmpty()) {

            System.out.println("No hay pedidos registrados.");
            return;

        }

        for (Pedido pedido : pedidos) {

            System.out.println("--------------------------------");

            System.out.println(pedido);

            double total = 0;

            List<DetallePedido> detalles
                    = detallePedidoService.buscarPorPedido(
                            pedido.getID());

            for (DetallePedido detalle : detalles) {

                Producto producto
                        = productoService.buscarProducto(
                                detalle.getIDProducto());

                System.out.println(
                        producto.getDescripcion()
                        + " x"
                        + detalle.getCantidad()
                        + " = $"
                        + detalle.calcularSubtotal()
                );

                total += detalle.calcularSubtotal();

            }

            System.out.println("TOTAL: $" + total);

        }

    }

}
