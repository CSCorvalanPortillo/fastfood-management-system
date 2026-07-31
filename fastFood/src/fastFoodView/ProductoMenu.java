package fastFoodView;

import fastFoodModelos.Producto;
import java.util.List;
import java.util.Scanner;

public class ProductoMenu {

    private Scanner teclado;

    public ProductoMenu() {

        teclado = new Scanner(System.in);

    }

    public void mostrarMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("     GESTION PRODUCTOS");
        System.out.println("==============================");
        System.out.println("1 - Registrar producto");
        System.out.println("2 - Listar productos");
        System.out.println("3 - Buscar producto");
        System.out.println("4 - Modificar producto");
        System.out.println("5 - Eliminar producto");
        System.out.println("------------------------------");
        System.out.println("6 - Agregar ingrediente a un producto");
        System.out.println("7 - Quitar ingrediente a un producto");
        System.out.println("8 - Ver ingredientes de un producto");
        System.out.println("------------------------------");
        System.out.println("0 - Volver");

    }

    public int pedirOpcion() {

        System.out.print("Seleccione una opción: ");

        return teclado.nextInt();

    }

    public String pedirID() {

        System.out.print("Ingrese ID del producto: ");

        return teclado.next();

    }

    public String pedirDescripcion() {

        System.out.print("Ingrese descripción del producto: ");

        teclado.nextLine();

        return teclado.nextLine();

    }

    public double pedirPrecio() {

        System.out.print("Ingrese precio del producto: ");

        return teclado.nextDouble();

    }

    public void mostrarProductos(List<Producto> productos) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("       LISTA PRODUCTOS");
        System.out.println("==============================");

        for (Producto producto : productos) {

            System.out.println(producto);

        }

    }

    public void mostrarProducto(Producto producto) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("      DATOS DEL PRODUCTO");
        System.out.println("==============================");

        System.out.println(producto);

    }

    public String pedirIDBusqueda() {

        System.out.print("Ingrese ID del producto a buscar: ");

        return teclado.next();

    }

    public String pedirIDModificar() {

        System.out.print("Ingrese ID del producto a modificar: ");

        return teclado.next();

    }

    public String pedirIDEliminar() {

        System.out.print("Ingrese ID del producto a eliminar: ");

        return teclado.next();

    }

    public String pedirIDProducto() {

        System.out.print("Ingrese ID del producto: ");

        return teclado.next();

    }

    public String pedirIDIngrediente() {

        System.out.print("Ingrese ID del ingrediente: ");

        return teclado.next();

    }

    public boolean pedirObligatorio() {

        System.out.print("¿El ingrediente es obligatorio? (s/n): ");

        String respuesta = teclado.next();

        return respuesta.equalsIgnoreCase("s");

    }

    public String preguntarAgregarIngredientes() {

        System.out.print("¿Desea agregar ingredientes ahora? (s/n): ");

        return teclado.next();

    }

    public String continuarAgregandoIngredientes() {

        System.out.print("¿Desea agregar otro ingrediente? (s/n): ");

        return teclado.next();

    }

}
