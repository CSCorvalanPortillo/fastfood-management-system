package fastFoodView;

import java.util.Scanner;

public class GerenteMenu implements View {

    private Scanner teclado;


    public GerenteMenu() {

        teclado = new Scanner(System.in);

    }


    @Override
    public void MostrarMenu() {

        System.out.println();
        System.out.println("==================================");
        System.out.println("          MENU GERENTE");
        System.out.println("==================================");
        System.out.println("1 - Gestionar empleados");
        System.out.println("2 - Gestionar productos");
        System.out.println("3 - Gestionar ingredientes");
        System.out.println("4 - Ver reportes");
        System.out.println("0 - Cerrar sesion");

    }


    public int pedirOpcion() {

        System.out.print("Seleccione una opcion: ");

        return teclado.nextInt();

    }

}