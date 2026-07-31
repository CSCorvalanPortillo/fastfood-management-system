package fastFoodControladores;

import fastFoodModelos.Empleado;
import fastFoodModelos.Gerente;
import fastFoodModelos.Rol;
import fastFoodService.LoginService;
import fastFoodView.CocineroMenu;
import fastFoodView.GerenteMenu;
import fastFoodView.MenuLogin;
import fastFoodView.VendedorMenu;

public class LoginControlador {

    private LoginService loginService;
    private MenuLogin menuLogin;

    public LoginControlador() {

        loginService = new LoginService();
        menuLogin = new MenuLogin();

    }

    public void iniciarSesion() {

        menuLogin.MostrarMenu();

        String usuario = menuLogin.pedirUsuario();
        String clave = menuLogin.pedirContraseña();

        Gerente gerente = loginService.loginGerente(usuario, clave);

        if (gerente != null) {

            menuLogin.mostrarBienvenida(gerente.getNombre());

            GerenteControlador gerenteControlador = new GerenteControlador();

            gerenteControlador.iniciarMenu();

            return;

        }

        Empleado empleado = loginService.loginEmpleado(usuario, clave);

        if (empleado != null) {

            menuLogin.mostrarBienvenida(empleado.getNombre());

            if (empleado.getRol() == Rol.VENDEDOR) {
                VendedorControlador vendedorControlador = new VendedorControlador(empleado.getID());

                vendedorControlador.iniciarMenu();

            } else if (empleado.getRol() == Rol.COCINERO) {

                CocineroControlador cocineroControlador = new CocineroControlador();
                cocineroControlador.iniciarMenu();

            }

            return;

        }

        menuLogin.mostrarLoginIncorrecto();

    }

}
