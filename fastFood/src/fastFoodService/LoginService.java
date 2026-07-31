package fastFoodService;

import fastFoodModelos.Empleado;
import fastFoodModelos.Gerente;
import fastFoodModelos.Persona;

public class LoginService {

    private EmpleadoService empleadoService;
    private GerenteService gerenteService;

    public LoginService() {

        empleadoService = new EmpleadoService();
        gerenteService = new GerenteService();

    }

    public Persona iniciarSesion(String usuario, String clave) {

        Gerente gerente = gerenteService.iniciarSesion(usuario, clave);

        if (gerente != null) {

            return gerente;

        }

        Empleado empleado = empleadoService.iniciarSesion(usuario, clave);

        if (empleado != null) {

            return empleado;

        }

        return null;

    }

    public Gerente loginGerente(String usuario, String clave) {

        return gerenteService.iniciarSesion(usuario, clave);

    }

    public Empleado loginEmpleado(String usuario, String clave) {

        return empleadoService.iniciarSesion(usuario, clave);

    }

}
