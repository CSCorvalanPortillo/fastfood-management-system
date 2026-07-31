package fastFoodView;

import fastFoodModelos.Empleado;
import java.util.List;
import java.util.Scanner;

public class EmpleadoMenu {

    private Scanner teclado;

    public EmpleadoMenu() {
        teclado = new Scanner(System.in);
    }

    public void mostrarMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("     GESTION EMPLEADOS");
        System.out.println("==============================");
        System.out.println("1 - Registrar empleado");
        System.out.println("2 - Listar empleados");
        System.out.println("3 - Buscar empleado");
        System.out.println("4 - Modificar empleado");
        System.out.println("5 - Eliminar empleado");
        System.out.println("0 - Volver");

    }

    public int pedirOpcion() {

        System.out.print("Seleccione una opción: ");

        return teclado.nextInt();

    }

    public String pedirID() {

        System.out.print("Ingrese ID del empleado: ");

        return teclado.next();

    }

    public String pedirDNI() {

        System.out.print("Ingrese DNI: ");

        return teclado.next();

    }

    public String pedirNombre() {

        System.out.print("Ingrese nombre: ");

        return teclado.nextLine();

    }

    public String pedirApellido() {

        System.out.print("Ingrese apellido: ");

        return teclado.nextLine();

    }

    public String pedirUsuario() {

        System.out.print("Ingrese usuario: ");

        return teclado.nextLine();

    }

    public String pedirContraseña() {

        System.out.print("Ingrese contraseña: ");

        return teclado.nextLine();

    }

    public String pedirRol() {

        System.out.print("Ingrese rol (VENDEDOR/COCINERO): ");

        return teclado.next();

    }

    public String pedirIDBusqueda() {

        System.out.print("Ingrese ID del empleado: ");

        return teclado.next();

    }

    public String pedirDNIBusqueda() {

        System.out.print("Ingrese DNI del empleado: ");

        return teclado.next();

    }

    public String pedirIDModificar() {

        System.out.print("Ingrese ID del empleado a modificar: ");

        return teclado.next();

    }

    public String pedirIDEliminar() {

        System.out.print("Ingrese ID del empleado a eliminar: ");

        return teclado.next();

    }

    public void mostrarEmpleados(List<Empleado> empleados) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("     LISTADO DE EMPLEADOS");
        System.out.println("==============================");

        if (empleados.isEmpty()) {

            System.out.println("No hay empleados registrados.");

        } else {

            for (Empleado empleado : empleados) {

                System.out.println(empleado);
                System.out.println("------------------------------");

            }

        }

    }

    public void mostrarEmpleado(Empleado empleado) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("     DATOS DEL EMPLEADO");
        System.out.println("==============================");

        System.out.println(empleado);

    }

    public void limpiarBuffer() {

        teclado.nextLine();

    }
}
