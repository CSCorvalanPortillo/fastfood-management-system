package fastfood;

import fastFoodView.*;
import java.util.Scanner;
import fastFoodModelos.Gerente;
import fastFoodModelos.Empleado;
import fastFoodDAO.EmpleadoDAO;
import fastFoodDAO.GerenteDAO;
import fastFoodBD.*;
import fastFoodControladores.LoginControlador;
import fastFoodModelos.Rol;
import fastFoodService.EmpleadoService;
import fastFoodService.GerenteService;

public class principal {

    public static void main(String[] args) {

        new EmpleadoBD();
        new GerenteBD();
        new IngredienteBD();
        new PedidoBD();
        new ProductoBD();

        LoginControlador loginController = new LoginControlador();

        loginController.iniciarSesion();
        
}
}
