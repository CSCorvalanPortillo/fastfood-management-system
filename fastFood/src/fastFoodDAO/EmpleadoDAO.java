package fastFoodDAO;

import fastFoodBD.EmpleadoBD;
import fastFoodModelos.Empleado;
import java.util.List;
import java.util.ArrayList;

public class EmpleadoDAO implements EmpleadoInterDAO {

    private EmpleadoBD empleadoBD;

    public EmpleadoDAO() {
        empleadoBD = new EmpleadoBD();
    }

    @Override
    public Empleado login(String usuario, String clave) {

        List<Empleado> empleados = empleadoBD.leerTodos();

        for (Empleado empleado : empleados) {

            if (empleado.getUsuario().equals(usuario)
                    && empleado.getContraseña().equals(clave)) {

                return empleado;

            }

        }

        return null;

    }

    @Override
    public Empleado buscarPorDni(String dni) {

        List<Empleado> empleados = empleadoBD.leerTodos();

        for (Empleado empleado : empleados) {

            if (empleado.getDNI().equals(dni)) {
                return empleado;
            }

        }

        return null;

    }

    @Override
    public void guardar(Empleado objeto) {

        empleadoBD.guardar(objeto);

    }

    @Override
    public void modificar(Empleado objeto) {

        List<Empleado> empleados = empleadoBD.leerTodos();

        boolean encontrado = false;
        int i = 0;

        while (i < empleados.size() && !encontrado) {

            if (empleados.get(i).getID().equals(objeto.getID())) {

                empleados.set(i, objeto);
                encontrado = true;

            }

            i++;
        }

        if (encontrado) {
            empleadoBD.sobrescribir(empleados);
        } else {
            System.out.println("No se encontró el empleado a modificar.");
        }

    }

    @Override
    public void eliminar(String id) {

        List<Empleado> empleados = empleadoBD.leerTodos();

        empleados.removeIf(empleado -> empleado.getID().equals(id));

        empleadoBD.sobrescribir(empleados);

    }

    @Override
    public Empleado buscar(String id) {

        List<Empleado> empleados = empleadoBD.leerTodos();

        for (Empleado empleado : empleados) {

            if (empleado.getID().equals(id)) {
                return empleado;
            }

        }

        return null;

    }

    @Override
    public List<Empleado> listar() {

        return empleadoBD.leerTodos();

    }

}
