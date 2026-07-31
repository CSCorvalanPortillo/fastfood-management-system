package fastFoodView;

import java.util.Scanner;

public class VendedorMenu implements View {

    private Scanner teclado;

    public VendedorMenu() {

        teclado = new Scanner(System.in);

    }

    @Override
    public void MostrarMenu() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("        MENU VENDEDOR");
        System.out.println("==================================");
        System.out.println("1 - Crear pedido");
        System.out.println("2 - Consultar pedidos");
        System.out.println("0 - Cerrar sesión");

    }

    public int pedirOpcion() {

        System.out.print("Seleccione una opción: ");

        return teclado.nextInt();

    }

}