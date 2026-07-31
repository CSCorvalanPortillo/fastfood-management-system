package fastFoodView;

import fastFoodModelos.Ingrediente;
import java.util.List;
import java.util.Scanner;

public class IngredienteMenu {

    private Scanner teclado;


    public IngredienteMenu() {

        teclado = new Scanner(System.in);

    }


    public void mostrarMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("     GESTION INGREDIENTES");
        System.out.println("==============================");
        System.out.println("1 - Registrar ingrediente");
        System.out.println("2 - Listar ingredientes");
        System.out.println("3 - Buscar ingrediente");
        System.out.println("4 - Modificar ingrediente");
        System.out.println("5 - Eliminar ingrediente");
        System.out.println("0 - Volver");

    }


    public int pedirOpcion() {

        System.out.print("Seleccione una opción: ");

        return teclado.nextInt();

    }


    public String pedirID() {

        System.out.print("Ingrese ID del ingrediente: ");

        return teclado.next();

    }


    public String pedirDescripcion() {

        System.out.print("Ingrese descripción del ingrediente: ");

        teclado.nextLine();

        return teclado.nextLine();

    }


    public double pedirPrecio() {

        System.out.print("Ingrese precio del ingrediente: ");

        return teclado.nextDouble();

    }


    public String pedirIDBusqueda() {

        System.out.print("Ingrese ID del ingrediente a buscar: ");

        return teclado.next();

    }


    public String pedirIDModificar() {

        System.out.print("Ingrese ID del ingrediente a modificar: ");

        return teclado.next();

    }


    public String pedirIDEliminar() {

        System.out.print("Ingrese ID del ingrediente a eliminar: ");

        return teclado.next();

    }


    public void mostrarIngredientes(List<Ingrediente> ingredientes) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("    LISTA INGREDIENTES");
        System.out.println("==============================");


        for (Ingrediente ingrediente : ingredientes) {

            System.out.println(ingrediente);

        }

    }


    public void mostrarIngrediente(Ingrediente ingrediente) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("   DATOS DEL INGREDIENTE");
        System.out.println("==============================");

        System.out.println(ingrediente);

    }

}