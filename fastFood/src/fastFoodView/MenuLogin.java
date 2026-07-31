package fastFoodView;

import java.util.Scanner;

public class MenuLogin implements View {

    private Scanner teclado;

    public MenuLogin() {
        teclado = new Scanner(System.in);
    }

    @Override
    public void MostrarMenu() {

        System.out.println("==================================");
        System.out.println("      FAST FOOD - LOGIN");
        System.out.println("==================================");

    }

    public String pedirUsuario() {

        System.out.print("Usuario: ");
        return teclado.nextLine();

    }

    public String pedirContraseña() {

        System.out.print("Contraseña: ");
        return teclado.nextLine();

    }

    public void mostrarLoginIncorrecto() {

        System.out.println("\nUsuario o contraseña incorrectos.\n");

    }

    public void mostrarBienvenida(String nombre) {

        System.out.println("\nBienvenido " + nombre + ".\n");

    }

}