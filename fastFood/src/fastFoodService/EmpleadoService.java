package fastFoodService;

import fastFoodDAO.EmpleadoDAO;
import fastFoodModelos.Empleado;
import java.util.List;

public class EmpleadoService {

    private EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        empleadoDAO = new EmpleadoDAO();
    }

    public void registrarEmpleado(Empleado empleado) {

        if (empleadoDAO.buscar(empleado.getID()) != null) {

            System.out.println("El ID ya está registrado.");
            return;

        }

        if (empleadoDAO.buscarPorDni(empleado.getDNI()) != null) {

            System.out.println("El DNI ya está registrado.");
            return;

        }

        empleadoDAO.guardar(empleado);

    }

    public void modificarEmpleado(Empleado empleado) {
        empleadoDAO.modificar(empleado);
    }

    public void eliminarEmpleado(String id) {
        empleadoDAO.eliminar(id);
    }

    public Empleado buscarEmpleado(String id) {
        return empleadoDAO.buscar(id);
    }

    public Empleado buscarPorDni(String dni) {
        return empleadoDAO.buscarPorDni(dni);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoDAO.listar();
    }

    public Empleado iniciarSesion(String usuario, String clave) {
        return empleadoDAO.login(usuario, clave);
    }
}
