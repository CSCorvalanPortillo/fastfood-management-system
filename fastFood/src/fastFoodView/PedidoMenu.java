package fastFoodView;

import fastFoodModelos.Pedido;
import java.util.List;
import java.util.Scanner;

public class PedidoMenu {

    private Scanner teclado;

    public PedidoMenu() {

        teclado = new Scanner(System.in);

    }

    /*public void mostrarMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("      GESTIÓN PEDIDOS");
        System.out.println("==============================");
        System.out.println("1 - Registrar pedido");
        System.out.println("2 - Listar pedidos");
        System.out.println("3 - Buscar pedido");
        System.out.println("4 - Ver pedidos pendientes");
        System.out.println("5 - Despachar pedido");
        System.out.println("0 - Volver");

    }*/

   /* public int pedirOpcion() {

        System.out.print("Seleccione una opción: ");
        return teclado.nextInt();

    }*/

    public String pedirIDPedido() {

        System.out.print("Ingrese ID del pedido: ");
        return teclado.next();

    }

    public String pedirIDEmpleado() {

        System.out.print("Ingrese ID del vendedor: ");
        return teclado.next();

    }

    public String pedirIDProducto() {

        System.out.print("Ingrese ID del producto: ");
        return teclado.next();

    }

    public int pedirCantidad() {

        System.out.print("Cantidad: ");
        return teclado.nextInt();

    }

    public String continuarProductos() {

        System.out.print("¿Agregar otro producto? (s/n): ");
        return teclado.next();

    }

    public void mostrarPedido(Pedido pedido) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("      DATOS DEL PEDIDO");
        System.out.println("==============================");
        System.out.println(pedido);

    }

    public void mostrarPedidos(List<Pedido> pedidos) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("         PEDIDOS");
        System.out.println("==============================");

        for (Pedido pedido : pedidos) {

            System.out.println(pedido);

        }

    }

    public String pedirIDBusqueda() {

        System.out.print("Ingrese ID del pedido: ");

        return teclado.next();

    }

    public String pedirIDDespachar() {

        System.out.print("Ingrese ID del pedido a despachar: ");

        return teclado.next();

    }
}
