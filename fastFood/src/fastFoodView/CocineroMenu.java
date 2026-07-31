package fastFoodView;

import java.util.Scanner;

public class CocineroMenu implements View {

    private Scanner teclado;


    public CocineroMenu() {

        teclado = new Scanner(System.in);

    }


    @Override
    public void MostrarMenu() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("        MENU COCINERO");
        System.out.println("==================================");
        System.out.println("1 - Ver pedidos pendientes");
        System.out.println("2 - Cambiar estado del pedido");
        System.out.println("0 - Cerrar sesión");

    }


    public int pedirOpcion() {

        System.out.print("Seleccione una opción: ");

        return teclado.nextInt();

    }


    public String pedirIDPedido() {

        System.out.print("Ingrese ID del pedido: ");

        return teclado.next();

    }

}